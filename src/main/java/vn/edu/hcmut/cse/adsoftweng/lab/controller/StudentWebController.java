package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import vn.edu.hcmut.cse.adsoftweng.lab.error.ErrorMessage;
import vn.edu.hcmut.cse.adsoftweng.lab.service.StudentService;
import vn.edu.hcmut.cse.adsoftweng.lab.validator.StudentInputValidator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/students")
public class StudentWebController {
    @Autowired
    private StudentService service;
    @Autowired
    private StudentInputValidator validator;

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

    @GetMapping("/{id}")
    public String getStudent(@PathVariable String id, Model model) {
        Student student = service.getById(id);
        model.addAttribute("sinhVien", student);
        return "student_details";
    }
    
    @GetMapping("/student_update")
    public String updateStudentPage(@RequestParam(required = false) String id, Model model) {
        //TODO: process POST request
        Student student;
        if (id != null && !id.isEmpty()) {
            student = service.getById(id);
            model.addAttribute("sinhVien", student);
        } else {
            model.addAttribute("sinhVien", new Student());
        }
        return "student_update";
    }

    @PostMapping("/student_update")
    public String updateStudent(@ModelAttribute("sinhVien") Student student, Model model) {
        //TODO: process POST request
        String valid = validator.validate(student, model);
        if (valid != ErrorMessage.NO_ERROR) {
            return valid;
        }
        service.updateStudent(student);
        return "redirect:/students";
    }
    
    @GetMapping("/student_creation")
    public String deleteStudent(Model model) {
        return "student_creation";
    }

    @PostMapping("/student_creation")
    public String addNewStudent(@ModelAttribute("sinhVien") Student student, Model model) {
        //TODO: process POST request
        String valid = validator.validate(student, model);
        if (valid != ErrorMessage.NO_ERROR) {
            return valid;
        }
        if (service.saveStudent(student))
            return "redirect:/students";
        else {
            model.addAttribute("errMsg", ErrorMessage.STUDENT_ID_EXISTED);
        }
        return "update_student_failed";
    }
}
