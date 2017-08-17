package com.controller;

import com.model.DemoRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/demo")
public class DemoController {
    private Log LOGGER= LogFactory.getLog(DemoController.class);
    @GetMapping
    public ModelAndView returnDemo(HttpServletRequest request){
        LOGGER.info(request.getRequestURL());
        ModelAndView mv=new ModelAndView();
        mv.setViewName("demo");
        return mv;
    }

    @GetMapping("/{demoArg}")
    public ModelAndView returnDemoTemplate(@PathVariable String demoArg){

        LOGGER.info("Path Variable in template:"+demoArg);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("demo");
        return mv;
    }

    @PostMapping
    @ResponseBody
    public String returnDemoPost(){
        return "Post request accepted";
    }

    @PostMapping("/{pathVar}")
    @ResponseBody
    public String returnDemoMatrixVar(@MatrixVariable(name = "q") String q){
        return "Response for matrixVar:"+q;
    }

    @PostMapping(consumes = "application/json")
    @ResponseBody
    public String returnDemoJson(@RequestBody String body){
        return "Response for json:"+body;
    }

    @PostMapping(consumes = "application/json",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String returnDemoJsonResponse(@RequestBody String body){
        return body;
    }

    @PostMapping(headers = "demoHeader=head")
    @ResponseBody
    public String returnDemoHeader(@RequestHeader String demoHeader){
        return "demoHeader Value:"+demoHeader;
    }
    @PostMapping("/model")
    @ResponseBody
    public String returnDemoModel(@ModelAttribute DemoRequest request, BindingResult result){
        return request.toString();
    }
}
