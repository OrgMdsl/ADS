/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author matheusdsl
 */
@Controller
public class IndexController {

    @RequestMapping("home")
    public ModelAndView Index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("ViewName", "Home");
        mv.addObject("ViewDescription", "Lista de chamados");
        return mv;
    }
    
    @RequestMapping("*")
    public ModelAndView NaoEncontrado() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("ViewName", "Ops... <br><br><small>Página não encontrada.</small>");
        return mv;
    }

    @RequestMapping("LayoutLeftMenu")
    public String LayoutLeftMenu() {
        return "Layout/left-menu";
    }

    @RequestMapping("LayoutTopWrapper")
    public String LayoutTopWrapper() {
        return "Layout/top-wrapper";
    }

    @RequestMapping("LayoutHeadEssential")
    public String LayoutHeadEssential() {
        return "Layout/head-essential";
    }

    @RequestMapping("LayoutFooter")
    public String LayoutFooter() {
        return "Layout/footer";
    }
}
