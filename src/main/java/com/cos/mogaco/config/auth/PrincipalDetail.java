package com.cos.mogaco.config.auth;

import org.apache.catalina.User;

import lombok.Getter;

@Getter
public class PrincipalDetail implements UserDetails {
	private User user;
	
	public PrincipalDetail(User user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

}
