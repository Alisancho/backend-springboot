package com.javabegin.backendspringboot.service;

import com.javabegin.backendspringboot.entity.Stat;
import com.javabegin.backendspringboot.repository.StatRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StatService {

    private final StatRepository repository; // сервис имеет право обращаьтся к репозиторию (БД)

    public StatService(StatRepository repository) {
        this.repository = repository;
    }

    public Stat findById(Long id){
        return repository.findById(id).get();
    }
}
