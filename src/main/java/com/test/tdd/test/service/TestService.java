package com.test.tdd.test.service;

import java.util.List;

import com.test.tdd.test.exception.TestException;
import com.test.tdd.test.models.response.TestResponse;

public interface TestService {
    List<TestResponse> findAllTest() throws TestException;
    TestResponse findTestByCode(Integer code) throws TestException;
}
