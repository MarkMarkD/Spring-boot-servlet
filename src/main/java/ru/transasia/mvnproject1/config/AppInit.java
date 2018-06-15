
package ru.transasia.mvnproject1.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author banashko.dv
 */
public class AppInit {//implements WebApplicationInitializer {

//    public void onStartup(ServletContext servletContext) throws ServletException {
//         
//        AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
//        servletAppContext.register(mvnproject1Config.class);
//        servletContext.addListener(new ContextLoaderListener(servletAppContext));
//
//        servletAppContext.setServletContext(servletContext);
//
//        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(servletAppContext));
//        servlet.addMapping("/");
//        servlet.setLoadOnStartup(1);
//    }

}
