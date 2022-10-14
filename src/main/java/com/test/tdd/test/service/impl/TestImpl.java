package com.test.tdd.test.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.test.tdd.test.exception.TestException;
import com.test.tdd.test.mapper.TestMapper;
import com.test.tdd.test.models.response.TestResponse;
import com.test.tdd.test.repository.TestRepository;
import com.test.tdd.test.service.TestService;
import com.test.tdd.test.util.TestError;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class TestImpl implements TestService{

    private TestRepository testRepository;
    private TestMapper testMapper;


    @Override
    public List<TestResponse> findAllTest() throws TestException {
        log.debug("TestImpl.findAllTest (no prms)");
        final var testAll = testRepository.findAllActive();
        if(CollectionUtils.isEmpty(testAll)){
            log.error("TestImpl.findAllTest no elements found in repository");
            throw new TestException(TestError.BAD_REQUEST_INVALID_ARGUMENTS);
        }
        var lsTestResponse = testRepository.findAllActive().
        stream().map(testMapper::toResponse).collect(Collectors.toList());
        return lsTestResponse;
    }

    @Override
    public TestResponse findTestByCode(Integer code) throws TestException {
        // TODO Auto-generated method stub
        return null;
    }
    
}