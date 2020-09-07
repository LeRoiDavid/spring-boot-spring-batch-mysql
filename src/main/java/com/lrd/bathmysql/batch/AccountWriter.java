package com.lrd.bathmysql.batch;

import com.lrd.bathmysql.entities.Account;
import com.lrd.bathmysql.repository.AccountRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountWriter implements ItemWriter<Account> {
    @Autowired AccountRepository accountRepository;

    @Override
    public void write(List<? extends Account> accounts) throws Exception {
        accountRepository.saveAll(accounts);

        accountRepository.findAll().forEach(account -> {
            System.out.println("writting...");
            System.out.println(account);
        });
    }
}
