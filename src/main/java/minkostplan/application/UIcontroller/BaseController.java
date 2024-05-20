package minkostplan.application.UIcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import minkostplan.application.entity.Users;

/**
 * Base controller for handling default and login pages.
 */
@Controller
public class BaseController {

    /**
     * Handles the default page request.
     *
     * @return the homepage view
     */
    @GetMapping("")
    public String defaultpage() {
        return "homepage";
    }

    /**
     * Handles the login page request.
     *
     * @param model the model to add attributes
     * @return the login page view
     */
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new Users());
        return "loginPage";
    }


}
        
