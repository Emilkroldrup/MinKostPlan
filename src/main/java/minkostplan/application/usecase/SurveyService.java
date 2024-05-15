package minkostplan.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import minkostplan.application.DBcontroller.SurveyRepo;
import minkostplan.application.DBcontroller.SurveyRepoInterface;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepo surveyRepo;

    public SurveyService() {
        super();
    }
}
