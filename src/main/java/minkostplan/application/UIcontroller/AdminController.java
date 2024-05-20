package minkostplan.application.UIcontroller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); // get logged-in username

        if (!email.equals("test@mail.com")) {
            return "redirect:/access-denied";
        }

        return "adminPage";
    }
}
