/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Business.Interceptors;

import com.ProjetoADS5.Web.Common.Const.AccessControlConst;
import com.ProjetoADS5.Common.Const.ActionsConst;
import com.ProjetoADS5.Common.Const.AttributesConst;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.Scope;
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
        HttpSession sessao = request.getSession(true);
        String uri = request.getRequestURI();
   
         if (uri.toUpperCase().contains(AccessControlConst.RESTRITO)) {
         if (sessao.getAttribute(AttributesConst.LOGADO) == null
         || (boolean) sessao.getAttribute(AttributesConst.LOGADO) == false) {

         if (request.getQueryString() != null) {
         uri += "?" + request.getQueryString();
         }

         sessao.setAttribute("endereco", uri);

         RequestDispatcher dispacher = request.getRequestDispatcher(ActionsConst.FAZER_LOGIN);
         dispacher.forward(request, response);
         return false;
         }
         }
        return true;
    }

}
