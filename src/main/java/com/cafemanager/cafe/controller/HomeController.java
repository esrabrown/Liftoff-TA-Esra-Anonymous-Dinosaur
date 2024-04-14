package com.cafemanager.cafe.controller;

import com.cafemanager.cafe.entity.User;
import com.cafemanager.cafe.model.LoginUserBean;
import com.cafemanager.cafe.model.SignupUserBean;
import com.cafemanager.cafe.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@SpringBootApplication
@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView setUpIndexPage() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginForm() {
     return new ModelAndView("login", "loginUserBean", new LoginUserBean());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLoginForm(@ModelAttribute("loginUserBean") @Validated LoginUserBean loginUserBean,
                                   BindingResult bindingResult, HttpSession session, ModelMap model,
                                   RedirectAttributes redirectAttributes) {


        if(bindingResult.hasErrors()){
           System.out.println(bindingResult.getErrorCount());
           model.addAttribute("msg", "Login Error");
           return "login";
        }

        User user = userService.findByUserEmail(loginUserBean.getUserEmail());
        if (user == null) {
         model.addAttribute("msg", "There is no user with this name.");
         model.addAttribute("user", loginUserBean);
         return "login";
        }

        if(!user.getPassword().equals(loginUserBean.getUserPassword())) {
            model.addAttribute("msg", "Please Check Your Password!");
            model.addAttribute("user", loginUserBean);
            return "login";
        }

        //session.setAttribute("loginUser", user);
       redirectAttributes.addFlashAttribute("user", user);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//       session.setAttribute("loggedUser", user);

        return "redirect:/displayAccountInfo";
    }

 @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.setAttribute("loginUser", null);
        return "redirect:/";

 }

}


