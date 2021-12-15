package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
	
	//JpaRepository는 인터페이스이다.
	//JpaRepository를 사용하려면 새 인터페이스를 작성하여 확장(extends)해야 한다.
	//JpaRepository<T, ID>가 Genetic Type을 받는 것에 주의.
	//	매개변수 T: 테이블에 매핑될 엔티티 클래스
	//	매개변수 ID: 이 엔티티의 기본 키의 타입
	//	==> 그러므로 TodoEntity와 기본키(id)의 타입 String을 작성했다.
	
	
	//JpaRepository가 기본 제공하는 쿼리가 아닌 것은 따로 구현해야 한다.
	
	List<TodoEntity> findByUserId(String userId);
	//이 메소드를 작성하면... 스프링 데이터 JPA가 메서드 이름을 파싱해서, 
	//'SELECT * from TodoRepository WHERE userId= '{userId}' '와 같은 쿼리를 작성해 실행한다.
	//메소드 이름: 쿼리에 들어갈 것
	//매개변수: where문에 들어갈 값
	
	/*
	//더 복잡한 쿼리는 @Query 어노테이션을 사용해서 지정할 수 있다.
	@Query("SELECT * from Todo t where t.userId= ?1") //1은 매개변수 순서 위치
	List<TodoEntity> findByUserid2(String userId);
	*/
}
