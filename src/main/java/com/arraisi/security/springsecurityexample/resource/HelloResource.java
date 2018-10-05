package com.arraisi.security.springsecurityexample.resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

    @GetMapping
    public String hello(@AuthenticationPrincipal UserDetails userDetails) {

        String username = userDetails.getUsername(); // DEBUG HASIL LOGIN
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities(); // DEBUG HASIL LOGIN
        authorities.forEach(authority -> System.out.println()); // DEBUG HASIL LOGIN

        return "Hello World!!!";
    }

}
