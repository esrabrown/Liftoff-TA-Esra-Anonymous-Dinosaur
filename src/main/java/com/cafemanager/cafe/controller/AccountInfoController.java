package com.cafemanager.cafe.controller;


import com.cafemanager.cafe.entity.Student;
import com.cafemanager.cafe.entity.User;
import com.cafemanager.cafe.model.SignupUserBean;
import com.cafemanager.cafe.model.StudentBean;
import com.cafemanager.cafe.service.StudentService;
import com.cafemanager.cafe.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountInfoController {
@Autowired
StudentService studentService;

 @RequestMapping (value = "/displayAccountInfo", method = RequestMethod.GET)
 public String displayAccountInfo(@ModelAttribute("user") User user, ModelMap model,HttpSession session, HttpServletRequest request) {

     List<Student> studentList = studentService.findAllStudent(user.getId());

  //   String firstName = studentList.get(0).getStudentFirstName();
     model.addAttribute("studentList", studentList);
     model.addAttribute("user", session.getAttribute("user"));

     return "accountinfo";
 }


    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView setupAddStudent() {

        StudentBean studentBean = new StudentBean();
        return new ModelAndView("addstudent", "student", studentBean);
    }



    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String processAddStudent(@ModelAttribute("student") Student student, BindingResult bindingResult, HttpSession session, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "addstudent";
        }

        // Retrieve the logged-in user's ID from the session
        User user = (User) session.getAttribute("loggedUser");
        if (user != null) {
            student.setUserId(user.getId());
        } else {
            model.addAttribute("error", "User ID is null. Please log in.");
            return "addstudent";
        }

        // Save the student with the user ID
        studentService.addStudent(student);
        return "redirect:/displayAccountInfo";
    }
}
