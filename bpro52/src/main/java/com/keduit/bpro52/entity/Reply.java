package com.keduit.bpro52.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude="board")
public class Reply extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement와 같음
	private Long rno;
	private String text;
	private String replyer;
	
	@ManyToOne
	private Board board;
}
