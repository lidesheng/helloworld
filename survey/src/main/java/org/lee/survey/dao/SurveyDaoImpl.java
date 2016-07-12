package org.lee.survey.dao;

import org.lee.survey.obj.Survey;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lee on 2016/6/30.
 */
public class SurveyDaoImpl extends JdbcDaoSupport {

    public int save(final Survey survey) {
        final String sql = "insert into survey(id, name, enabled) values(null,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, survey.getName());
                ps.setBoolean(2, survey.isEnabled());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public boolean update(Survey survey) {
        String sql = "update survey set enabled = ? where id = ?";
        getJdbcTemplate().update(sql, survey.isEnabled(), survey.getId());
        return true;
    }

    public List<Survey> getAll() {
        final String sql = "select id, name, enabled from survey";
        return getJdbcTemplate().query(sql, new RowMapper<Survey>() {
            public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
                Survey survey = new Survey();
                survey.setId(rs.getInt("id"));
                survey.setName(rs.getString("name"));
                survey.setEnabled(rs.getBoolean("enabled"));
                return survey;
            }
        });
    }

}
