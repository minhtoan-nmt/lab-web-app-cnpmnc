package vn.edu.hcmut.cse.adsoftweng.lab.validator;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import vn.edu.hcmut.cse.adsoftweng.lab.error.ErrorMessage;

@Component
public class StudentInputValidator {
    

    public String validate(Student student, Model model) {
        if (student.getAge() <= 0 || student.getId() == null || student.getEmail() == null) {
            model.addAttribute("errMsg", ErrorMessage.NOT_FILLED);
            return "update_student_failed";
        } else if (student.getAge() > 30) {
            model.addAttribute("errMsg", ErrorMessage.INVALID_AGE);
            return "update_student_failed";
        }
        return ErrorMessage.NO_ERROR;
    }
}
