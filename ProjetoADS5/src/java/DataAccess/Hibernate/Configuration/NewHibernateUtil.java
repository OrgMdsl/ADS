/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Hibernate.Configuration;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author matheusdsl
 */
public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}



/*

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

package DataAccess.Hibernate.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    private static SessionFactory factory;
    private static Configuration configuration;

    static {
        try {
            configuration = new Configuration().configure();

            //configuration.setProperty("hibernate.connection.username", "root");

            factory = configuration.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
            factory = null;
        }
    }

    public static Session getSession() {
        return factory.openSession();
    }
}

*/