package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller()
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

		public void basic() {
			log.info("basic.........");
		}
		
		@GetMapping("/basicOnlyGet")
		public void basicGet2() {
			log.info("basic get only get.........");
		}
		
		@GetMapping("/ex01")
		public String ex01(SampleDTO dto) {
			log.info(""+dto);
			
			return "ex01";
		}
		@GetMapping("/ex02")
		public String ex02(@RequestParam("name") String name,
				@RequestParam("age") int age) {
			log.info("name: " + name);
			log.info("age: " + age);
			
			return "ex02";
		}
		@GetMapping("/ex02List")
		public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
			
			log.info("ids: " + ids);
			// /sample/ex02List?ids=111&ids=222&ids=333
			// INFO : org.zerock.controller.SampleController - ids: [111, 222, 333]
			return "ex02List";
		}
	
		@GetMapping("/ex02Array")
		public String ex02Array(@RequestParam("ids") String[] ids) {
			
			log.info("array ids: " + Arrays.toString(ids));
			// /sample/ex02Array?ids=111&ids=222&ids=333&ids=444
			// INFO : org.zerock.controller.SampleController - array ids: [111, 222, 333, 444]
			return "ex02Array";
		}
		@GetMapping("/ex02Bean")
		public String ex02Bean(SampleDTOList list) {
			log.info("list dtos: " + list);
			// http://localhost:8092/sample/ex02Bean/?list[0].name=aaa&list[2].name=bbb ->에러발생([]인식 불가)
			// http://localhost:8092/sample/ex02Bean/?list%5B0%5D.name=aaa&list%5B1%5D.name=bbb&list%5B2%5D.name=CCC
			// INFO : org.zerock.controller.SampleController - list dtos: SampleDTOList(list=[SampleDTO(name=aaa, age=0), SampleDTO(name=bbb, age=0), SampleDTO(name=CCC, age=0)])
			return "ex02Bean";
		}
			@GetMapping("/ex04")
			public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
				log.info("dto : " + dto);
				log.info("page : " + page);
				// http://localhost:8092/sample/ex04/?name=aaa&age=10&page=11 ->
				return "/sample/ex04";
		}
			@GetMapping("/ex05")
			public void ex05(){
				log.info("/ex05..........");
				
			}
			@GetMapping("/ex06")
			public @ResponseBody SampleDTO ex06(){
				log.info("/ex06..........");
				SampleDTO dto = new SampleDTO();
				dto.setAge(10);
				dto.setName("홍길동");
				
				return dto;
			}
			@GetMapping("/ex07")
			public ResponseEntity<String> ex07(){
					String msg = "{\"name\": \"홍길동\"}";
					HttpHeaders header = new HttpHeaders();
					header.add("Content-Type", "application/json;charset=UTF-8");
					
				return new ResponseEntity<>(msg, header, HttpStatus.OK);
			}
}
