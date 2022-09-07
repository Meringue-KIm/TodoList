package com.study.TodoList.controller;

import com.study.TodoList.entity.Tdl;
import com.study.TodoList.service.TdlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TdlController {

    @Autowired
    private TdlService tdlService;

    @GetMapping("/todolist")
    public String viewMain(Model model) {
        model.addAttribute("list", tdlService.findList());
        return "todoListMain";
    }

    @PostMapping("/todolist/writepro")
    public String writePro(Tdl tdl) {
        tdlService.write(tdl);
        return "redirect:/todolist";
    }

    @GetMapping("/todolist/delete")
    public String delete(Tdl tdl) {
        tdlService.delete(tdl);
        return "redirect:/todolist";
    }

    @PostMapping("/todolist/update/{id}")
    public String update(@PathVariable("id") Long id, Tdl updateTdl) { //d값이 없어서 못찾은듯 타이틀만 넘어왔기 때문
        Tdl tdlTemp = tdlService.view(id);
        tdlTemp.setTitle(updateTdl.getTitle());
        tdlService.write(tdlTemp);
        return "redirect:/todolist";
    }

//    @PostMapping("/todolist/list")
//    public String viewList(Model model) {
//        model.addAttribute("list", tdlService.findList());
//        return "todoListMain";
//    }


}
