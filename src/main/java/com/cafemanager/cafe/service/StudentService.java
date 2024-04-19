package com.cafemanager.cafe.service;

import com.cafemanager.cafe.entity.Student;
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

    public List<Student> findAllStudent(int userId) {
        return studentRepository.findByUser_UserId(userId);
    }

   public void addStudent(Student student) {
      studentRepository.save(student);
   }

   //Deleting Student from database
   public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
   }

    public Student findById(int studentId) {
      return   studentRepository.findById(studentId).get();
    }

   public void addNote(Student stu) {
        Student student = studentRepository.findById(stu.getStudentId()).get();
        student = stu;
       studentRepository.save(student);
   }


}
