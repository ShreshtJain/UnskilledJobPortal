package com.persistent.config;

import java.util.Collection;
import java.util.List;
import java.util.Arrays;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.persistent.entity.Users;

public class CustomUserDetails implements UserDetails {
	
	//private static final int of = ;
	private Users user;
	
	public CustomUserDetails(Users user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(user.getRoles());
		
		 
		return Arrays.asList(simpleGrantedAuthority);
		//return List.of(simpleGrantedAuthority);
	}
	
	

	@Override
	public String getPassword() {
		
//		if(user.getRoles()=="Role_User")
//			return "normal";
//		else
//			return "admin";
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		//return user.getUserId()+"";
		return user.getAadhar();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	
}
