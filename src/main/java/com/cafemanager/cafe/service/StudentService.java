package com.cafemanager.cafe.service;

import com.cafemanager.cafe.entity.Student;
import com.cafemanager.cafe.entity.User;
import com.cafemanager.cafe.repository.StudentRepository;
import com.cafemanager.cafe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAllStudent(int id) {
    //    User userData = userRepository.findByEmail(userID);
        return  studentRepository.findByUserId(id);
    }

    public Student addStudent(Student student) {
        Student s = studentRepository.save(student);
        return studentRepository.save(student);
    }

}
