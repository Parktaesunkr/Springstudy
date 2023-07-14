package org.zerock.Mapper;

import java.util.List;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	// 테스트 전 해당 번호의 게시물이 존재하는지 반드시 확인 할 것
	private Long[] bnoArr = { 327683L, 327682L, 327681L, 327680L, 327679L };
	
	
	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		
		// 3145745L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2, 10);
		
		// 327701L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 327701L);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	
	
	@Test
	public void testUpdate() {
		
		Long targetRno = 10L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("Update Reply");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT :"+ count);
	}
	
	
	@Test
	public void testDelete() {
		
		Long targetRno = 5L; // Mapper의 delete의 데이터 타입과 일치 해야함
		
		mapper.delete(targetRno);
	}
	
	@Test
	public void testRead() {
		
		Long targetRno = 5L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		log.info(vo);
		
	}

	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach( i -> {
			ReplyVO vo = new ReplyVO();
			
			// 게시물 번호
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글테스트 "+1);
			vo.setReplyer("replyer"+1);
			
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testMapper() {
		
		log.info(mapper);
	}
	
}
