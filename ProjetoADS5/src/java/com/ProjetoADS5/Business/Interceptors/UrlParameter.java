/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Business.Interceptors;

import com.ProjetoADS5.Web.Common.Const.AccessControlConst;
import com.ProjetoADS5.Business.Common.Const.ActionsConst;
import com.ProjetoADS5.Business.Common.Const.AttributesConst;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
            catch(NumberFormatException | ServletException | IOException ex)
            {}
        }
        return true;
    }

}
