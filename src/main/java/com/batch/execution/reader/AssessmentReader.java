package com.batch.execution.reader;

import com.batch.execution.model.Assessment;
import com.batch.execution.repo.AssessmentRepo;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.IteratorItemReader;

import java.util.List;

public class AssessmentReader implements ItemReader<Assessment> {

    private final AssessmentRepo assessmentRepo;
    private ItemReader<Assessment> delegate;

    public AssessmentReader(AssessmentRepo assessmentRepo) {
        this.assessmentRepo = assessmentRepo;
    }

    @Override
    public Assessment read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(delegate == null)
            delegate = new IteratorItemReader<>(getAssessment());
        return delegate.read();
    }

    public List<Assessment> getAssessment() {
        return assessmentRepo.getAssessment();
    }
}
