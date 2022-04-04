package com.deadlifter.repository;

import com.deadlifter.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);
    Student findByFirstNameAndLastName(String firstName, String lastName);
}
