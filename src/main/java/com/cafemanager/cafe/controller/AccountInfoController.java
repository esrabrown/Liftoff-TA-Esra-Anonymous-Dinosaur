package com.cafemanager.cafe.controller;


import com.cafemanager.cafe.entity.Student;
import com.cafemanager.cafe.entity.User;
import com.cafemanager.cafe.model.StudentBean;
import com.cafemanager.cafe.repository.UserRepository;
import com.cafemanager.cafe.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Objects;

@Controller
public class AccountInfoController {
    @Autowired
    StudentService studentService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/displayAccountInfo", method = RequestMethod.GET)
    public String displayAccountInfo(ModelMap model, HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            // Handle the case where the user is not found in the session, perhaps redirecting to the login page
            return "redirect:/login";
        }

        List<Student> studentList = studentService.findAllStudent(user.getUserId());
        model.addAttribute("studentList", studentList);
        session.setAttribute("loginUser", user);
        return "accountinfo";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView setupAddStudent() {

        StudentBean studentBean = new StudentBean();
        return new ModelAndView("addstudent", "student", studentBean);
    }

    //Adding Student in controller
    @PostMapping("/addStudent")
    public String processAddStudent(@ModelAttribute("student") @Validated StudentBean studentBean, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "addstudent";
        }
        //
        //error handling
        //

        Student stu = new Student();
        stu.setStudentId(studentBean.getStudentId());
        stu.setFirstName(studentBean.getFirstName());
        stu.setLastName(studentBean.getLastName());
        stu.setCafeteriaBalance(studentBean.getCafeteriaBalance());
        stu.setNote(studentBean.getNote());
        Integer userId = studentBean.getUserId();
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            stu.setUser(user);
            studentService.addStudent(stu);
            return "redirect:/displayAccountInfo";
        } else {
            model.addAttribute("error", "User not found.");
            return "addstudent";
        }

    }

    // Deleting Student Record
    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam(value = "studentId") Integer studentId, ModelMap model) {

        Student stu = studentService.findById(studentId);
        if (stu != null) {
            studentService.deleteStudent(studentId);
        }
        return "redirect:/displayAccountInfo";

    }

    @RequestMapping(value = "/addNote", method = RequestMethod.GET)
    public ModelAndView addNote(@RequestParam(value = "studentId") Integer studentId, ModelMap model) {

        Student stu = studentService.findById(studentId);
        StudentBean studentBean = new StudentBean();
        if (stu !=null) {
            studentBean.setStudentId(stu.getStudentId());
            studentBean.setFirstName(stu.getFirstName());
            studentBean.setLastName(stu.getLastName());
            studentBean.setCafeteriaBalance(stu.getCafeteriaBalance());
            studentBean.setNote(stu.getNote());
            studentBean.setUserId(stu.getUser().getUserId());
        }
        return new ModelAndView("addnote", "studentBean", studentBean);

    }

    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    public String processAddNote(@ModelAttribute("studentBean") @Validated StudentBean studentBean, BindingResult bindingResult, ModelMap model) {

        if (bindingResult.hasErrors()) {
            return "addnote";
        }

        Student stu = new Student();

        stu.setStudentId(studentBean.getStudentId());
        stu.setFirstName(studentBean.getFirstName());
        stu.setLastName(studentBean.getLastName());
        stu.setCafeteriaBalance(studentBean.getCafeteriaBalance());
        stu.setNote(studentBean.getNote());


        Integer userId = studentService.findById(stu.getStudentId()).getUser().getUserId();
        User user = userRepository.findById(userId).orElse(null);
        stu.setUser(user);

        if (stu != null) {
            studentService.addNote(stu);
        } else {
            model.addAttribute("error", "User not found.");
            return "addnote";
        }

        return "redirect:/displayAccountInfo";
    }

}




