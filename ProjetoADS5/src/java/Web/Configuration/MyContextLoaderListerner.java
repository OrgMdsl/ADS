package Web.Configuration;

import DataAccess.GenericoDal;
import DataAccess.Interface.IGenericoDal;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matheusdsl
 */
public class MyContextLoaderListerner extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);

        ServletContext servletContect = event.getServletContext();

        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContect);
       
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
    }
}
