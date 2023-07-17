package org.zerock.Mapper;

import java.util.List;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	// BoardMapper를 bean에 주입

	@Test
	public void testGetList() { // 목록 확인 테스트
		mapper.getList().forEach(board -> log.info(board));
	}

	 @Test public void testInsert() { // 게시글 추가 테스트
	  
	 BoardVO board = new BoardVO();
	 		 board.setTitle("새로 작성하는 글");
	 		 board.setContent("새로 작성하는 내용"); 
	 		 board.setWriter("newbie");
	 
	 mapper.insert(board); // mapper에 board 추가
	 
	 log.info(board); }
	 
	 @Test public void testInsertSelectKey() { // 특정 키를 가지고 게시글 추가 테스트
	 
	 BoardVO board = new BoardVO(); 
	 	board.setTitle("AAATest test");
	 	board.setContent("AAAContent 내용"); 
	 	board.setWriter("tester");
	 
	 mapper.insertSelectKey(board);
	 
	 log.info("---------------------------");
	 log.info("after insert select " +
	 board.getBno()); }
	
	@Test
	public void testRead() { // 게시글 보기 테스트
		BoardVO board = mapper.read(29L); // 29번째 게시글 읽기
		
		log.info(board); // 게시글 콘솔에 출력
	}
	@Test
	public void testDelete() { // 게시글 삭제 테스트
		
		log.info("DELETE COUNT: "+ mapper.delete(25L)); // 25번째 글 삭제
	}
	
	@Test
	public void testUpdate() { // 게시글 수정 테스트
		
		BoardVO board = new BoardVO();
		board.setBno(27L); // 27번째 게시글 수정
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
	 // board.setWriter("user00"); - 게시글의 작성자는 수정되면 안됨
		
		int count = mapper.update(board);
		log.info("update COUNT: "+ count);
	}
	
	@Test
	public void testPaging() { // 페이징 기능 테스트
		Criteria cri = new Criteria();
		
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board.getBno()));
	}
	
	@Test
	public void testSearch() { // 검색기능 테스트
		
		Criteria cri = new Criteria();
		cri.setKeyword("새로");
		cri.setType("TC");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board-> log.info(board));
	}
	
	
}
