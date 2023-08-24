package com.vk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vk.dto.Admin;
import com.vk.service.AdminService;


@Controller
public class AdminController {
	@Autowired
    private AdminService adminService ;
	
	@RequestMapping("/createadmin")
	public ModelAndView createAdmin() {
		ModelAndView mav = new ModelAndView("addadmin.jsp") ;
		Admin admin = new Admin() ;
		mav.addObject("admin", admin) ;
		return mav ;
	}
	
	@RequestMapping("/saveadmin")
	public ModelAndView saveAdmin(@ModelAttribute Admin admin) {
		ModelAndView mav = new ModelAndView("Login.jsp") ;
		adminService.saveAdmin(admin) ;
		return mav ;
	}
}
