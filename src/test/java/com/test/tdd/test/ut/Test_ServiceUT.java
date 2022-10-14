package com.test.tdd.test.ut;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import com.test.tdd.test.entities.TestEntity;
import com.test.tdd.test.exception.TestException;
import com.test.tdd.test.mapper.TestMapper;
import com.test.tdd.test.mapper.TestMapperImpl;
import com.test.tdd.test.models.response.TestResponse;
import com.test.tdd.test.repository.TestRepository;
import com.test.tdd.test.service.TestService;

import java.util.Date;

@RunWith(JUnit4.class)
public class Test_ServiceUT {
    @Mock
    TestRepository repository;

    TestMapper testMapper;
    TestService testService;

    List<TestResponse> lstResponse;
    List<TestEntity> testList;

    @Before("")
    public void initialLoad() {
        testMapper = new TestMapperImpl();
        testList = new ArrayList<>();
        testList.add(new TestEntity(1, "Jose", new Date(), Boolean.TRUE));
        testList.add(new TestEntity(2, "Armando", new Date(), Boolean.TRUE));

        lstResponse = testList.stream()
                .map(ls -> new TestResponse(ls.getCode(), ls.getName(), ls.getDate(), Boolean.TRUE, null, null))
                .collect(Collectors.toList());
    }

    @Test
	public void shouldFindAllTestWhenSuccessResult() throws TestException {
		when(repository.findAllActive()).thenReturn(testList);
		List<TestResponse> result = testService.findAllTest();
		assertEquals(lstResponse, result);
	}
}
