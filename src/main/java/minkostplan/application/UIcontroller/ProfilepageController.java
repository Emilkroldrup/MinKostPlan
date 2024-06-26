package minkostplan.application.UIcontroller;

import minkostplan.application.entity.Users;
import minkostplan.application.usecase.Caloriealgorithm;
import minkostplan.application.usecase.UserService;
import minkostplan.application.usecase.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller for handling profile page related requests.
 */
@Controller
public class ProfilepageController {


    private final UserService userService;
    private final Caloriealgorithm caloriealgorithm;

    @Autowired
    public ProfilepageController(UserService userService, Caloriealgorithm caloriealgorithm) {
        this.userService = userService;
        this.caloriealgorithm = caloriealgorithm;
    }

    /**
     * Handles the profile page request.
     *
     * @param model the model to add attributes
     * @return the profile page view
     */
    @GetMapping("/profile")
    public String profilepage(Model model) {
        Users user = UserUtil.getCurrentUser();
        model.addAttribute("calc", caloriealgorithm);
        model.addAttribute("User", user);
        System.out.println("Hej" + user);
        return "profilePage";
    }

    /**
     * Handles the profile picture change request.
     *
     * @return the profile page view
     */
    @PostMapping("/changeProfilePicture")
    public String profilePictureChange() {

        return "profilePage";
    }

    /**
     * Handles the edit profile page request.
     *
     * @param model the model to add attributes
     * @return the edit profile details view
     */
    @GetMapping("/editprofile")
    public String editProfilePage(Model model) {
        Users user = UserUtil.getCurrentUser();
        model.addAttribute("User", user);
        return "editProfileDetails";
    }


    /**
     * Handles the edit profile request.
     *
     * @param user  the user entity with updated details
     * @param model the model to add attributes
     * @return the edit profile details view
     */

    @PostMapping("/editprofile")
    public String editProfile(@ModelAttribute("User") Users user, Model model) {
        Users currentUserEmail = UserUtil.getCurrentUser();
        String editedEmail = user.getEmail();

        boolean editUserComplete = userService.editUserDetails(user);
        if (editUserComplete && !editedEmail.equals(currentUserEmail.getEmail())) {
            return "redirect:/login";
        } else {
            Users userUpdate = UserUtil.getCurrentUser();
            model.addAttribute("User", userUpdate);
            return "editProfileDetails";
        }
    }
}

