package com.persistent.controller;


import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.persistent.dao.IJobDAO;
import com.persistent.entity.Users;
import com.persistent.service.CategoryService;
import com.persistent.service.UsersService;

@Controller
public class TestControllerForFrontEnd {
	
	
	@Autowired
	private UsersService userService;
	
	
		@RequestMapping(value="/homepage",method=RequestMethod.GET)
		public String homepage(Principal principal) {
			return "homepage";
		}
		
		@RequestMapping(value="/profile",method=RequestMethod.GET)
		public String profile(Principal principal,Model model) {


			//-----checking if session valid------//	
			if(principal==null)
				return "redirect:/login";
			else
				if(userService.getUserByAadharNo(principal.getName()).getRoles().equals("ROLE_ADMIN"))
					return "redirect:/login";
			
			//---------session check over----------//
			model.addAttribute("user", userService.getUserByAadharNo(principal.getName()));
			
			return "profile";
		}
		
		
		//Updated User Profile
		@GetMapping("/update_profile/{userId}")
		public String Update_profile(@PathVariable(value = "userId") int userId,Model model,Principal principal) {
			
			//-----checking if session valid------//	
			if(principal==null)
				return "redirect:/login";
			else
				if(userService.getUserByAadharNo(principal.getName()).getRoles().equals("ROLE_ADMIN"))
					return "redirect:/login";
			
			//---------session check over----------//
		
			String aadhar=userService.getUserAadharUsingUserId(userId);
			model.addAttribute("user", userService.getUserByAadharNo(aadhar));
			//model.addAttribute("user", user);
			return "profile_update";
		}
		
		@RequestMapping(value="/updates_profiles" ,method = RequestMethod.POST)
		public String updateproess(@ModelAttribute("user") Users user,Model model,Principal principal) {

			//-----checking if session valid------//	
			if(principal==null)
				return "redirect:/login";
			else
				if(userService.getUserByAadharNo(principal.getName()).getRoles().equals("ROLE_ADMIN"))
					return "redirect:/login";
			
			//---------session check over----------//
			
			
			Users u=userService.getUserByAadharNo(principal.getName());
			user.setAadhar(u.getAadhar());
			user.setPassword(u.getPassword());
			user.setUserId(u.getUserId());
			user.setGender(u.getGender());
			user.setRoles(u.getRoles());
			userService.registerUser(user);
			System.out.println("Updated User" +user);
			return "redirect:/profile";
		}
}

