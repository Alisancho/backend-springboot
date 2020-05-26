package com.javabegin.backendspringboot.controller;

import com.javabegin.backendspringboot.entity.Stat;
import com.javabegin.backendspringboot.service.StatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "Stat", description = "PriorityController")
public class StatController {

    private final StatService statService;
    private final Long defaultId = 1L;

    public StatController(StatService statService) {
        this.statService = statService;
    }

    @GetMapping("/stst")
    @ApiOperation(value = "Получить список всех значений из базы")
    public ResponseEntity<Stat> findByAll() {
        return ResponseEntity.ok(statService.findById(defaultId));
    }
}
