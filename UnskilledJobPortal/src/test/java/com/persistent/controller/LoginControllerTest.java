package com.persistent.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.persistent.entity.Users;
import com.persistent.service.JobService;
import com.persistent.service.UsersService;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

	@Autowired
	private LoginController loginController ; 
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private JobService jobService;
	
	@Mock
	Model model;
	
	@BeforeEach
	public void setupAuthentication(){
	    SecurityContextHolder.getContext().setAuthentication(new AnonymousAuthenticationToken("GUEST","USERNAME", AuthorityUtils.createAuthorityList("USER", "ADMIN")));
	}
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(loginController).isNotNull();
	}
	

	@Test
	public void loginControllerTest() throws Exception {
	
		//when(userService.updateUserProfile(user)).thenReturn(user);
		
		mockMvc.perform(get("/signup")).andExpect(status().isOk()).andExpect(view().name("signup"));
		
		mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("login"));
		
		mockMvc.perform(get("/all_job_list")).andExpect(status().isOk()).andExpect(view().name("all_job_list"));
		
				
		
	}
	
	@Test
	@Transactional
	public void signupUser() throws Exception
	{
		Users user=new Users();
		
		user.setUserId(1);
		user.setAadhar("111122223333");
		user.setFirstName("Ritika");
		user.setLastName("Jadhav");
		user.setContact("8871957133");
		user.setAddress("Ayodhya Bypass Road , Bhopal");
		user.setGender("F");
		user.setPassword(passwordEncoder.encode("ritika"));
		user.setRoles("ROLE_USER");
		
		MockHttpServletRequestBuilder request = post("/do_register").flashAttr("user", user) ;
		this.mockMvc.perform(request).andExpect(status().isOk()) ; 
		
		// User Authentication
		UsernamePasswordAuthenticationToken authReq
	      = new UsernamePasswordAuthenticationToken("111122223333", "ritika");
		AuthenticationManager auth = new AuthenticationManager() {
							
		@Override
		public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				return authentication;
		}
		};
		
//		UsernamePasswordAuthenticationToken authReq2
//	      = new UsernamePasswordAuthenticationToken("555566667777", "admin");
//		AuthenticationManager auth2 = new AuthenticationManager() {
//							
//		@Override
//		public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//				return authentication;
//		}
//		};
//		
//		SecurityContext sc2 = SecurityContextHolder.getContext();
//		sc2.setAuthentication(auth2.authenticate(authReq2));
		
	}
//	
//	@Test
//	public void dashboardNext() throws Exception
//	{
////		MockHttpServletRequestBuilder request = get("/do_register").flashAttr("user", user) ;
////		this.mockMvc.perform(request).andExpect(status().isOk()) ;
//		
//		mockMvc.perform(get("/dashboard")).andExpect(status().isOk()).andExpect(view().name("dashboard"));
//	}
//	
//	@Test
//	public void dashboardt() throws Exception
//	{
////		MockHttpServletRequestBuilder request = get("/do_register").flashAttr("user", user) ;
////		this.mockMvc.perform(request).andExpect(status().isOk()) ;
//		
//		mockMvc.perform(get("/dashboard")).andExpect(status().isOk()).andExpect(view().name("dashboard"));
//	}
	
}
