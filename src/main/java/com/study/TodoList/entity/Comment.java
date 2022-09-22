package com.study.TodoList.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDate commentDate;

    @ManyToOne
    @JoinColumn(name = "tdl_id")//??
    private Tdl tdl;

}
