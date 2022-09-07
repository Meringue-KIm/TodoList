package com.study.TodoList.repository;

import com.study.TodoList.entity.Tdl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TdlRepository extends JpaRepository<Tdl,Long> {


}
