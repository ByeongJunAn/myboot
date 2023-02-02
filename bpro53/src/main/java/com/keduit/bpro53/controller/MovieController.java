package com.keduit.bpro53.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keduit.bpro53.dto.MovieDTO;
import com.keduit.bpro53.dto.PageRequestDTO;
import com.keduit.bpro53.service.MovieService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/movie")
@Log4j2
@RequiredArgsConstructor
public class MovieController {

	private final MovieService movieService;
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(MovieDTO movieDTO, RedirectAttributes redirectAttribute) {
		
		log.info("movieDTO: " + movieDTO);
		
		Long mno = movieService.register(movieDTO);
		
		redirectAttribute.addFlashAttribute("msg",mno);
		
		return "redirect:/movie/list";
	}
	
	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model) {
		
		log.info("pageRequestDTO: " + pageRequestDTO);
		
		model.addAttribute("result", movieService.getList(pageRequestDTO));
		
	}
}