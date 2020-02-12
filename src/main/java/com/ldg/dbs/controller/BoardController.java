package com.ldg.dbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ldg.dbs.dto.BoardVO;
import com.ldg.dbs.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		model.addAttribute("list", service.selectAll());
		
		return "list";
	}	
	
	@RequestMapping("/write")
	public String write() {
		return "write";
	}
	
	@RequestMapping(value="/writeProc", method = RequestMethod.POST)
	public String write(@RequestParam String title, @RequestParam String content, @RequestParam String writer ) {
		
		BoardVO board = new BoardVO();
		
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		int result = service.insert(board);
		
		if(result == 1) {
			
		
		return "redirect:list";
		
		}else {
			
		return "write";
		
		}
	}
	
	
	
	
	
}
