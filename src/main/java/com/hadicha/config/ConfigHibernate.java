package com.hadicha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan("com.hadicha")
public class ConfigHibernate {
        private final Environment env;

        public ConfigHibernate(Environment env) {
            this.env = env;
        }
        @Bean
        public DataSource getDataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("db.driver")));
            dataSource.setUrl(env.getProperty("db.url"));
            dataSource.setUsername(env.getProperty("db.username"));
            dataSource.setPassword(env.getProperty("db.password"));
            return dataSource;
        }

        @Bean
        public Properties getHibernateProperties() {
            Properties properties = new Properties();
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
            properties.put("hibernate.hbm2ddl.auto", "update");
            return properties;
        }

        @Bean
        public javax.persistence.EntityManagerFactory entityManagerFactory(DataSource dataSource){
            HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
            jpaVendorAdapter.setGenerateDdl(true);
            jpaVendorAdapter.setShowSql(true);

            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
                    new LocalContainerEntityManagerFactoryBean();

            entityManagerFactoryBean.setDataSource(dataSource);
            entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
            entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
            entityManagerFactoryBean.setPackagesToScan("com.hadicha");

            entityManagerFactoryBean.afterPropertiesSet();

            return entityManagerFactoryBean.getObject();
        }
        @Bean
        public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory);
            return transactionManager;
        }

        @Bean
        public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
            return new PersistenceExceptionTranslationPostProcessor();
        }
    }

