package com.example.readwriteseparation.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author peter
 * date 2020/11/18 15:17
 */
@Configuration
public class MultiDataSourceConfig {
    @Bean
    @Primary
    public DataSource dataSource() {
        final RoutingDataSource routingDataSource = new RoutingDataSource();
        final DataSource primaryDataSource = new HikariDataSource(primaryHikariConfig());
        final DataSource replicaDataSource = new HikariDataSource(replicateHikariConfig());

        final Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(RoutingDataSource.Route.PRIMARY, primaryDataSource);
        targetDataSources.put(RoutingDataSource.Route.REPLICA, replicaDataSource);

        routingDataSource.setTargetDataSources(targetDataSources);
        routingDataSource.setDefaultTargetDataSource(primaryDataSource);

        return routingDataSource;
    }


    //    @Bean
//    @Bean(name = "primaryDataSourceProperties")
//    @ConfigurationProperties("spring.primary.datasource")
//    public DataSourceProperties primaryDataSourceProperties() {
//        return new DataSourceProperties();
//    }

    //    @Bean
    @Bean(name = "primaryHikariConfig")
    @ConfigurationProperties("spring.primary.datasource")
    public HikariConfig primaryHikariConfig() {
        return new HikariConfig();
    }


    @Bean(name = "replicateHikariConfig")
    @ConfigurationProperties("spring.replicate.datasource")
    public HikariConfig replicateHikariConfig() {
        return new HikariConfig();
    }


}
