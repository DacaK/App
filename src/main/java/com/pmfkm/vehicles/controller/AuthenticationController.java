package com.pmfkm.vehicles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmfkm.vehicles.config.JwtTokenUtil;
import com.pmfkm.vehicles.model.Employee;
import com.pmfkm.vehicles.model.JwtRequest;
import com.pmfkm.vehicles.model.JwtResponse;
import com.pmfkm.vehicles.service.EmployeeService;

@CrossOrigin("http://localhost:4200")
@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@PostMapping(value = "/register")
	@ResponseBody
	public String saveUser(@RequestBody Employee employee) throws Exception {
		if(!employeeService.isEmailAlreadyInUse(employee.getEmail())) {
			return "User with this email address already exist";
		}
		if(!employeeService.isUsernameAlreadyTaken(employee.getUsername())) {
			return "User with this username already exist";
		}
		employeeService.saveEmployee(employee);
		return "User is registered successfully";
	}

	@PostMapping(value = "/login")
	public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = employeeService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return new JwtResponse(token);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception  e) {
			throw new Exception("User_disabled", e);
		
		}
		
	}
}
