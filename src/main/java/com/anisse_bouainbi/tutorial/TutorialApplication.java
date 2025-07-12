package com.anisse_bouainbi.tutorial;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TutorialApplication implements CommandLineRunner {

	private final DataSource source;

	public TutorialApplication(final DataSource source) {
		this.source = source;
	}

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);
	}

	@Override
	public void run(final String... args) {
		System.out.println("Datasource : " + source.toString());
		final JdbcTemplate template = new JdbcTemplate(source);
		template.execute("select 1");
	}
}
