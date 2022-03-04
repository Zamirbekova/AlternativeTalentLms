package com.hadicha.controller;

import com.hadicha.entity.Course;

import com.hadicha.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/course")
public class ControllerCourse {
    private final CourseService courseService;


    @Autowired
    public ControllerCourse(CourseService courseService) {
        this.courseService = courseService;

    }

    @GetMapping
    public String getAllCourse(Model model) {
        model.addAttribute("allCourse", courseService.getAllCourse());
        return "course/getAllCourse";
    }

    @GetMapping("/new")
    public String newCourse(Model model) {
        model.addAttribute("newCourse", new Course());
        return "course/newCourse";

    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("newCourse") Course course) {
        courseService.saveCourse(course);
        return "redirect:/course";
    }

    @GetMapping("/{id}")
    public String getCourseById(@PathVariable("id") int id, Model model) {
        model.addAttribute("courseById", courseService.getById(id));
        return "course/getCourseById";

    }

    @GetMapping("/{id}/editCourse")
    public String editCourse(@PathVariable("id") int id, Model model) {
        model.addAttribute("editcourse", courseService.getById(id));
        return "course/editCourse";
    }

    @PostMapping("/{id}/edit")
    public String updateCourse(@ModelAttribute("editcourse") Course course, @PathVariable("id") int id) {
        courseService.updateCourse(course);
        return "redirect:/course";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        courseService.deleteCourseById(id);
        return "redirect:/course";
    }
}