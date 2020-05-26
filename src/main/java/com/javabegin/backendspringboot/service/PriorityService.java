package com.javabegin.backendspringboot.service;

import com.javabegin.backendspringboot.entity.Priority;
import com.javabegin.backendspringboot.repository.PriorityRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PriorityService {

    private final PriorityRepository repository; // сервис имеет право обращаьтся к репозиторию (БД)

    public PriorityService(PriorityRepository repository) {
        this.repository = repository;
    }

    public List<Priority> findAll() {
        return repository.findAllByOrderByIdAsc();
    }

    public Priority add(Priority priority) {
        return repository.save(priority); // метод save обновляет или создает новый объект, если его не было
    }

    public Priority update(Priority priority){
        return repository.save(priority); // метод save обновляет или создает новый объект, если его не было
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Priority findById(Long id){
        return repository.findById(id).get(); // т.к. возвращается Optional - нужно получить объект методом get()
    }

    public List<Priority> findByTitle(String text){
        return repository.findByTitle(text);
    }

}
