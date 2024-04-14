package com.cafemanager.cafe.repository;


import com.cafemanager.cafe.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentRepository extends CrudRepository <Student, Integer> {

    List<Student> findByUserId(Integer userId);
}
