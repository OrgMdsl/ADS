/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.DataAccess.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilOLD2 {

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
