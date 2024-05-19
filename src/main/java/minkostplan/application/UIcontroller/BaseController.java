package minkostplan.application.UIcontroller;

import java.security.Principal;

import jakarta.annotation.PostConstruct;
import minkostplan.application.usecase.CustomUserDetailsService;
import minkostplan.application.usecase.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import minkostplan.application.entity.Users;
import minkostplan.application.DBcontroller.user.UserRepository;


@Controller

public class BaseController {




    @GetMapping("")
    public String defaultpage() {
        return "homepage";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new Users());
        return "loginPage";
    }


}
        
