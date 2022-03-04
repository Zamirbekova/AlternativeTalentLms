package com.hadicha.controller;

import com.hadicha.entity.Student;
import com.hadicha.entity.Teacher;
import com.hadicha.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class ControllerTeacher {
    private final TeacherService teacherService;
@Autowired
    public ControllerTeacher(TeacherService teacherService) {
        this.teacherService = teacherService;

    }
    @GetMapping("/getAllTeacher")
    public String getAllTeacher(Model model){
        model.addAttribute("modelGetAllTeacher",teacherService.getAllTeacher());
        return "teacher/getAllTeacher";
    }
    @GetMapping("/new")
    public String newTeacher(Model model){
        model.addAttribute("modelNewTeacher",new Teacher());
        return "teacher/newTeacher";
    }
    @PostMapping("/save")
    public String saveTeacher(@ModelAttribute("newModelTeacher") Teacher teacher){
        teacherService.saveTeacher(teacher);
        return "redirect:/teacher";

    }
    @GetMapping("/{id}")
    public String getTeacherById(@PathVariable("id") int id, Model model){
        model.addAttribute("modelTeacherByID",teacherService.getById(id));
        return "teacher/getTeacherById";
    }
    @GetMapping("/{id}/editTeacher")
    public String editTeacher(@PathVariable("id") int id,Model model){
        model.addAttribute("modelEditTeacher",teacherService.getById(id));
        return "teacher/editTeacher";
    }
    @PostMapping("/{id}/edit")
    public String updateTeacher(@PathVariable("id") int id,@ModelAttribute("modelEditTeacher") Teacher teacher){
        teacherService.updateTeacher(teacher);
        return "redirect:/teacher";
    }
    @PostMapping("/{id}")
    public String deleteTeacher(@PathVariable("id") int id){
        teacherService.deleteTeacherById(id);
        return "redirect:/teacher";
    }
}