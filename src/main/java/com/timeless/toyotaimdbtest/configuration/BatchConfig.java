package com.timeless.toyotaimdbtest.configuration;

import com.timeless.toyotaimdbtest.model.TitleRating;
import com.timeless.toyotaimdbtest.service.TitleRatingItemProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration @Slf4j
public class BatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public BatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public FlatFileItemReader<TitleRating> titleRatingItemReader() {
        FlatFileItemReader<TitleRating> reader = new FlatFileItemReader<>();
            reader.setResource(new ClassPathResource("imdb-dataset-files/title.ratings.tsv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("tconst", "averageRating", "numVotes");
                setDelimiter("\t");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                setTargetType(TitleRating.class);
            }});
        }});
        return reader;
    }

    @Bean
    public TitleRatingItemProcessor titleRatingItemProcessor() {
        return new TitleRatingItemProcessor();
    }

    @Bean
    public ItemWriter<String> tconstItemWriter() {
        return items -> {
            for (String item : items) {
                System.out.println(item);
            }
        };
    }

    @Bean
    public Job extractTconstJob() {
        return new JobBuilder("extractTconstJob", jobRepository)
                .start(extractTconstStep())
                .build();
    }

    @Bean
    public Step extractTconstStep() {

        log.info("\n\n\n*** extractTconstStep ***\n\n\n");
        return new StepBuilder("extractTconstStep", jobRepository)
                .<TitleRating, String>chunk(100, transactionManager)
                .reader(titleRatingItemReader())
                .processor(titleRatingItemProcessor())
                .writer(tconstItemWriter())
                .build();
    }
}
