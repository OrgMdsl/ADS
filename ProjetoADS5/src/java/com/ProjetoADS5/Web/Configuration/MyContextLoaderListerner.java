package com.ProjetoADS5.Web.Configuration;

import com.ProjetoADS5.Web.Controller.Helpers.WebServiceHelper;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
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
