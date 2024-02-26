package com.example.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.CustomUserDetailsService;
import com.example.services.JwtUtil;
import com.example.services.UserManager;
import com.example.demo.JwtResponse;
import com.example.entities.User;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	@Autowired
	private JwtUtil jwtutil;
	   
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
    private UserManager userManager;

	@PostMapping(value="api/signup")
    public void registerCompany(@RequestBody User Reg) {

        System.out.println("hello");
        userManager.createUser(Reg);
    }
	

	@PostMapping(value="api/login")
    public boolean validateUser(@RequestBody User Reg) {
		return userManager.validateUser(Reg);
    }	 
	
	
	@PostMapping(value="api/token")
    public ResponseEntity<?> generateToken(@RequestBody User userreg) {
        try {
            System.out.println("Inside token method");
            System.out.println(userreg);
            boolean user = userManager.validateUser(userreg);
            System.out.println("User is present?" + user);
            if (!user) {
                throw new UsernameNotFoundException("Credentials don't match");
            }
            customUserDetailsService.setPassword(userreg.getPassword());
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(userreg.getUsername());
            String token = jwtutil.generateToken(userDetails);
            System.out.println("JWT " + token);
            System.out.println("username is"+userreg.getUsername());
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception ee) {
            ee.printStackTrace();
            return null;
        }
    }

}