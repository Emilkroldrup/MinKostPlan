package minkostplan.application.UIcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import minkostplan.application.entity.Users;
import minkostplan.application.usecase.SurveyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class SurveyController {
    
    @Autowired
    private SurveyService surveyService;

    @PostMapping("/survey")
    public String submitSurvey(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam int age,
                               @RequestParam int height,
                               @RequestParam int weight,
                               @RequestParam String gender,
                               @RequestParam String goal,
                               @RequestParam String email,
                               @RequestParam String password,
                               Model model) {
        Users user = surveyService.createUser(firstName, lastName, age, height, weight, gender, goal, email, password);
        model.addAttribute("user", user);
        return "loginPage"; 
    }
    

    
}