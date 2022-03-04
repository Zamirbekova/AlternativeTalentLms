package com.hadicha.controller;


import com.hadicha.entity.Student;
import com.hadicha.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class ControllerStudent {
    private final StudentService service;
@Autowired
    public ControllerStudent(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllStudent(Model model){
    model.addAttribute("modelGetAllStudent",service.getAllStudent());
    return "student/getAllStudent";
    }
    @GetMapping("/new")
    public String newStudent(Model model){
    model.addAttribute("modelNewStudent",new Student());
    return "student/newStudent";
    }
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("newModelStudent") Student student){
    service.saveStudent(student);
    return "redirect:/student";

    }
    @GetMapping("/{id}")
    public String getStudentById(@PathVariable("id") int id, Model model){
        model.addAttribute("modelStudentByID",service.getById(id));
        return "student/getStudentById";
    }
    @GetMapping("/{id}/editStudent")
    public String editStudent(@PathVariable("id") int id,Model model){
        model.addAttribute("modelEditStudent",service.getById(id));
        return "student/editStudent";
    }
    @PostMapping("/{id}/edit")
    public String updateStudent(@PathVariable("id") int id,@ModelAttribute("modelEditStudent") Student student){
        service.updateStudent(student);
        return "redirect:/student";
    }
    @PostMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int id){
       service.deleteStudentById(id);
        return "redirect:/student";
    }
}

