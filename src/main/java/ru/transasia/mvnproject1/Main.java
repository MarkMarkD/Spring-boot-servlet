/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.transasia.mvnproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 *
 * @author banashko.dv
 */
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration

//@EnableWebMvc
//@EnableTransactionManagement
////@PropertySource("classpath:application.properties")
//@ComponentScan(basePackages = "ru.transasia.mvnproject1")
//@EnableJpaRepositories("ru.transasia.mvnproject1.repository")
@SpringBootApplication
public class Main {
    
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//        return resolver;
//    }
//        @Bean
//    public UrlBasedViewResolver setupViewResolver() {
//            UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//            resolver.setPrefix("/WEB-INF/views/");
//            resolver.setSuffix(".jsp");
//            resolver.setViewClass(JstlView.class);
//            return resolver;
//    }
    
    public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}
    
}
