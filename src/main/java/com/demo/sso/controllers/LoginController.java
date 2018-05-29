package com.demo.sso.controllers;

import com.demo.sso.model.Usuario;
import com.demo.sso.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.demo.sso.utils.EncrytedPasswordUtils.encrytePassword;

/**
 * @author alain.menchaca on 13/04/18.
 */
@Controller
public class LoginController {

    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping({"", "/", "/login"})
    public String login(Model model){

        //TODO delete log levels
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


    /**
     * This method reads a token for a specific user to hidde  the parameter in the restorePass page
     * so we can know the user is updating the password.
     * This method is for email restore functionality.
     *
     * @param model
     * @param token sent to the user's email.
     * @return
     */
    @RequestMapping(value = "/restore/{token}")
    public String restoreName(Model model, @PathVariable String token){
        model.addAttribute("token", token);
        return "restorePass";
    }

    @RequestMapping("/restore")
    public String restore(Model model, @RequestParam(value = "token", defaultValue = "") String token,
        @RequestParam(value = "password", defaultValue = "pass") String password,
        @RequestParam(value = "confirm", defaultValue = "") String confirm,
        @RequestParam(value = "loaded", defaultValue = "false") Boolean loaded){

        if(!loaded){
            return "restorePass";
        }else if(!password.equals(confirm)){
            model.addAttribute("restoreError", true);
            return "restorePass";
        }

        List<Usuario> usuario = userRepository.findByTokenAndEnabled(token, Boolean.TRUE);
        usuario.get(0).setPassword(encrytePassword(password)); // TODO throw exception if more than one user
        logger.info("New USUARIO:" + usuario);
        userRepository.save(usuario.get(0));
        return "successRestorePass";
    }
}
