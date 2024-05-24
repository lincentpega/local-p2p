package com.lincentpega.localp2p;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/test-security")
public class TestSecurityController {

    @GetMapping
    public String testSecurity(Authentication authentication, Principal principal) {
        System.out.println();
        return "Hello, " + principal.getName();
    }
}
