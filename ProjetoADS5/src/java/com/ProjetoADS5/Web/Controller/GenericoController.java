/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Web.Controller;

import com.ProjetoADS5.Web.Common.Const.AccessControlConst;
import com.ProjetoADS5.Web.Controller.Helpers.JsonHelper;
import com.ProjetoADS5.Web.Controller.Helpers.WebServiceHelper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author matheusdsl
 */
@Controller
public class GenericoController {

    private final JsonHelper JsonHelper = new JsonHelper();

    @RequestMapping(value = "PaginaListarGenerico" + AccessControlConst.RESTRITO, produces = "text/html; charset=UTF8")
    public ModelAndView PaginaListarGenerico() {
        ModelAndView mv = new ModelAndView("Shared/Listar"); //Arquivo que será aberto
        mv.addObject("ViewName", "Conteúdos"); //Nome da página
        mv.addObject("JsArchive", "additional/ListarGenerico.js"); //Caminho do arquivo JS da página
        mv.addObject("PanelName", "Tópicos"); //Nome da tabela
        return mv;
    }

    @RequestMapping(value = "PaginaCadastrarGenerico" + AccessControlConst.RESTRITO, produces = "text/html; charset=UTF8")
    public ModelAndView PaginaCadastrarGenerico() {
        ModelAndView mv = new ModelAndView("Generico/CadastrarGenerico");
        mv.addObject("ViewName", "Cadastro - Conteúdos");
        return mv;
    }

    @RequestMapping(value = "PaginaEditarGenerico" + AccessControlConst.RESTRITO, produces = "text/html; charset=UTF8")
    public ModelAndView PaginaCadastroGenerico(Integer id) {
        ModelAndView mv = new ModelAndView("Generico/CadastrarGenerico");
        mv.addObject("ViewName", "Edição - Listas genéricas");
        mv.addObject("ObjId", id);
        return mv;
    }

    @RequestMapping(value = "BuscarGenerico", produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenerico(@RequestParam Integer id) {
        String parametros = "id=" + id;
        ResponseEntity<String> retorno = WebServiceHelper.GetToJsonService("BuscarGenerico", parametros, String.class);
        return retorno;
    }

    @RequestMapping(value = "BuscarGenericoNome", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenericoNome(@RequestParam String nome) {
        String parametros = "nome=" + nome;
        return WebServiceHelper.GetToJsonService("BuscarGenericoNome", parametros, String.class);
    }

    @RequestMapping(value = "ListarGenerico", produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListarGenerico() {
        ResponseEntity<String> retorno = WebServiceHelper.GetToJsonService("ListarGenerico", null, String.class);
        return retorno;
    }

    @RequestMapping(value = "ListarGenericoItem", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListarGenericoItem(@RequestParam Integer id) {
        String parametros = "id=" + id;
        return WebServiceHelper.GetToJsonService("ListarGenericoItem", parametros, String.class);
    }

    @RequestMapping(value = "BuscarGenericoItem", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenericoItem(@RequestParam String sigla, @RequestParam String nomePai) {
        String parametros
                = "sigla=" + sigla
                + "nomePai=" + nomePai;
        return WebServiceHelper.GetToJsonService("BuscarGenericoItem", parametros, String.class);
    }

    @RequestMapping(value = "CadastrarGenerico" + AccessControlConst.RESTRITO,
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public String CadastrarGenerico(@RequestBody String obj) {
        return WebServiceHelper.PostCrud("CadastrarGenerico", obj, null);
    }

    @RequestMapping(value = "AlterarStatusGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public String AlterarStatusGenerico(@RequestParam Integer id) {
        return WebServiceHelper.GetForObject("AlterarStatusGenerico", "id=" + id, String.class);
    }
    
    @RequestMapping(value = "ExcluirGenerico", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExcluirGenerico(@RequestParam String id) {
        return WebServiceHelper.GetForObject("ExcluirGenerico", "id="+id, String.class);
    }
}
