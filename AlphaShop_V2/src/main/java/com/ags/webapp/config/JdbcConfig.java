package com.ags.webapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/* Identifica la classe come configurazione di Spring */
@Configuration
/* Abilitazione gestione transazioni */
@EnableTransactionManagement
/* Path dove verrà eseguito lo scanning delle componenti */
@ComponentScan({ "com.ags.webapp.config" })
/* Sorgente dove verranno lette le proprietà delle connessioni JDBC */
@PropertySource(value =  {"classpath:application.properties"})
public class JdbcConfig
{
	/* Notazione che permette la Dependency Inicetion dell'interfaccia Environment */
	@Autowired
	private Environment environment;
	
	/* Bean a cui abbiamo passato le specifiche della 
	 * sorgente dati */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	
	@Bean 
	public NamedParameterJdbcTemplate getJdbcTemplate(DataSource dataSource) 
	{ 
	    return new NamedParameterJdbcTemplate(dataSource); 
	} 

	/* Bean DataSource che accederà a degli elementi
	 * previsti in uno specifico file chiamato
	 * "application.properties" che avremo ottenuto
	 * dalla variabile Environment */
	@Bean(name = "dataSource")
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		
		return dataSource;
	}

	/* Bean che gestisce le transazioni */
	@Bean
	public DataSourceTransactionManager transactionManager()
	{
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		
		return transactionManager;
	}
	
}
