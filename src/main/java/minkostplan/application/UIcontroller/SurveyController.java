package minkostplan.application.UIcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import minkostplan.application.usecase.SurveyService;

@Controller
public class SurveyController {
    
    @Autowired
    private SurveyService surveyService;
}
