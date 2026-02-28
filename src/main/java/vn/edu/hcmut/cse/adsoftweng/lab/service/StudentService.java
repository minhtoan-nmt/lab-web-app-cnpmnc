package vn.edu.hcmut.cse.adsoftweng.lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import vn.edu.hcmut.cse.adsoftweng.lab.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Student> searchByName(String keyword) {
        // TODO Auto-generated method stub
        return repository.findByName(keyword);
    }

    public List<Student> searchByKeyword(String keyword) {
        // TODO Auto-generated method stub
        return repository.findByKeywords('%' + keyword + '%');
    }

    public boolean saveStudent(Student student) {
        // TODO Auto-generated method stub
        if (repository.existsById(student.getId())) {
            return false;
        }
        repository.save(student);
        return true;
    }

    public void deleteStudent(String id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    public void updateStudent(Student student) {
        // TODO Auto-generated method stub
        repository.save(student);
    } 

}
