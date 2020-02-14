package com.ldg.dbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String write(@ModelAttribute ("criteria") Criteria criteria) {
		return "write";
	}
		
	@RequestMapping(value="/writeProc", method = RequestMethod.POST)
	public String write(@ModelAttribute("board") BoardVO board,@ModelAttribute ("criteria") Criteria criteria,RedirectAttributes rttr) {
		
		service.insert(board);
		
		rttr.addAttribute("page", criteria.getPage());
		rttr.addAttribute("PerPageNum", criteria.getPerPageNum());
		
		return "redirect:list";	
		
	}
		
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public String read(@RequestParam ("bno") int bno,Model model,@ModelAttribute ("criteria") Criteria criteria) {
		
		BoardVO board = service.selectOne(bno);	
		
		model.addAttribute("board", board);
		
		return "read";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam int bno, Model model,@ModelAttribute ("criteria") Criteria criteria) {
		
		BoardVO board = service.selectOne(bno);			
		
		model.addAttribute("board", board);
		
		return "update";
	}
	
	@RequestMapping(value="/updateProc", method = RequestMethod.POST)
	public String update(@ModelAttribute("board") BoardVO board,@ModelAttribute ("criteria") Criteria criteria,RedirectAttributes rttr) {		
		
		service.update(board);		
//		rttr.addAttribute("criteria", criteria);
	
		rttr.addAttribute("page", criteria.getPage());
		rttr.addAttribute("perPageNum", criteria.getPerPageNum());
		 
		return "redirect:list";		

	}
	
	@GetMapping("delete")
	public String delete(@RequestParam ("bno") int bno,@ModelAttribute ("criteria") Criteria criteria,RedirectAttributes rttr) {
		
		
		
		service.delete(bno);		
		
		rttr.addAttribute("page", criteria.getPage());
		rttr.addAttribute("perPageNum", criteria.getPerPageNum());
			
		return "redirect:list";
	}
	
}
