/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller;

import Business.GenericoBll;
import Business.GenericoItemBll;
import Business.Entity.Map.Generico;
import Business.Interface.IGenericoBll;
import Business.Interface.IGenericoItemBll;
import static Factory.New.New;
import Web.Common.Const.AccessControlConst;
import Web.Controller.Helpers.JsonHelper;
import Web.Controller.Helpers.WebServiceHelper;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
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

    private final JsonHelper JsonHelper = New(JsonHelper.class);

    @RequestMapping(value = "PaginaListarGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ModelAndView PaginaListarGenerico() {
        ModelAndView mv = new ModelAndView("Shared/Listar"); //Arquivo que será aberto
        mv.addObject("ViewName", "Listas genéricas"); //Nome da página
        mv.addObject("JsArchive", "additional/ListarGenerico.js"); //Caminho do arquivo JS da página
        mv.addObject("PanelName", "Lista Genérica"); //Nome da tabela
        return mv;
    }

    @RequestMapping(value = "PaginaCadastrarGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ModelAndView PaginaCadastrarGenerico() {
        ModelAndView mv = new ModelAndView("Generico/CadastrarGenerico");
        mv.addObject("ViewName", "Cadastro - Listas genéricas");
        return mv;
    }

    @RequestMapping(value = "PaginaEditarGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ModelAndView PaginaCadastroGenerico(@RequestParam Integer id) {
        ModelAndView mv = new ModelAndView("Generico/CadastrarGenerico");
        mv.addObject("ViewName", "Edição - Listas genéricas");
        mv.addObject("ObjId", id);
        return mv;
    }

    @RequestMapping(value = "BuscarGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenerico(@RequestParam Integer id) {
        String parametros = "id=" + id;
        return WebServiceHelper.GetToJsonService("BuscarGenerico", parametros);
    }

    @RequestMapping(value = "BuscarGenericoNome", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenericoNome(@RequestParam String nome) {
        String parametros = "nome=" + nome;
        return WebServiceHelper.GetToJsonService("BuscarGenericoNome", parametros);
    }

    @RequestMapping(value = "ListarGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListarGenerico() {
        return WebServiceHelper.GetToJsonService("ListarGenerico", null);
    }

    @RequestMapping(value = "ListarGenericoItem", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListarGenericoItem(@RequestParam Integer id) {
        String parametros = "id=" + id;
        return WebServiceHelper.GetToJsonService("ListarGenericoItem", parametros);
    }

    @RequestMapping(value = "BuscarGenericoItem", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenericoItem(@RequestParam String sigla, @RequestParam String nomePai) {
        String parametros
                = "sigla=" + sigla
                + "nomePai=" + nomePai;
        return WebServiceHelper.GetToJsonService("BuscarGenericoItem", parametros);
    }

    @RequestMapping(value = "CadastrarGenerico" + AccessControlConst.RESTRITO, 
            method = RequestMethod.POST, 
            headers = {"Content-type=application/json"})
    @ResponseBody
    public ResponseEntity<String> CadastrarGenerico(@RequestBody String obj) {
        //Generico _obj = JsonHelper.FromJson(obj, Generico.class);
        //return this.GenericoBll.InserirAtualizar(_obj);
        return WebServiceHelper.PostCrud("CadastrarGenerico", String.class, obj);
    }

    @RequestMapping(value = "AlterarStatusGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> AlterarStatusGenerico(@RequestParam Integer id) {
        return WebServiceHelper.PostCrud("CadastrarGenerico", String.class, id.toString());
       // ResponseEntity<String> json = this.GenericoBll.ToggleStatus(id);
       // return json;
    }
}
