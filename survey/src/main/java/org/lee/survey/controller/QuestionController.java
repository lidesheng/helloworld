package org.lee.survey.controller;

import org.lee.survey.dao.QuestionDaoImpl;
import org.lee.survey.obj.OptionValue;
import org.lee.survey.obj.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


/**
 * Created by lee on 2016/6/30.
 */

@Controller
public class QuestionController {

    @Resource(name = "questionDao")
    private QuestionDaoImpl questionDao;

    @RequestMapping(value = "question/{surveyId}", method = RequestMethod.GET)
    public String question(Model model, @PathVariable("surveyId") int surveyId) {
        Question question = new Question();
        question.setSurveyId(surveyId);
        model.addAttribute("question", question);
        model.addAttribute("valueList", OptionValue.getDefaultValues());
        return "question";
    }
    @RequestMapping(value = "question", method = RequestMethod.POST)
    @ResponseBody
    public String questionEdit(Question question, HttpSession session) {
        System.out.println(question);
        String surveyId = String.valueOf(question.getSurveyId());
        Object questioned = session.getAttribute(surveyId);
        if (questioned == null) {
            session.setAttribute(surveyId, surveyId);
        } else {
            return "you have finished this question, please don't submit more than once!";
        }
        questionDao.save(question);
        return "submit success!";
    }

    public void setQuestionDao(QuestionDaoImpl questionDao) {
        this.questionDao = questionDao;
    }
}
