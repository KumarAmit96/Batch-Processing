package com.batch.execution.writer;

import com.batch.execution.model.Assessment;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

public class AssessmentWriter extends FlatFileItemWriter<Assessment> {

    public AssessmentWriter(String outputPath) {
        super();
        setResource(new FileSystemResource(outputPath));
        setAppendAllowed(true);
        setLineAggregator(new DelimitedLineAggregator<>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<>() {
                    {
                        setNames(new String[]{"Id", "Assessment", "QuestionerId", "Remark", "AddedBy"});
                    }
                });
            }
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
    }
}
