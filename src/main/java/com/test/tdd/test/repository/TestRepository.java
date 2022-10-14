package com.test.tdd.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.tdd.test.entities.TestEntity;

@Repository
public interface TestRepository  extends CrudRepository<TestEntity, Integer>  {
    @Query("select hs from TestEntity hs where hs.active=true")
	List<TestEntity> findAllActive();
}
