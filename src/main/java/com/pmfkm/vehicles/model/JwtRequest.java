package com.pmfkm.vehicles.model;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtRequest implements UserDetails {

	private static final long serialVersionUID = 5926468583005150707L;
	
	
	private String username;
	private String password;
	private String email;
    private Collection<? extends GrantedAuthority> authorities;
    
	public JwtRequest() {
	}

	public JwtRequest(String username, String password, String email,
			Collection<? extends GrantedAuthority> authorities) {
	
		this.username = username;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	


    

	
}
