package com.lrd.bathmysql.batch;

import com.lrd.bathmysql.entities.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements org.springframework.jdbc.core.RowMapper<com.lrd.bathmysql.entities.Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();

        account.setId(resultSet.getLong("id"));
        account.setName(resultSet.getString("name"));
        account.setCode(resultSet.getString("code"));
        account.setSold(resultSet.getDouble("sold"));

        return account;
    }
}
