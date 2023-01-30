package com.keduit.bpro52.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO { //DTO는 데이터를 가져와서 화면에 뿌리는 역할을 하므로 화면에 나타낼 데이터를 생각하고 가져오도록 한다
	
	private Long bno;
	private String title;
	private String content;
	private String writerEmail;
	private String writerName;
	private LocalDateTime regDate;
	private LocalDateTime UpdateDate;
	private int replyCount;
}
