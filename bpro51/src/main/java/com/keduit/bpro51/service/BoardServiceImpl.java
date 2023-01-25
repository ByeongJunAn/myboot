package com.keduit.bpro51.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.keduit.bpro51.dto.BoardDTO;
import com.keduit.bpro51.dto.PageRequestDTO;
import com.keduit.bpro51.dto.PageResultDTO;
import com.keduit.bpro51.entity.Board;
import com.keduit.bpro51.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository repository;
	
	@Override
	public Long register(BoardDTO dto) {
		
		log.info("DTO-----------");
		log.info(dto);
		
		Board entity = dtoToEntity(dto);
		log.info(entity);
		
		repository.save(entity);
		
		return entity.getBno();
	}

	@Override
	public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO) {

		Pageable pageable = requestDTO.getPageable(Sort.by("bno").descending());
		Page<Board> result = repository.findAll(pageable);
		
		Function<Board, BoardDTO> fn = (entity -> entityToDto(entity));
		return new PageResultDTO<>(result, fn);
	}

}
