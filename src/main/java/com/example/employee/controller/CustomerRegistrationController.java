package com.example.employee.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpHeaders;
import java.nio.charset.Charset;

//import static com.sun.tools.sjavac.Util.set;

@RestController
@Slf4j
@RequestMapping("/register")
public class CustomerRegistrationController {


//    HttpHeaders createHeaders(String username, String password){
//        return new HttpHeaders() {{
//            String auth = username + ":" + password;
//            byte[] encodedAuth = Base64.encodeBase64(
//                    auth.getBytes(Charset.forName("US-ASCII")) );
//            String authHeader = "Basic " + new String( encodedAuth );
//            set( "Authorization", authHeader );
//        }};
//    }
}
