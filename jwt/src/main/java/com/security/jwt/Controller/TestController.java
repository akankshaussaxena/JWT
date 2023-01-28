package com.security.jwt.Controller;

import com.security.jwt.util.JWTUtil;
import model.AuthenticateRequest;
import model.AuthenticateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello-world";

    }

    @PostMapping("/name")
    @ResponseBody
    public String hello(@RequestBody String name){
        return name;

    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest authenticateRequest){
        UserDetails userDetails=userDetailsService.loadUserByUsername(authenticateRequest.getUserName());
        String jwt=jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticateResponse(jwt));
    }
}
