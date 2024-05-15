package com.batch.execution.processor;

import com.batch.execution.model.Assessment;
import org.springframework.batch.item.ItemProcessor;

public class AssessmentProcessor implements ItemProcessor<Assessment, Assessment> {
    @Override
    public Assessment process(Assessment item) throws Exception {
        return item;
    }
}
