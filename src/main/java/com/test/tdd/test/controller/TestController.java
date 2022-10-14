package com.test.tdd.test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.tdd.test.exception.TestException;
import com.test.tdd.test.models.response.TestResponse;
import com.test.tdd.test.service.TestService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/test")
@Slf4j
public class TestController {

    private TestService service;
    @GetMapping("/getFindAll")
    public ResponseEntity<List<TestResponse>> findAll() throws TestException {
        log.debug("TestController.findAll call (no params)");
        var response = new ResponseEntity<>(service.findAllTest(),HttpStatus.OK);
        log.debug("TestController.findAll  response {}", response);
        return response;
      }
}
