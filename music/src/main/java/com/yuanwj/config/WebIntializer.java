package com.yuanwj.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by yuanwj on 2017/1/18.
 */
public class WebIntializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext=new AnnotationConfigWebApplicationContext();
        applicationContext.register(WebMvcConfigurition.class);
        applicationContext.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher",new DispatcherServlet());
        servlet.addMapping("/");
        servlet.setLoadOnStartup(2);
    }
}
