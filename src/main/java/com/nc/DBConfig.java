package com.nc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@ComponentScan
//@PropertySource("classpath:database.properties")
public class DBConfig {
  @Bean
  public DriverManagerDataSource dataSource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
    dataSource.setPassword("root");
    dataSource.setUsername("root");
    dataSource.setUrl("jdbc:mysql://localhost:3306/javastudy");
    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
    LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
    emFactory.setDataSource(dataSource());
    emFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    Properties jpaProp = new Properties();
    jpaProp.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    jpaProp.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//    jpaProp.setProperty("javax.persistence.schema-generation.database.action", "create-drop");
    emFactory.setJpaProperties(jpaProp);
    emFactory.setPackagesToScan("com.nc.entity");
    return emFactory;
  }

  @Bean
  public JpaTransactionManager transactionManager(){
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }
}