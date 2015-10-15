/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller;

import Business.Common.Const.AccessControlConst;
import Business.CoreGenericoBll;
import Business.CoreGenericoItemBll;
import Business.Entity.Map.CoreGenerico;
import Business.Entity.Map.CoreGenericoItem;
import Web.Controller.Helpers.JsonHelper;
import java.util.HashSet;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author matheusdsl
 */
@Controller
public class CoreGenericoController {

    private final CoreGenericoBll CoreGenericoBll = new CoreGenericoBll();
    private final CoreGenericoItemBll CoreGenericoItemBll = new CoreGenericoItemBll();

    @RequestMapping(value = "PaginaListagemCoreGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ModelAndView PaginaListagemCoreGenerico() {
        ModelAndView mv = new ModelAndView("CoreGenerico/ListagemCoreGenerico");
        mv.addObject("ViewName","Listas genéricas");
        return mv;
    }
    
    @RequestMapping(value = "PaginaCadastroCoreGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ModelAndView PaginaCadastroCoreGenerico() {
        ModelAndView mv = new ModelAndView("CoreGenerico/CadastroCoreGenerico");
        mv.addObject("ViewName","Cadastro - Listas genéricas");
        return mv;
    }
    
    @RequestMapping(value = "BuscaCoreGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscaCoreGenerico(@RequestParam int id) {
        return new JsonHelper<CoreGenerico>().ToJson(this.CoreGenericoBll.Buscar(id));
    }

    @RequestMapping(value = "BuscaCoreGenericoNome", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscaCoreGenericoNome(@RequestParam String nome) {
        return new JsonHelper<CoreGenerico>().ToJson(this.CoreGenericoBll.BuscarPorNome(nome));
    }
    
    @RequestMapping(value = "ListaCoreGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListaCoreGenerico() {
        return new JsonHelper<Set<CoreGenerico>>().ToJson(this.CoreGenericoBll.Pesquisar());
    }

    @RequestMapping(value = "BuscaCoreGenericoItem", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscaCoreGenericoItem(@RequestParam String sigla, @RequestParam String nomePai) {
        return new JsonHelper<CoreGenericoItem>().ToJson(this.CoreGenericoItemBll.BuscarPorSigla(sigla, nomePai));
    }

    @RequestMapping(value = "SalvarCoreGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public String SalvarCoreGenerico() {
        CoreGenerico c = new CoreGenerico();
        c.setNome("Nivel");
        c.setDescricao("Nível");

        Set<CoreGenericoItem> list = new HashSet<CoreGenericoItem>();
        CoreGenericoItem i = new CoreGenericoItem();
        i.setCoreGenerico(c);
        i.setAtivo(Boolean.TRUE);
        i.setDescricao("Um");
        i.setSigla("1");
        list.add(i);
        i = new CoreGenericoItem();
        i.setCoreGenerico(c);
        i.setAtivo(Boolean.TRUE);
        i.setDescricao("Dois");
        i.setSigla("2");
        list.add(i);
        i = new CoreGenericoItem();
        i.setCoreGenerico(c);
        i.setAtivo(Boolean.TRUE);
        i.setDescricao("Três");
        i.setSigla("3");
        list.add(i);

        c.setCoreGenericoItems(list);

        String msg = new CoreGenericoBll().InserirAtualizar(c);
        return msg;
    }
}
