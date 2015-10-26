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
import Web.Controller.Helpers.JsonHelper;
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

    private final IGenericoBll GenericoBll = New(GenericoBll.class);
    private final IGenericoItemBll GenericoItemBll = New(GenericoItemBll.class);
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
        ResponseEntity<String> json = JsonHelper.ToJson(this.GenericoBll.Buscar(id));
        return json;
    }

    @RequestMapping(value = "BuscarGenericoNome", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenericoNome(@RequestParam String nome) {
        return JsonHelper.ToJson(this.GenericoBll.BuscarPorNome(nome));
    }

    @RequestMapping(value = "ListarGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListarGenerico() {
        ResponseEntity<String> json = JsonHelper.ToJson(this.GenericoBll.PesquisarTodos());
        return json; 
    }

    @RequestMapping(value = "ListarGenericoItem", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListarGenericoItem(@RequestParam Integer id) {
        ResponseEntity<String> json = JsonHelper.ToJson(this.GenericoItemBll.GetItens(id));
        return json;
    }

    @RequestMapping(value = "BuscarGenericoItem", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenericoItem(@RequestParam String sigla, @RequestParam String nomePai) {
        return JsonHelper.ToJson(this.GenericoItemBll.BuscarPorSigla(sigla, nomePai));
    }

    @RequestMapping(value = "CadastrarGenerico", method = RequestMethod.POST, consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseEntity<String> CadastrarGenerico(@RequestBody String obj) {
        Generico _obj = JsonHelper.FromJson(obj, Generico.class);
        return this.GenericoBll.InserirAtualizar(_obj);
    }

    @RequestMapping(value = "AlterarStatusGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> AlterarStatusGenerico(@RequestParam Integer id) {     
        ResponseEntity<String> json = this.GenericoBll.ToggleStatus(id);
        return json;
    }
}
