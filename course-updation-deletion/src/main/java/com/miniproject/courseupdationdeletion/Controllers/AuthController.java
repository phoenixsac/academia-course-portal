package com.miniproject.courseupdationdeletion.Controllers;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.miniproject.courseupdationdeletion.Entities.User;
import com.miniproject.courseupdationdeletion.Exception.UserNotFoundException;
import com.miniproject.courseupdationdeletion.Exception.UserUnauthorizedException;
import com.miniproject.courseupdationdeletion.RequestBody.JwtRequest;
import com.miniproject.courseupdationdeletion.ResponseBody.JwtResponse;
import com.miniproject.courseupdationdeletion.Service.JwtHelper;
import com.miniproject.courseupdationdeletion.Service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;

    @Autowired
    PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) throws UserUnauthorizedException, UserNotFoundException {
        try {

            this.doAuthenticate(request.getEmail(),request.getPassword());
            User user = userService.loadUserByUsername(request.getEmail());
            logger.info("checking get with jwt");
            String token = this.helper.generateToken(user);

            JwtResponse response = JwtResponse.builder()
                    .jwtToken(token)
                    .username(user.getUsername()).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            // Handle other exceptions
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
