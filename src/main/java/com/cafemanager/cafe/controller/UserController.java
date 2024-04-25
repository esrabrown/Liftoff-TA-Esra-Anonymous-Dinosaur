package com.cafemanager.cafe.controller;

import com.cafemanager.cafe.model.SignupUserBean;
import com.cafemanager.cafe.repository.UserRepository;
import com.cafemanager.cafe.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cafemanager.cafe.entity.User;


@SpringBootApplication
@Controller
public class UserController {


@Autowired
private UserRepository userRepository;

@Autowired
UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signupForm() {

        return new ModelAndView("signup", "user", new SignupUserBean());
    }

   @RequestMapping (value = "/signup", method = RequestMethod.POST)
    public String processSignUpForm(@ModelAttribute("user") @Validated SignupUserBean signupUserBean,
                                    BindingResult bindingResult, HttpSession session, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
       User existingUser = userRepository.findByEmail(signupUserBean.getUserEmail());

       if (existingUser != null) {
           String userError = "A user with this userEmail already exists.";
           System.out.print(userError);
           model.addAttribute("userError", userError);
           return "signup";
       }

       if (!signupUserBean.getUserPassword().equals((signupUserBean.getConfirmPassword()))) {
           String cpwdError = "The password comfirmation does not match.";
           System.out.print(cpwdError);
           model.addAttribute("confirmPw", cpwdError);
           return "signup";
       }

       User dto = new User();
       dto.setFirstName(signupUserBean.getFirstName());
       dto.setLastName(signupUserBean.getLastName());
       dto.setEmail(signupUserBean.getUserEmail());
       dto.setPassword(signupUserBean.getUserPassword());

       User user = userService.addUser(dto);
       if (user == null) {
           model.addAttribute("error", "Insertion Fail");
           return "signup";
       }
       User loginUser = (User) session.getAttribute("loginUser");
       session.setAttribute("loginUser",user);
       return "index";

   }

}
