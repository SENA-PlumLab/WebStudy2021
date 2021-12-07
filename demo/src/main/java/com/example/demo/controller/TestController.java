package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;

@RestController
@RequestMapping("test")
public class TestController {
	
	@GetMapping
	public String testController() {
		return "Hello world";
	}
	
	@GetMapping("/testGetMapping")
	public String testControllerWithPath() {
		return "Hello world with testGetMapping..";
	}
	
	@GetMapping("/{id}")
	public String testControllerWithVariable(@PathVariable(required = false) int id) {
		//(required = false)는 꼭 필요하지는 않다는 뜻
		return "Hello world with ID = "+id;
	}
	
	@GetMapping("/testRequestParam")
	public String testControllerRequestParam(@RequestParam(required = false) int id) {
		return "Hello world with ID = "+id;
	}
	
	@GetMapping("/testRequestBody")
	public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
		// TestRequestBodyDTO를 요청 바디로 받는 컨트롤러
		
		//@RequestBody TestRequestBodyDTO --> RequestBody로 보내오는 JSON을 TestRequestBodyDTO 오브젝트로 변환해서 가져오라는 뜻
		//이 때 요청 바디의 JSON은 내부가 의미적으로 TestRequestBodyDTO와 같아야 한다.
		return "hello world (ID="+testRequestBodyDTO.getId()+", message='"+testRequestBodyDTO.getMessage()+"')";
	}
	
	@GetMapping("/testResponseBody")
	public ResponseDTO<String> testControllerResponseBody(){
		//ResponseDTO를 리턴하는 컨트롤러
		
		List<String> list = new ArrayList<>();
		list.add("Hello world! I'm ResponseDTO");
		
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return response;
	}
	
	@GetMapping("/testResponseEntity")
	public ResponseEntity<?> testContorllerResponseEntity(){
		//ResponseEntity는 HTTP의 응답 바디 뿐만 아니라 여러 다른 매개변수들, 예를 들어 status나 header를 조작하고 싶을 때 사용 한다.
		//ResponseBody와 비교 했을 때, body는 차이 없지만... Entity의 경우에 헤더와 HTTP status를 조작할 수 있다는 점이 다르다.
		
		List<String> list = new ArrayList<>();
		list.add("Hello world! I'm ResponseEntity. And you got 400!");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		
		//http status를 400으로 설정
		return ResponseEntity.badRequest().body(response);
		//return TesponseEntity.ok().body(response);
	}
	
}
