package org.lee.survey.controller;

import org.lee.survey.obj.Survey;
import org.lee.survey.service.SurveyServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by lee on 2016/6/30.
 */

@Controller
public class SurveyController {

    @Resource(name = "surveyService")
    private SurveyServiceImpl surveyService;

    @RequestMapping(value = "survey", method = RequestMethod.GET)
    public String survey(Model model) {
        model.addAttribute("survey", new Survey());
        return "survey";
    }

    @RequestMapping(value = "survey", method = RequestMethod.POST)
    public String surveyAdd(Survey survey) {
        System.out.println(survey);
        survey.setEnabled(true);
        int surveyId = surveyService.save(survey);
        return "redirect:/surveys";
    }

    @RequestMapping(value = "surveys", method = RequestMethod.GET)
    public String surveys(Model model) {
        List<Survey> surveys = surveyService.getAll();
        model.addAttribute("surveys", surveys);
        return "surveys";
    }

    @RequestMapping(value = "survey", method = RequestMethod.PUT)
    @ResponseBody
    public String surveyUpdate(Survey survey) {
        System.out.println(survey);
        surveyService.update(survey);
        return "update success!";
    }

    @RequestMapping(value = "statistics/{surveyId}", method = RequestMethod.GET)
    public String statistics(Model model, @PathVariable("surveyId") int surveyId) {
        model.addAttribute("statistics", surveyService.getStatistics(surveyId));
        return "statistics";
    }

    public void setSurveyService(SurveyServiceImpl surveyService) {
        this.surveyService = surveyService;
    }
}
