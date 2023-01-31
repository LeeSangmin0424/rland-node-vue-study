package com.newlec.rlandapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    
    @Bean // ioc에 담아야할 객체가 있다.
    WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer(){
            public void addCorsMappings(CorsRegistry registry) { // 어떤 cont에 대해서 url를 등록해주겠다.
                registry.addMapping("/**") // ** 서브, 하위까지 등록(허락) // 
                        .allowedOrigins("http://localhost:5173") // 허락하고자 하는 url
                        .allowedMethods( // 이게 없으면 DELETE가 안되었음. 설정 필요. 허락되는 method.
                            HttpMethod.GET.name(), // 기본설정
                            HttpMethod.POST.name(), // 기본설정
                            HttpMethod.PUT.name(), // 필요
                            HttpMethod.DELETE.name() // 필요
                            );
            };
        };
        return configurer;
    }
}
