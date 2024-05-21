package minkostplan.application.UIcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    /**
     * Handles the access-denied page request.
     *
     * @return the access-denied view
     */
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
