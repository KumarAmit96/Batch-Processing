package com.batch.execution.config;

import com.batch.execution.model.Assessment;
import com.batch.execution.processor.AssessmentProcessor;
import com.batch.execution.reader.AssessmentReader;
import com.batch.execution.repo.AssessmentRepo;
import com.batch.execution.writer.AssessmentWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private final AssessmentRepo assessmentRepo;

    @Autowired
    public BatchConfiguration(AssessmentRepo assessmentRepo) {
        this.assessmentRepo = assessmentRepo;
    }

    @Bean
    public ItemReader<Assessment> reader(){
        return new AssessmentReader(assessmentRepo);
    }

    @Bean
    public FlatFileItemWriter<Assessment> writer() {
        return new AssessmentWriter("output/persons.csv");
    }

    @Bean
    public ItemProcessor<Assessment, Assessment> processor(){
        return new AssessmentProcessor();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
                .<Assessment, Assessment> chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

}
