package com.hadicha.controller;

import com.hadicha.entity.Group;
import com.hadicha.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/group")
public class ControllerGroup {
    private final GroupService groupService;

    @Autowired
    public ControllerGroup(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public String getAllGroup(Model model) {
        model.addAttribute("allModelGroup", groupService.getAllGroup());
        return "group/getAllGroup";

    }

    @GetMapping("/new")
    public String newGroup(Model model) {
        model.addAttribute("newModelGroup", new Group());
        return "group/newGroup";
    }

    @PostMapping("/save")
    public String saveGroup(@ModelAttribute("newModelGroup") Group group) {
        groupService.saveGroup(group);
        return "redirect:/group";
    }

    @GetMapping("/{id}")
    public String getGroupById(@PathVariable("id") int id, Model model) {
        model.addAttribute("modelGroupByID", groupService.getById(id));
        return "group/getGroupById";
    }

    @GetMapping("/{id}/editGroup")
    public String editGroup(@PathVariable("id") int id, Model model) {
        model.addAttribute("modelEditGroup", groupService.getById(id));
        return "group/editGroup";
    }

    @PostMapping("/{id}/edit")
    public String updateGroup(@PathVariable("id") int id, @ModelAttribute("modelEditGroup") Group group) {
        groupService.updateGroup(group);
        return "redirect:/group";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        groupService.deleteGroupById(id);
        return "redirect:/group";
    }
}