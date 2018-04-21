package com.demo.demo.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author alain.menchaca on 13/04/18.
 */
@Controller
public class LoginController {

    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @RequestMapping({"", "/", "/login"})
    public String login(Model model){
        logger.debug("logged in debug");
        logger.info("logged in info");
        logger.warn("logged in warn");
        logger.error("logged in error");
        logger.fatal("logged in fatal");
        return "login";
    }

    @RequestMapping("/login-error")
    public String error(Model model){
        model.addAttribute("loginError", true);
        return "login";
    }

}
