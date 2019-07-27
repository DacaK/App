package com.pmfkm.vehicles.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.pmfkm.vehicles.model.Employee;
import com.pmfkm.vehicles.model.JwtRequest;

public class JwtUserFactory {
	
	public static JwtRequest create(Employee employee) {
		return new JwtRequest(employee.getUsername(), employee.getPassword(), employee.getEmail(), maptoGrantedAuthorities(new ArrayList<String>(Arrays.asList("ROLE_"+employee.getAuthority().getRole()))));
	}

	private static List<GrantedAuthority> maptoGrantedAuthorities(List<String> authorities) {
		return authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority)).collect(Collectors.toList());
	}
}
