/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller;

import Business.GenericoBll;
import Business.GenericoItemBll;
import Business.Entity.Map.Generico;
import Business.Entity.Map.GenericoItem;
import Business.Interface.IGenericoBll;
import Business.Interface.IGenericoItemBll;
import static Factory.New.New;
import Web.Controller.Helpers.JsonHelper;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

    @RequestMapping(value = "BuscaGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscaGenerico(@RequestParam Integer id) {
        return JsonHelper.ToJson(this.GenericoBll.Buscar(id));
    }

    @RequestMapping(value = "BuscaGenericoNome", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscaGenericoNome(@RequestParam String nome) {
        return JsonHelper.ToJson(this.GenericoBll.BuscarPorNome(nome));
    }

    @RequestMapping(value = "ListaGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListaGenerico() {
        return JsonHelper.ToJson(this.GenericoBll.Pesquisar());
    }
   
    @RequestMapping(value = "ListaGenericoItem", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListaGenericoItem(@RequestParam Integer id) {
        return JsonHelper.ToJson(this.GenericoItemBll.GetItens(id));
    }

    @RequestMapping(value = "BuscaGenericoItem", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscaGenericoItem(@RequestParam String sigla, @RequestParam String nomePai) {
        return JsonHelper.ToJson(this.GenericoItemBll.BuscarPorSigla(sigla, nomePai));
    }
    
    @RequestMapping(value = "CadastrarGenerico", produces = "text/html; charset=UTF8", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> CadastrarGenerico( 
            @RequestBody String obj) {
        
        String teste  = "";
        
        return JsonHelper.ToJson(obj);
    }

    @RequestMapping(value = "SalvarGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public String SalvarGenerico() {
        Generico c = new Generico();
        c.setNome("Nivel");
        c.setDescricao("Nível");

        Set<GenericoItem> list = new HashSet<GenericoItem>();
        GenericoItem i = new GenericoItem();
        i.setGenerico(c);
        i.setAtivo(Boolean.TRUE);
        i.setDescricao("Um");
        i.setSigla("1");
        list.add(i);
        i = new GenericoItem();
        i.setGenerico(c);
        i.setAtivo(Boolean.TRUE);
        i.setDescricao("Dois");
        i.setSigla("2");
        list.add(i);
        i = new GenericoItem();
        i.setGenerico(c);
        i.setAtivo(Boolean.TRUE);
        i.setDescricao("Três");
        i.setSigla("3");
        list.add(i);

        c.setGenericoItems(list);

        String msg = GenericoBll.InserirAtualizar(c);
        return msg;
    }
}
