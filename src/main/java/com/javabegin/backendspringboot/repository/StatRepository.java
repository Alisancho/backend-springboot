package com.javabegin.backendspringboot.repository;

import com.javabegin.backendspringboot.entity.Stat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends CrudRepository<Stat,Long> {
}
