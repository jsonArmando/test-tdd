package com.test.tdd.test.exception;

import com.test.tdd.test.util.TestError;

import lombok.Getter;

@Getter
public class TestException extends Exception {
	private final TestError error;

    public TestException(TestError error) {
        super(error == null ? null : error.getMessage());
        this.error = error;
    }

    public TestException(TestError error, Exception exception) {
        super(exception);
        this.error = error;
    }
}