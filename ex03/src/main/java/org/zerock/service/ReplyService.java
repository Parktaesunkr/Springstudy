package org.zerock.service;

import java.util.List;


import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	
	
	public int register(ReplyVO vo); // 등록
	
	public ReplyVO get(Long rno); // 답변 번호
	
	public int modify(ReplyVO vo); // 수정
	
	public int remove(Long rno); // 삭제
	
	public List<ReplyVO> getList(Criteria cri, Long bno); // 답변 목록
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno); // 답변 리스트

}
