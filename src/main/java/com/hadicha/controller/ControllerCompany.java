package com.hadicha.controller;

import com.hadicha.entity.Company;
import com.hadicha.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/company")
public class ControllerCompany {

    private final CompanyService companyService;

    @Autowired
    public ControllerCompany(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public String getAllCompanies(Model model) {
        model.addAttribute("allCompanies", companyService.getAllCompany());
        return "company/allCompanies";
    }

    @GetMapping("get/{id}")
    public String getCompanyById(@PathVariable("id") int id, Model model) {
        model.addAttribute("companyById", companyService.getById(id));
        return "company/getByIdCompany";
    }

    @GetMapping("/new")
    public String newCompany(Model model) {
        model.addAttribute("newCompany", new Company());
        return "company/newCompany";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("newCompany") Company company) {
        companyService.saveCompany(company);
        return "redirect:/company";
    }

    @GetMapping("/{id}/editCompany")
    public String editCompany(@PathVariable("id") int id, Model model) {
        model.addAttribute("editCompany", companyService.getById(id));
        return "company/editCompany";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("editCompany") Company company, @PathVariable("id") int id) {
        companyService.updateCompany(company);
        return "redirect:/company";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        companyService.deleteCompanyById(id);
        return "redirect:/company";
    }
}