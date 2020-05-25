package com.javabegin.backendspringboot.controller;

import com.javabegin.backendspringboot.entity.Stat;
import com.javabegin.backendspringboot.repository.StatRepository;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "Priority resources", description = "crud operations")
public class StatController {

    private final StatRepository statRepository;
    private final Long defaultId = 1L;

    public StatController(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @GetMapping("/stst")
    public ResponseEntity<Stat> findByAll() {
        return ResponseEntity.ok(statRepository.findById(defaultId).get());
    }
}
