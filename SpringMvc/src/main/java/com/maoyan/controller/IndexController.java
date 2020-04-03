package com.maoyan.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author Maoyan
 * @data 2020/4/2 16:49
 * @Version 1.0.0
 */
public class IndexController implements Controller {
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("index.jsp");
        modelAndView.addObject("message","Hello Spring MVC");
        return modelAndView;
    }
}
