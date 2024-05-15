package com.batch.execution.repo;

import com.batch.execution.mapper.AssessmentMapper;
import com.batch.execution.model.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssessmentRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AssessmentRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Assessment> getAssessment(){
        String ga = "CALL get_assessment()";
        return jdbcTemplate.query(ga, new AssessmentMapper());
    }
}
