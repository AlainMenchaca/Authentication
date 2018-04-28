package com.demo.demo.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @RequestMapping("/restore")
    public String restore(Model model, @RequestParam(value = "password", defaultValue = "pass") String password,
        @RequestParam(value = "confirm", defaultValue = "") String confirm,
        @RequestParam(value = "loaded", defaultValue = "false") Boolean loaded){

        logger.info("pass:"+ password + " confirm:" + confirm + " loaded:" + loaded);

        if(!loaded){
            return "restorePass";
        }else if(!password.equals(confirm)){
            model.addAttribute("restoreError", true);
            return "restorePass";
        }

        // TODO update de password in the database
        return "successRestorePass";
    }
}
