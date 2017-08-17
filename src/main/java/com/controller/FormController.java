package com.controller;

import com.model.LoginObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form")
public class FormController {
    @GetMapping("/getForm")
    public ModelAndView getForm() {
        ModelAndView mv=new ModelAndView("loginForm");
        mv.addObject(new LoginObject());
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView loginHome(@ModelAttribute("loginObject") LoginObject loginObject, BindingResult bindingResult){
        ModelAndView mv=new ModelAndView("loginForm");
        bindingResult.addError(new ObjectError("loginObject","Error occured while saving"));
        mv.addObject(bindingResult);
        mv.addObject(loginObject);
        return mv;
    }

}
