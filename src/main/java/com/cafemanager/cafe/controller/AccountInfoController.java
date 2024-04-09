package com.cafemanager.cafe.controller;


import com.cafemanager.cafe.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountInfoController {

@Autowired
UserService userService;

 @RequestMapping (value = "/displayAccountInfo", method = RequestMethod.GET)
    public String displayAccountInfo(ModelMap model, HttpServletRequest request) {
     return "accountinfo";
 }

}
