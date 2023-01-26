package com.keduit.bpro51.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.keduit.bpro51.entity.Board;
import com.keduit.bpro51.repository.search.BoardSearch;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

	
	@Query(value="select now()", nativeQuery=true)
	String getTime();

}
