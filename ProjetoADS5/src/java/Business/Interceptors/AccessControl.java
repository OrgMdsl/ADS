/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Interceptors;

import Business.Common.Const.AccessControlConst;
import Business.Common.Const.AttributesConst;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author matheusdsl
 */
public class AccessControl extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object controller) throws Exception {

        String uri = request.getRequestURI();

        if (uri.toUpperCase().contains(AccessControlConst.RESTRITO)) {
            if (request.getSession().getAttribute(AttributesConst.LOGADO) == null
                    || (boolean) request.getSession().getAttribute(AttributesConst.LOGADO) == false) {

                if (request.getQueryString() != null) {
                    uri += "?" + request.getQueryString();
                }

                request.getSession().setAttribute("endereco", uri);

                RequestDispatcher dispacher = request.getRequestDispatcher("exibe-login");
                dispacher.forward(request, response);
                return false;
            }
        }
        return true;
    }

}
