package org.zerock.Mapper;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

	 @Test public void testInsert() {
	  
	 BoardVO board = new BoardVO(); board.setTitle("새로 작성하는 글");
	 board.setContent("새로 작성하는 내용"); board.setWriter("newbie");
	 
	 mapper.insert(board);
	 
	 log.info(board); }
	 
	 @Test public void testInsertSelectKey() {
	 
	 BoardVO board = new BoardVO(); board.setTitle("AAATest test");
	 board.setContent("AAAContent 내용"); board.setWriter("tester");
	 
	 mapper.insertSelectKey(board);
	 
	 log.info("---------------------------"); log.info("after insert select " +
	 board.getBno()); }
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(29L);
		
		log.info(board);
	}
	@Test
	public void testDelete() {
		
		log.info("DELETE COUNT: "+ mapper.delete(25L));
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		board.setBno(27L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
	 // board.setWriter("user00"); - 게시글의 작성자는 수정되면 안됨
		
		int count = mapper.update(board);
		log.info("update COUNT: "+ count);
	}
	
	
}
