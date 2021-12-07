package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {
	
	
	@Autowired
	private TodoRepository repository;
	
	public String testService() {
		
		//TodoEntity 생성
		TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
		//TodoEntity 저장
		repository.save(entity);
		//TodoEntity 검색
		TodoEntity savedEntity = repository.findById(entity.getId()).get();
		
		
		return savedEntity.getTitle();
	}
	
	
	
	//Validate 메소드 리팩토링
	private void validate(final TodoEntity entity) {
		
		// Validation 코드가 더 커지면 TodoBalidator.java 로 분리시킬 수 있다.
		if (entity == null) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("Entity cannot be null");
		}

		if (entity.getUserId() == null) {
			log.warn("Unknown User.");
			throw new RuntimeException("Unknown User.");
		}
	}
	
	//Create
	public List<TodoEntity> create(final TodoEntity entity){
		
		//validations
		validate(entity);
		
		repository.save(entity);
		log.info("Entity Id: {} is saved.", entity.getId());
		
		return repository.findByUserId(entity.getUserId());
		
	}
	
	//Retrieve
	public List<TodoEntity> retrieve(final String userId){
		return repository.findByUserId(userId);
	}
	
	//Update
	public List<TodoEntity> update(final TodoEntity entity){
		
		//1. 저장할 엔티티가 유효한지 확인.
		validate(entity);
		
		//2. 넙겨받은 엔티티의 id를 이용해서 TodoEntity를 가져온다. 존재하지 않으면 수정도 못함.
		final Optional<TodoEntity> original = repository.findById(entity.getId());
		
		original.ifPresent(todo -> {
			//3. 반환된 TodoEntity가 존재하면 값을 새 entity 값으로 덮어씌운다.
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			
			//4. DB에 새 값을 저장한다.
			repository.save(todo);
		});
		
		//5. 사용자의 모든 Todo 리스트를 반환한다.
		return retrieve(entity.getUserId());
	}
	
	//Delete
	public List<TodoEntity> delete(final TodoEntity entity){
		
		//1. 삭제할 엔티티가 유효한지 검사. 없는걸 삭제 못하니까...
		validate(entity);
		
		try {
			//2. 엔티티 삭제
			repository.delete(entity);
		}catch (Exception e) {
			//3. Exception 발생 시 id와 exception 내용을 로깅
			log.error("error deleting entity ", entity.getId(), e);
			
			//4. 컨트롤러로 exception을 보낸다. DB 내부 로직을 캡슐화 하기 위해서는 e를 리턴하지 않고 새 exception 오브젝트를 리턴해야 한다.
			throw new RuntimeException("error deleting entity "+entity.getId());
		}
		
		//5. 새 Todo 리스트를 가져와서 리턴한다.
		return retrieve(entity.getUserId());
	}
}
