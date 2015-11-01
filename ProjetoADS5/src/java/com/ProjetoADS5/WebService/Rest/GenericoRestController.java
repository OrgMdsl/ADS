/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.WebService.Rest;

import com.ProjetoADS5.Business.Common.Const.ActionsConst;
import com.ProjetoADS5.Business.Entity.Map.Generico;
import com.ProjetoADS5.Business.Entity.Map.GenericoItem;
import com.ProjetoADS5.Business.GenericoBll;
import com.ProjetoADS5.Business.GenericoItemBll;
import com.ProjetoADS5.Business.Interface.IGenericoBll;
import com.ProjetoADS5.Business.Interface.IGenericoItemBll;
import static com.ProjetoADS5.Factory.New.New;
import com.ProjetoADS5.Web.Controller.Helpers.JsonHelper;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author matheusdsl
 */
@RestController
public class GenericoRestController {

    private final IGenericoBll GenericoBll = New(GenericoBll.class);
    private final IGenericoItemBll GenericoItemBll = New(GenericoItemBll.class);
    private final JsonHelper JsonHelper = New(JsonHelper.class);

    @RequestMapping(value = "BuscarGenerico" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenerico(@RequestParam Integer id) {
        ResponseEntity<String> json = JsonHelper.ToJson(this.GenericoBll.Buscar(id), true);
        return json;
    }

    @RequestMapping(value = "BuscarGenericoNome" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenericoNome(@RequestParam String nome) {
        return JsonHelper.ToJson(this.GenericoBll.BuscarPorNome(nome), true);
    }

    @RequestMapping(value = "ListarGenerico" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListarGenerico() {
        ResponseEntity<String> json = JsonHelper.ToJson(this.GenericoBll.PesquisarTodos(), true);
        return json;
    }

    @RequestMapping(value = "ListarGenericoItem" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListarGenericoItem(@RequestParam Integer id) {
        ResponseEntity<String> json = JsonHelper.ToJson(this.GenericoItemBll.GetItens(id), false);
        return json;
    }

    @RequestMapping(value = "BuscarGenericoItem" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenericoItem(@RequestParam String sigla, @RequestParam String nomePai) {
        return JsonHelper.ToJson(this.GenericoItemBll.BuscarPorSigla(sigla, nomePai), false);
    }

    @RequestMapping(value = "CadastrarGenerico" + ActionsConst.WEB_SERVICE, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseEntity<String> CadastrarGenerico(@RequestBody String obj) {
        Generico _obj = JsonHelper.FromJson(obj, Generico.class);
        
        Generico generico = new Generico();
        generico.setAtivo(_obj.isAtivo());
        generico.setDescricao(_obj.getDescricao());
        generico.setNome(_obj.getNome());
        
        List<GenericoItem> itens = _obj.getGenericoItems();
        itens.stream().forEach((i) -> {
            i.setGenerico(generico);
        });
        generico.setGenericoItems(itens);
        
        return this.GenericoBll.InserirAtualizar(generico);
    }

    @RequestMapping(value = "AlterarStatusGenerico" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> AlterarStatusGenerico(@RequestParam Integer id) {
        ResponseEntity<String> json = this.GenericoBll.ToggleStatus(id);
        return json;
    }
}
