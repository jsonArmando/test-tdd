package com.test.tdd.test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.test.tdd.test.entities.TestEntity;
import com.test.tdd.test.models.response.TestResponse;

@Mapper(componentModel = "spring")
public interface TestMapper {
    @Mapping(target = "code", source = "code")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "active", source = "active")
    TestResponse toResponse(TestEntity test);
}