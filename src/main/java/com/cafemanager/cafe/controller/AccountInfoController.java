package com.cafemanager.cafe.controller;


import com.cafemanager.cafe.entity.Student;
import com.cafemanager.cafe.entity.User;
import com.cafemanager.cafe.model.SignupUserBean;
import com.cafemanager.cafe.model.StudentBean;
import com.cafemanager.cafe.repository.UserRepository;
import com.cafemanager.cafe.service.StudentService;
import com.cafemanager.cafe.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountInfoController {
@Autowired
StudentService studentService;

    @Autowired
    UserRepository userRepository;
// @RequestMapping (value = "/displayAccountInfo", method = RequestMethod.GET)
// public String displayAccountInfo(@ModelAttribute("loggedUser") User user, ModelMap model,HttpSession session, HttpServletRequest request) {
//
//     model.addAttribute("student",new Student());
//     session.setAttribute("loginUser", user);
//     return "accountinfo";
// }

    @RequestMapping(value = "/displayAccountInfo", method = RequestMethod.GET)
    public String displayAccountInfo(ModelMap model, HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            // Handle the case where the user is not found in the session, perhaps redirecting to the login page
            return "redirect:/login";
        }

        List<Student> studentList = studentService.findAllStudent(user.getUserId());
        model.addAttribute("studentList", studentList);
    //    model.addAttribute("student", new Student());
        //model.addAttribute("loginUser", user); // Add the user to the model if needed
        session.setAttribute("loginUser", user);
        return "accountinfo";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView setupAddStudent() {

        StudentBean studentBean = new StudentBean();
        return new ModelAndView("addstudent", "student", studentBean);
    }

    @PostMapping("/addStudent")
    public String processAddStudent(@ModelAttribute("student") @Validated Student student, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "accountinfo";
        }
        Integer userId = student.getUser().getUserId();
        User user = userRepository.findById(userId).orElse(null);
          if (user != null) {
              student.setUser(user);
              studentService.addStudent(student);
              return "redirect:/displayAccountInfo";
          }else {
              model.addAttribute("error", "User not found.");
              return "accountinfo";
          }
    }
}
