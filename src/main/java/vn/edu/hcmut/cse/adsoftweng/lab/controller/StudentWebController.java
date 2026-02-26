package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import vn.edu.hcmut.cse.adsoftweng.lab.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/students")
public class StudentWebController {
    @Autowired
    private StudentService service;

    @GetMapping("")
    public String getAllStudents(@RequestParam(required = false) String keyword, Model model) {
        List<Student> students;

        if (keyword != null && !keyword.isEmpty()) {
            students = service.searchByKeyword(keyword);
        } else {
            students = service.getAll();
        }

        model.addAttribute("dsSinhVien", students);

        return "students";
    }
    
}
