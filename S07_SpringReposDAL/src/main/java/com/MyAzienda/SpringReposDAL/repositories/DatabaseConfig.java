package com.MyAzienda.SpringReposDAL.repositories;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.jdbc.MysqlDataSource;

//Bean di configurazione: allo start viene sempre prima analizzato il Bean di configurazione
//e poi controller, service, repository ....etc
@Configuration
public class DatabaseConfig {
	
	// per rendere questo oggetto iniettabile, la annoto con @Bean così Spring la gestirà nel BeanContainer
	// e la sua inizializzazione verrà gestita in automatico dallo Spring Core - il nucleo di Spring
	// DataSource è un implementazione di MysqlDataSource
	@Bean
	public DataSource dataSource() throws SQLException {
	    MysqlDataSource ds = new MysqlDataSource();
	    ds.setServerName("localhost");
	    ds.setPortNumber(3306);
	    ds.setUser("root");
	    ds.setPassword("root");
	    ds.setDatabaseName("scuola");
	    ds.setUseSSL(false); // Secure Sockets Layer è un protocollo di sicurezza per una
	                         // connessione crittografata tra applicazione e DB
	    ds.setAllowPublicKeyRetrieval(true); // ottenere la chiave pubblica del server per
	                                         // stabilire una connessione sicura
	    System.out.println("start del datasource");
	
	return ds;
	}
	
	// questo Bean mi servirà tutte le volte che devo fare la connessione al DB
	@Bean
	public Connection connection(DataSource dataSource) throws SQLException {
	    System.out.println("start del connection");
	    return dataSource.getConnection();
	}

}