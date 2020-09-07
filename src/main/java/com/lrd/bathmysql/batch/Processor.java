package com.lrd.bathmysql.batch;

import com.lrd.bathmysql.entities.Account;
import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<Account, Account> {

    @Override
    public Account process(Account account) throws Exception {

        account.setSold(account.getSold() + 10000);
        //System.out.println(account);
        return account;
    }
}
