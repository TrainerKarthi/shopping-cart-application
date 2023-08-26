package com.vk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vk.dto.Merchant;
import com.vk.helper.Login;
import com.vk.service.MerchantService;

@Controller
public class MerchantController {

	@Autowired
	MerchantService merchantService ;
	
	@RequestMapping("/addmerchant")
	public ModelAndView addMerchant() {
		ModelAndView mav = new ModelAndView("addmerchant.jsp") ;
		Merchant merchant = new Merchant() ;
		mav.addObject("merchant",merchant) ;
		return mav ;
	}
	
	@RequestMapping("/savemerchant")
	public ModelAndView saveMerchant(@ModelAttribute Merchant merchant) {
		ModelAndView mav = new ModelAndView("/merchantlogin") ;
		merchantService.saveMerchant(merchant) ;
		return mav ;
	}
	
	@RequestMapping("/merchantlogin")
	public ModelAndView merchantlogin() {
		ModelAndView mav = new ModelAndView("MerchantLogin.jsp") ;
		Login login = new Login() ;
	    mav.addObject("login", login) ;
	    
	    return mav ;
	
	}
}
