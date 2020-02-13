package com.ldg.dbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ldg.dbs.dto.BoardVO;
import com.ldg.dbs.dto.Criteria;
import com.ldg.dbs.dto.PageMaker;
import com.ldg.dbs.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping("/list")
	public String list(@ModelAttribute ("criteria") Criteria criteria, Model model) {	
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(service.countPaging(criteria));			
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", service.selectAll(criteria));
		
		return "list";
	}	
	
	@RequestMapping("/write")
	public String write() {
		return "write";
	}
		
	@RequestMapping(value="/writeProc", method = RequestMethod.POST)
	public String write(@ModelAttribute("board") BoardVO board) {
		
		service.insert(board);
			
		return "redirect:list";	
		
	}
		
	@RequestMapping("/read")
	public String read(@RequestParam int bno,Model model) {
		
		BoardVO board = service.selectOne(bno);	
		
		model.addAttribute("board", board);
		
		return "read";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam int bno, Model model) {
		
		BoardVO board = service.selectOne(bno);			
		
		model.addAttribute("board", board);
		
		return "update";
	}
	
	@RequestMapping(value="/updateProc", method = RequestMethod.POST)
	public String update(@ModelAttribute("board") BoardVO board) {		
		
		service.update(board);		
			
		return "redirect:list";		

	}
	
	@GetMapping("delete")
	public String delete(@RequestParam ("bno") int bno) {
		
		service.delete(bno);		
			
		return "redirect:list";			
	}
	
}
