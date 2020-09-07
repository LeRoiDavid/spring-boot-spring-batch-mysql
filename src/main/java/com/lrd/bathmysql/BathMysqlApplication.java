package com.lrd.bathmysql;

import com.lrd.bathmysql.entities.Account;
import com.lrd.bathmysql.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration()
public class BathMysqlApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BathMysqlApplication.class, args);
	}

	@Autowired
	AccountRepository accountRepository;

	@Override
	public void run(String... args) throws Exception {
		/*accountRepository.deleteAll();

		accountRepository.save(new Account("John", "001", 12090));
		accountRepository.save(new Account("Dho", "002", 9090));
		accountRepository.save(new Account("David", "003", 10000));

		accountRepository.findAll().forEach(account -> {
			System.out.println(account.toString());
		});*/
	}
}
