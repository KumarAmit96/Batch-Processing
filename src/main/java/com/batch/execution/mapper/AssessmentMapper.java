package com.batch.execution.mapper;

import com.batch.execution.model.Assessment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssessmentMapper implements RowMapper<Assessment> {

    @Override
    public Assessment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Assessment assessment = new Assessment();
        assessment.setId(rs.getLong("id"));
        assessment.setAssessment(rs.getString("Assessment"));
        assessment.setQuestionerId(rs.getLong("questionerId"));
        assessment.setRemark(rs.getString("remark"));
        assessment.setRemark(rs.getString("addedBy"));
        return assessment;
    }
}
