package com.vk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vk.dto.Admin;
import com.vk.helper.Login;
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
		ModelAndView mav = new ModelAndView("/login") ;
	
		adminService.saveAdmin(admin) ;
		return mav ;
	}
	
	@RequestMapping("/adminlogin")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("Login.jsp") ;
		Login login = new Login() ;
		mav.addObject("login", login) ;
		return mav ;
	}
	
	@RequestMapping("/adminloginvalidate")
	public ModelAndView loginValidate(@ModelAttribute Login login) {
		 if(adminService.findByEmailAndPassword(login.getEmail(), login.getPassword())) {
			 ModelAndView mav = new ModelAndView("adminmenu.jsp") ;
			 return mav ;
		 }
		 
		 else {
			 ModelAndView mav = new ModelAndView("Login.jsp") ;
			 mav.addObject("msg", "<h1> invalid credentials </h1> <br>") ;
			 return mav ;
		 }
	}
}
