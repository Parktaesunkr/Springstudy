package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	
	private int pageNum; // 페이지 번호
	private int amount; // 총 게시글
	
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10); // 페이지 당 게시글 수
	}
		
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		
		return type == null ? new String[] {} : type.split("");
	}
	
	public String getListLink() {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
			.queryParam("pageNum", this.pageNum)
			.queryParam("amount", this.getAmount())
			.queryParam("keyword", this.getKeyword())
			.queryParam("type", this.getType());
		
		return builder.toUriString();
			}

}
