package minkostplan.application.UIcontroller;
import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.usecase.UserService;
import minkostplan.application.usecase.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling homepage related requests.
 */
@Controller
public class HomepageController {

    private final UserUtil userUtil;
    private final UserRepository userRepository;

    @Autowired
    public HomepageController(UserUtil userUtil, UserRepository userRepository) {
        this.userUtil = userUtil;
        this.userRepository = userRepository;
        UserUtil.setUserRepository(userRepository);
    }


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
