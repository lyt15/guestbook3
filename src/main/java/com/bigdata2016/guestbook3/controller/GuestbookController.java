package com.bigdata2016.guestbook3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
