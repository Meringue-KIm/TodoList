package com.study.TodoList.service;

import com.study.TodoList.entity.Tdl;
import com.study.TodoList.repository.TdlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TdlService {

    @Autowired
    private TdlRepository tdlRepository;

    public void write(Tdl tdl) {
        LocalDate now = LocalDate.now();
        tdl.setDate(now);
        tdlRepository.save(tdl);
    }

    public List<Tdl> findList() {
        return tdlRepository.findAll();
    }

    public void delete(Tdl tdl) {
        tdlRepository.deleteById(tdl.getId());
    }

    public Tdl view(Long id) {
        return tdlRepository.findById(id).get();
    }

}
