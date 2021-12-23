package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.model.TodoEntity;
import com.example.demo.service.TodoService;


@RestController
@RequestMapping("todo")
public class TodoController {
	
	@Autowired
	private TodoService service;
	
/*
	@GetMapping
	public ResponseEntity<?> testTodo() {
		
		TodoEntity response = TodoEntity.builder()
												.id("id123")
												.userId("userId")
												.title("title123")
												.done(false)
												.build();
		
		return ResponseEntity.ok().body(response);
	}
*/
	
	@GetMapping("/test")
	public ResponseEntity<?> testTodo2(){
		String str = service.testService(); //테스트 서비스 사용
		List<String> list = new ArrayList<>();
		list.add(str);
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		
		return ResponseEntity.ok().body(response);
		
	}
	
	@PostMapping
	public ResponseEntity<?> createTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto){
		
		
		
		try {

			//1. TodoEntity로 변환
			TodoEntity entity = dto.toEntity(dto);
			
			//2. id를 null로 초기화한다. 생성 당시에는 id가 없어야하기 때문
			entity.setId(null);
			
			//3. 임시 사용자 아이디를 설정해준다. 지금은 인증 기능이 없으므로 한 사용자(temporary-user)만 로그인 없이 사용할 수 있다.
			//token 추가 후 수정: userId로 설정!
			entity.setUserId(userId);
			
			//4. 서비스를 이용해 Todo 엔티티 생성
			List<TodoEntity> entities = service.create(entity);
			
			//5. 자바 스트림을 이용해 리턴 된 엔티티 리스트를 DTO 리스트로 변환한다.
			List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
			
			//6. 변환 된 TodoDTO 리스트를 이용해 ResponseDTO를 초기화 한다.
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
			
			//7. responseDTO를 return 한다
			return ResponseEntity.ok().body(response);
		}catch (Exception e) {
			String error = e.getMessage();
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> retrieveTodo(@AuthenticationPrincipal String userId){
		
		//1. 서비스 베소드의 retrieve() 메소드를 사용해 Todo 리스트를 가져온다. 
		//token 추가 후 수정: userId로 설정!
		List<TodoEntity> entities = service.retrieve(userId);
		
		//2. 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환한다.
		List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
		
		//3. 변환된 TodoDTO 리스트를 이용해서 ResponseDTO를 초기화
		ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
		
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping
	public ResponseEntity<?> updateTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto){
		
		//1. dto를 entity로 변환
		TodoEntity entity = dto.toEntity(dto);
		
		//2. id를 temporaryUserId로 초기화 //token 추가 후 수정: userId로 설정!
		entity.setUserId(userId);
		
		//3. 서비스를 이용해서 entity를 업데이트
		List<TodoEntity> entities = service.update(entity);
		
		//4. 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환
		List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
		
		//5. 변환된 TodoDTO 리스트를 이용해서 ResponseDTO를 초기화
		ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
		
		//6. ResponseDTO 리턴
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto){
		try {
			
			//1. TodoEntity로 변환
			TodoEntity entity = dto.toEntity(dto);
			
			//2. 임시 사용자 아이디 설정 //token 추가 후 수정: userId로 설정!
			entity.setUserId(userId);
			
			//3. 서비스를 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환
			List<TodoEntity> entities = service.delete(entity);
			
			//4.  자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환
			List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
			
			//5. 변환된 TodoDTO 리스트를 이용해서 ResponseDTO를 초기화
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
			
			//6. ResponseDTO 리턴
			return ResponseEntity.ok().body(response);
		}catch (Exception e) {
			
			//7. 예외가 있는 경우 dto 대신 error를 메시지에 넣어 리턴
			String error = e.getMessage();
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
}
