package com.MyAzienda.SpringToMany.configurations;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DateConfiguration {

	@Bean
	public LocalDate currentDate() {
		return LocalDate.now();
	}
	
	@Bean
	@Scope("prototype")
	public String currentDateTimeformatted() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HH:mm:ss-S");
		return formatter.format(new Date());
	}
}
