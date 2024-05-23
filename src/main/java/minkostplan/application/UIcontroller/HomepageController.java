package minkostplan.application.UIcontroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling homepage related requests.
 */
@Controller
public class HomepageController {

    /**
     * Handles the home page request.
     *
     * @return the homepage view
     */
    @GetMapping("/home")
    public String home() {
        return "homepage";
    }

    /**
     * Handles the footer page request.
     *
     * @return the footer view
     */
    @GetMapping("/footer")
    public String footer() {
        return "footer";
    }

    /**
     * Handles the about page request.
     *
     * @return the about page view
     */
    @GetMapping("/about")
    public String aboutPage(){
        return "aboutPage";
    }

}
