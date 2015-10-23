/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Configuration;

import DataAccess.GenericoDal;
import DataAccess.Interface.IGenericoDal;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author matheusdsl
 */
public class SessionCounterListener implements HttpSessionListener {

    private static int totalActiveSessions;

    public static int getTotalActiveSession() {
        return totalActiveSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        totalActiveSessions++;
        System.out.println("sessionCreated - add one session into counter");
        printCounter(arg0);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        totalActiveSessions--;
        System.out.println("sessionDestroyed - deduct one session from counter");
        printCounter(arg0);
    }

    private void printCounter(HttpSessionEvent sessionEvent) {

        HttpSession session = sessionEvent.getSession();

        ApplicationContext ctx
                = WebApplicationContextUtils.
                getWebApplicationContext(session.getServletContext());
    }

}
