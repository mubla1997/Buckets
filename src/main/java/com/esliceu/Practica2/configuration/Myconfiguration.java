package com.esliceu.Practica2.configuration;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.esliceu.Practica2"})
@PropertySource("classpath:application.properties")
public class Myconfiguration implements WebMvcConfigurer {

    @Autowired
    @Qualifier("verifyint")
    private HandlerInterceptor VerifyInterceptor;

    @Autowired
    @Qualifier("tokenCheckInt")
    private HandlerInterceptor CrsfTokenCheckInterceptor;

    @Autowired
    @Qualifier("tokenGenInt")
    private HandlerInterceptor CrsfTokenGenInterceptor;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean =
                new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/jsp/");
        bean.setSuffix(".jsp");
        bean.setViewClass(JstlView.class);
        return bean;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(VerifyInterceptor)
                .addPathPatterns("/object/**");
        registry.addInterceptor(CrsfTokenCheckInterceptor)
                .addPathPatterns("/**");
        registry.addInterceptor(CrsfTokenGenInterceptor)
                .addPathPatterns("/**");

    }

    @Autowired
    Environment env;

    @Bean
    public DataSource getDatasource(){
        MysqlDataSource mds = new MysqlDataSource();
        //Datos obtenidos del archivo de propiedades.
        mds.setURL(env.getProperty("jdbc.url"));
        mds.setUser(env.getProperty("jdbc.user"));
        mds.setPassword(env.getProperty("jdbc.password"));
        return mds;
    }
    @Bean
    // Acceso a la base de datos.
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
