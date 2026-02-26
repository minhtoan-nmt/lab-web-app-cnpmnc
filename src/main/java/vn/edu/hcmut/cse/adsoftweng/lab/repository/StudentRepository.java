package vn.edu.hcmut.cse.adsoftweng.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByName(String name);
    @Query("SELECT s FROM Student s WHERE s.id LIKE :keyword OR s.name LIKE :keyword")
    List<Student> findByKeywords(String keyword);
}
