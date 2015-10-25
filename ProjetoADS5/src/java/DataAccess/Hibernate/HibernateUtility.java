/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Hibernate;

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
