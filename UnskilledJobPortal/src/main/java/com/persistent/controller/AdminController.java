package com.persistent.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.persistent.dao.IUsersDAO;
import com.persistent.entity.Category;
import com.persistent.entity.Message;
import com.persistent.entity.Users;
import com.persistent.service.CategoryService;
import com.persistent.service.UsersService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CategoryService adminUserService;
	
	@Autowired
	private IUsersDAO userRepository;
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="/admin_add_category",method=RequestMethod.GET)
	public String admin_add_category(Model m,Principal principal) {
		
		//-----checking if session valid------//	
		if(principal==null)
			return "redirect:/login";
		else
			if(usersService.getUserByAadharNo(principal.getName()).getRoles().equals("ROLE_USER"))
				return "redirect:/login";
		//---------session check over----------//


		
		Category c = new Category();
		m.addAttribute("category", c);
		return "admin/admin_add_category";
	}
	
	@RequestMapping( value = "/process_category",method = RequestMethod.POST)
	public String saveCategory(@Valid @ModelAttribute("category") Category category,BindingResult res , Model model,HttpSession session,Principal principal) {
		//-----checking if session valid------//	
		if(principal==null)
			return "redirect:/login";
		else
			if(usersService.getUserByAadharNo(principal.getName()).getRoles().equals("ROLE_USER"))
				return "redirect:/login";
		
		//---------session check over----------//
		
		
		try {
			if(res.hasErrors()) {
				model.addAttribute("category", category);
				session.setAttribute("message", new Message("Something Went Wrong !", "alert-danger"));
				return "admin/admin_add_category";
			}
			adminUserService.addCategory(category);
			session.setAttribute("message", new Message("Successfully Inserted !", "alert-success"));
			return "admin/admin_add_category";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("category", category);
			session.setAttribute("message", new Message("Something Went Wrong !"+ e.getMessage(), "alert-danger"));
			return "admin/admin_add_category";
			
		}	
		
		
	}
	
	@RequestMapping(value="/admin_viewallcategory",method=RequestMethod.GET)
	public String admin_viewallcategory(Model m,Principal principal) {
		//-----checking if session valid------//	
		if(principal==null)
			return "redirect:/login";
		else
			if(usersService.getUserByAadharNo(principal.getName()).getRoles().equals("ROLE_USER"))
				return "redirect:/login";
		//---------session check over----------//
		
		m.addAttribute("category", adminUserService.getAllCategories());
		return "admin/admin_viewallcategory";
	}
	

//	left for future scope......
	
//	@RequestMapping(value ="/admin_deletecategory",method = RequestMethod.POST)
//	public String deleteCategory(@ModelAttribute(value="cat") Category catNew, Model model,Principal principal ) {
//		
//		//-----checking if session valid------//	
//		if(principal==null)
//			return "redirect:/login";
//		else
//			if(usersService.getUserByAadharNo(principal.getName()).getRoles().equals("ROLE_USER"))
//				return "redirect:/login";
//		//---------session check over----------//
//		
//		adminUserService.deleteCategory(catNew.getCategoryId());   
//	    
//	    
//	    model.addAttribute("category", adminUserService.getAllCategories());
//	    System.out.println(model.getAttribute("category"));
//		return "redirect:/admin/admin_viewallcategory";  
//	}

	
//	@RequestMapping(value = "/delete/{category_id}",method = RequestMethod.GET)
//	public String deleteCategory(@PathVariable (value = "category_id") Integer category_id,HttpSession session) {
//		
//		
//		this.adminUserService.getCategoryById(category_id);
//		session.setAttribute("message", new Message("Category deleted Successfully..","alert-success"));
//		return "redirect:/admin/admin_viewallcategory";
//	}
	
	
	
	@RequestMapping(value="/admin_viewallusers",method=RequestMethod.GET)
	public String admin_viewalluser(Model model,Principal principal) {
		//-----checking if session valid------//	
		if(principal==null)
			return "redirect:/login";
		else
			if(usersService.getUserByAadharNo(principal.getName()).getRoles().equals("ROLE_USER"))
				return "redirect:/login";
		//---------session check over----------//
		model.addAttribute("title", "Users List");
		List<Users> user = (List<Users>) this.userRepository.findAll();
		model.addAttribute("user", user);
		return "admin/admin_viewallusers";
	}
	
//	left for future scope.....
	
//	@RequestMapping(value ="/admin_deleteuser",method = RequestMethod.POST)
//	public String deleteUser(@ModelAttribute(value="user") Users userNew, Model model,Principal principal ) {
//		
//		//-----checking if session valid------//	
//		if(principal==null)
//			return "redirect:/login";
//		else
//			if(usersService.getUserByAadharNo(principal.getName()).getRoles().equals("ROLE_USER"))
//				return "redirect:/login";
//		//---------session check over----------//
//		
//		userRepository.deleteById(userNew.getAadhar());  
//	    
//		List<Users> user = (List<Users>) this.userRepository.findAll();
//		model.addAttribute("user", user);
//	    System.out.println(model.getAttribute("category"));
//		return "redirect:/admin/admin_viewallusers";  
//	}
	

//	@RequestMapping(value = "/userdelete/{user_id}",method = RequestMethod.GET)
//	public String deleteUser(@PathVariable (value = "user_id") Integer user_id,HttpSession session) {
//		this.userRepository.findAadharByUserId(user_id);
//		session.setAttribute("message", new Message("Employee deleted Successfully..","alert-success"));
//		return "redirect:/admin/admin_viewallusers";
//	}

}
