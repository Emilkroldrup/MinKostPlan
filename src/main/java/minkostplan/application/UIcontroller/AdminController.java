package minkostplan.application.UIcontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling admin related requests.
 */
@Controller
public class AdminController {

    @Value("${admin.email}")
    private String adminEmail;

    /**
     * Handles the admin page request.
     *
     * @return the admin page view
     */
    @GetMapping("/admin")
    public String adminPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); // get logged-in username

        if (!email.equals(adminEmail)) {
            return "redirect:/access-denied";
        }

        return "adminPage";
    }
}
