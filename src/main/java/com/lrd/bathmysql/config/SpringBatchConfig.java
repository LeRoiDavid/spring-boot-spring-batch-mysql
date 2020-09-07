package com.lrd.bathmysql.config;

import com.lrd.bathmysql.batch.AccountRowMapper;
import com.lrd.bathmysql.batch.AccountWriter;
import com.lrd.bathmysql.batch.Processor;
import com.lrd.bathmysql.entities.Account;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired JobBuilderFactory jobBuilderFactory;
    @Autowired StepBuilderFactory stepBuilderFactory;
    @Autowired DataSource dataSource;

    @Bean
    public Job myJob(){
        ItemReader<Account> itemReader;
        ItemProcessor<Account, Account> itemProcessor;
        ItemWriter<Account> itemWriter;

        Step step1 = stepBuilderFactory.get("accountStep")
                        .<Account, Account>chunk(100)
                        .reader(itemReader())
                        .processor(itemProcessor())
                        .writer(itemWriter())
                        .build();
        return jobBuilderFactory.get("accountJob")
                        .incrementer(new RunIdIncrementer())
                        .start(step1)
                        .build();
    }

    @Bean
    public JdbcCursorItemReader<Account> itemReader(){
        JdbcCursorItemReader<Account> cursorItemReader = new JdbcCursorItemReader<>();
        cursorItemReader.setDataSource(dataSource);
        cursorItemReader.setSql("SELECT * from account");
        cursorItemReader.setRowMapper(new AccountRowMapper());

        return cursorItemReader;
    }


    @Bean
    public Processor itemProcessor(){
        return  new Processor();
    }

    @Bean
    public AccountWriter itemWriter(){
        return new AccountWriter();
    }




}
