package com.moex.icdb.process;

import org.kie.api.KieServices.Factory;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class SpringBootDroolsICDBApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootDroolsICDBApp.class);

	public static void main(String... args) {
		SpringApplication.run(SpringBootDroolsICDBApp.class, args);
	}

	@Bean
	public KieContainer kieContainer() {
		return Factory.get().getKieClasspathContainer();
	}

    @Bean
    public JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("");
        javaMailSender.setUsername("");
        javaMailSender.setPassword("");
        return javaMailSender;
    }

}
