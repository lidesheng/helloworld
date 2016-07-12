package org.lee.survey.service;

import org.lee.survey.dao.QuestionDaoImpl;
import org.lee.survey.dao.SurveyDaoImpl;
import org.lee.survey.obj.ObjWrapperForSort;
import org.lee.survey.obj.Question;
import org.lee.survey.obj.Statistics;
import org.lee.survey.obj.Survey;

import java.util.*;

/**
 * Created by lee on 2016/7/11.
 */
public class SurveyServiceImpl {

    private SurveyDaoImpl surveyDao;

    private QuestionDaoImpl questionDao;

    public int save(Survey survey) {
        return surveyDao.save(survey);
    }

    public boolean update(Survey survey) {
        surveyDao.update(survey);
        return true;
    }

    public List<Survey> getAll() {
        return surveyDao.getAll();
    }

    public Statistics getStatistics(int surveyId) {
        Statistics statistics = new Statistics();
        List<Question> questions = questionDao.getAll(surveyId);
        Map<Integer, Integer> performanceMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> atmosphereMap = new HashMap<Integer, Integer>();
        Map<String, Integer> superStarMap = new HashMap<String, Integer>();
        for (Question question : questions) {
            aggregate(performanceMap, question.getPerformance());
            aggregate(atmosphereMap, question.getAtmosphere());
            aggregate(superStarMap, question.getSuperStar());
        }
        statistics.setPerformance(getResultFromAggregatedMap(performanceMap));
        statistics.setAtmosphere(getResultFromAggregatedMap(atmosphereMap));
        statistics.setSuperStar(getResultFromSuperStarMap(superStarMap));
        return statistics;
    }

    private void aggregate(Map map, Object key) {
        Integer performance = (Integer) map.get(key);
        if (performance == null) {
            map.put(key, 1);
        } else {
            map.put(key, performance + 1);
        }
    }

    private String getResultFromAggregatedMap(Map<Integer, Integer> aggregatedMap) {
        StringBuilder sb = new StringBuilder();
        float sum = 0;
        int count = 0;
        sb.append("<ul>");
        for (Map.Entry<Integer, Integer> entry : aggregatedMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            sb.append("<li>count(").append(key).append(") = ").append(value).append("</li>");
            sum += key * value;
            count += value;
        }
        sb.append("<li>average is: ").append(count == 0 ? "0" : String.valueOf(sum/count)).append("</li>");
        sb.append("</ul>");
        return sb.toString();
    }
    private String getResultFromSuperStarMap(Map<String, Integer> aggregatedMap) {
        List<ObjWrapperForSort> objWrapperForSorts = new ArrayList<ObjWrapperForSort>();
        for (Map.Entry<String, Integer> entry : aggregatedMap.entrySet()) {
            objWrapperForSorts.add(new ObjWrapperForSort(entry.getKey(), entry.getValue()));
        }
        Collections.sort(objWrapperForSorts, new Comparator<ObjWrapperForSort>() {
            public int compare(ObjWrapperForSort o1, ObjWrapperForSort o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>");
        for (ObjWrapperForSort o : objWrapperForSorts) {
            sb.append("<li>count(").append(o.getKey()).append(") = ").append(o.getValue()).append("</li>");
        }
        sb.append("</ul>");
        return sb.toString();
    }

    public void setSurveyDao(SurveyDaoImpl surveyDao) {
        this.surveyDao = surveyDao;
    }

    public void setQuestionDao(QuestionDaoImpl questionDao) {
        this.questionDao = questionDao;
    }
}
