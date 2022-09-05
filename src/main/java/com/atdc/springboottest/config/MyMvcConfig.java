package com.atdc.springboottest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("index.html").setViewName("index");
    }
    @Bean
    public LocaleResolver localeResolver(){
      return   new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/css/*","/js/**","/img/**");
    }
    //    @Bean
//    public ViewResolver myViewResolver{
//        return new MyViewResolver();
//    }




//    public static class MyViewResolver implements ViewResolver
//    {
//
//
//        @Override
//        public View resolveViewName(String viewName, Locale locale) throws Exception {
//            return null;
//        }
//    }
}

