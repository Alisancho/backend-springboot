package com.javabegin.backendspringboot.repository;

import com.javabegin.backendspringboot.entity.Category;
import com.javabegin.backendspringboot.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<Priority,Long> {
    List<Priority> findAllByOrderByIdAsc();
}
