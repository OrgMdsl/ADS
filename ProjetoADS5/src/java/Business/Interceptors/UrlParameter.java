/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Interceptors;

import Business.Common.Const.AccessControlConst;
import Business.Common.Const.ActionsConst;
import Business.Common.Const.AttributesConst;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author matheusdsl
 */
public class UrlParameter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object controller) throws Exception {

        String uri = request.getRequestURI();
        String query = request.getQueryString();
        String context = request.getContextPath();
        if (query != null) {
            try
            {
                Double.valueOf(query);
                query = "?id=" + query;
                uri += query;
                uri = uri.replace(context, "");
                RequestDispatcher dispacher = request.getRequestDispatcher(uri);
                dispacher.forward(request, response);
                return false;
            }
            catch(Exception ex)
            {}
        }
        return true;
    }

}
