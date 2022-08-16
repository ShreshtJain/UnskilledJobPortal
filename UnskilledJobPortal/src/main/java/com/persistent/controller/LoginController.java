package com.persistent.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.persistent.entity.Message;
import com.persistent.entity.Users;

import com.persistent.service.JobService;
import com.persistent.service.UsersService;

@Controller
public class LoginController {

	public static HttpSession session;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private JobService jobService;

	
//main Home-page , accessible even if not logged in	
	@RequestMapping(value={"/all_job_list","/"},method=RequestMethod.GET)
	public String all_job_list(Model m)
	{		
		System.out.println("all Jobs available"+jobService.getAllJobs());
		m.addAttribute("allJobs",jobService.getAllJobs());
		return "all_job_list";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("user", new Users());
		return "signup";
	}
	
	

	//handller for signup
	@RequestMapping(value="/do_register",method=RequestMethod.POST)
	public String signupUser(@Valid @ModelAttribute("user") Users user,BindingResult res , Model model,HttpSession session) {
		
		try {
			if(res.hasErrors()) {
				model.addAttribute("user", user);
				session.setAttribute("message", new Message("Something Went Wrong !", "alert-danger"));
				return "signup";
			}
			user.setRoles("ROLE_USER");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			Users r=userService.registerUser(user);
			
			System.out.println("Table" +user);
			model.addAttribute("user", new Users());
			session.setAttribute("message", new Message("Successfully Registered !", "alert-success"));
			return "signup";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user );
			session.setAttribute("message", new Message("Something Went Wrong !"+ e.getMessage(), "alert-danger"));
			return "signup";
			
		}
	}
	

	
	@GetMapping("/user/dashboard")
	public String dashboard(Model m,Principal principal) {
		
		//-----checking if session valid------//	
				if(principal==null)
					return "redirect:/login";
				else
					if(userService.getUserByAadharNo(principal.getName()).getRoles().equals("ROLE_ADMIN"))
						return "redirect:/login";
		//---------session check over----------//

		
		int userId=userService.getUserByAadharNo(principal.getName()).getUserId();
		
		
		m.addAttribute("allJobs",jobService.getAllJobs());
		m.addAttribute("name",userService.getNameById(userId));
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboardNext(Model m,Principal principal) {
		
		
		//-----checking if session valid------//	
			if(principal==null)
				return "redirect:/login";
			else
				if(userService.getUserByAadharNo(principal.getName()).getRoles().equals("ROLE_ADMIN"))
					return "redirect:/login";
		//---------session check over----------//
		
		int userId=userService.getUserByAadharNo(principal.getName()).getUserId();
		
		
		m.addAttribute("allJobs",jobService.getAllJobs());
		m.addAttribute("name",userService.getNameById(userId));
		return "dashboard";
	}

	
}
