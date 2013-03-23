package com.ninja_squad.tpdi;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Srping application configuration. Lacks some annotations.
 * @author JB Nizet
 */
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
        result.setPersistenceUnitName("TP_JPA");
        result.setDataSource(dataSource());
        result.setPersistenceProviderClass(HibernatePersistence.class);
        return result;
    }

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource("jdbc:hsqldb:hsql://localhost/TP_JPA", "sa", "");
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}