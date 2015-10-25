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
    public ModelAndView PaginaListagemGenerico() {
        ModelAndView mv = new ModelAndView("Generico/ListarGenerico");
        mv.addObject("ViewName", "Listas genéricas");
        return mv;
    }

    @RequestMapping(value = "PaginaCadastrarGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ModelAndView PaginaCadastroGenerico() {
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
        return JsonHelper.ToJson(this.GenericoBll.Buscar(id));
    }

    @RequestMapping(value = "BuscarGenericoNome", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenericoNome(@RequestParam String nome) {
        return JsonHelper.ToJson(this.GenericoBll.BuscarPorNome(nome));
    }

    @RequestMapping(value = "ListarGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListarGenerico() {
        return JsonHelper.ToJson(this.GenericoBll.Pesquisar());
    }
   
    @RequestMapping(value = "ListarGenericoItem", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListarGenericoItem(@RequestParam Integer id) {
        return JsonHelper.ToJson(this.GenericoItemBll.GetItens(id));
    }

    @RequestMapping(value = "BuscarGenericoItem", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenericoItem(@RequestParam String sigla, @RequestParam String nomePai) {
        return JsonHelper.ToJson(this.GenericoItemBll.BuscarPorSigla(sigla, nomePai));
    }
    
    @RequestMapping(value = "CadastrarGenerico", produces = "text/html; charset=UTF8", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> CadastrarGenerico(@RequestBody String obj) {   
        Generico _obj = JsonHelper.FromJson(obj, Generico.class);
        return this.GenericoBll.InserirAtualizar(_obj);
    }
    
    @RequestMapping(value = "AtivarDesativar", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> AtivarDesativar(@RequestParam Integer id) {
        return JsonHelper.ToJson(this.GenericoItemBll.AtivarDesativar(id));
    }
}
