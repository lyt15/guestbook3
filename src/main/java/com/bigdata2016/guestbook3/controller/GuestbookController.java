package com.bigdata2016.guestbook3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigdata2016.guestbook3.dao.GuestbookDao;
import com.bigdata2016.guestbook3.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookDao guestbookDao;
	
	@RequestMapping( "/index" )
	public String index( Model model ){
		List<GuestbookVo> list = guestbookDao.getList();
		model.addAttribute( "list", list );
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping( "/deleteform/{no}" )
	public String deleform( @PathVariable( "no" ) Long no, Model model ) {
		model.addAttribute( "no", no );
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping( value="/delete", method=RequestMethod.POST )
	public String delete( @ModelAttribute GuestbookVo vo ) {
		System.out.println( vo );
		guestbookDao.delete( vo );
		return "redirect:/index";
	}
	
	@RequestMapping( value="/add", method=RequestMethod.POST )
	public String add( @ModelAttribute GuestbookVo vo ) {
		System.out.println( vo );
		guestbookDao.insert(vo);
		return "redirect:/index";
	}
	
	
	
	
	
	
}
