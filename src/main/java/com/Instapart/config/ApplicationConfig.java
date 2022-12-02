package com.Instapart.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages="com.Instapart.repo")
@EntityScan(basePackages="com.Instapart.entity")
public class ApplicationConfig {

}