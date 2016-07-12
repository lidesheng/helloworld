package org.lee.survey.dao;

import org.lee.survey.obj.Question;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lee on 2016/6/30.
 */
public class QuestionDaoImpl extends JdbcDaoSupport {

    public boolean save(Question question) {
        String sql = "insert into question(id, surveyId, performance, atmosphere, superStar) values(null,?,?,?,?)";
        getJdbcTemplate().update(sql, question.getSurveyId(), question.getPerformance(), question.getAtmosphere(), question.getSuperStar());
        return true;
    }

    public List<Question> getAll(int surveyId) {
        String sql = "select id, performance, atmosphere, superStar from question where surveyId = ?";
        return getJdbcTemplate().query(sql, new RowMapper<Question>() {
            public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setPerformance(rs.getInt("performance"));
                question.setAtmosphere(rs.getInt("atmosphere"));
                question.setSuperStar(rs.getString("superStar"));
                return question;
            }
        }, surveyId);
    }

}
