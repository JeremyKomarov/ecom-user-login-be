package com.userLogin.userLogin.controller;

import com.userLogin.userLogin.model.TestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {

    @GetMapping("/test1")
    @CrossOrigin
    public ResponseEntity<?> test1() {
        return ResponseEntity.ok(new TestResponse("API Test1"));
    }

    @GetMapping("/test2")
    @CrossOrigin
    public ResponseEntity<?> test2() {
        return ResponseEntity.ok(new TestResponse("API Test2"));
    }

    @GetMapping("/test3")
    @CrossOrigin
    public ResponseEntity<?> test3() {
        return ResponseEntity.ok(new TestResponse("API Test3"));
    }
}
