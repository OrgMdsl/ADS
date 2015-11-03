/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Web.Controller.Helpers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author matheusdsl
 */
public class CookieHelper {

   public static Cookie obterCookie(String nomeCookie, HttpServletRequest request) {
        Cookie[] lista = request.getCookies();
        for (Cookie c : lista) {
            if (c.getName().equals(nomeCookie)) {
                return c;
            }
        }
        return null;
    }
}
