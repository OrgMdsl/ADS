/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.WebService.Rest;

import com.ProjetoADS5.Common.Const.ActionsConst;
import com.ProjetoADS5.Business.Entity.Map.Generico;
import com.ProjetoADS5.Business.Entity.Map.GenericoItem;
import com.ProjetoADS5.Business.GenericoBll;
import com.ProjetoADS5.Business.GenericoItemBll;
import com.ProjetoADS5.Business.Interface.IGenericoBll;
import com.ProjetoADS5.Business.Interface.IGenericoItemBll;
import com.ProjetoADS5.DataAccess.Utils.Helpers.DalHelper;
import com.ProjetoADS5.Web.Controller.Helpers.JsonHelper;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matheusdsl
 */
@RestController
public class GenericoRestController {

    private final IGenericoBll GenericoBll = new GenericoBll(Generico.class);
    private final IGenericoItemBll GenericoItemBll = new GenericoItemBll(GenericoItem.class);
    private final JsonHelper JsonHelper = new JsonHelper();

    @RequestMapping(value = "BuscarGenerico" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public String BuscarGenerico(@RequestParam Integer id) throws Exception {
        String json = JsonHelper.ToJson(this.GenericoBll.Buscar(id), true);
        return json;
    }

    @RequestMapping(value = "BuscarGenericoNome" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public String BuscarGenericoNome(@RequestParam String nome) throws Exception {
        return JsonHelper.ToJson(this.GenericoBll.BuscarPorNome(nome), true);
    }

    @RequestMapping(value = "ListarGenerico" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public String ListarGenerico() throws Exception {
        String json = JsonHelper.ToJson(this.GenericoBll.PesquisarTodos(), true);
        return json;
    }

    @RequestMapping(value = "ListarGenericoItem" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public String ListarGenericoItem(@RequestParam Integer id) throws Exception {
        String json = JsonHelper.ToJson(this.GenericoItemBll.GetItens(id), false);
        return json;
    }

    @RequestMapping(value = "BuscarGenericoItem" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public String BuscarGenericoItem(@RequestParam Integer id) throws Exception {
        String retorno = JsonHelper.ToJson(this.GenericoItemBll.Buscar(id), true);
        return retorno;
    }

    @RequestMapping(value = "CadastrarGenerico" + ActionsConst.WEB_SERVICE, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String CadastrarGenerico(@RequestBody String obj) throws Exception {
        Generico _obj = JsonHelper.FromJson(obj, Generico.class);

        Generico generico = new Generico();
        generico.setId(_obj.getId());
        generico.setAtivo(_obj.isAtivo());
        generico.setDescricao(_obj.getDescricao());
        generico.setNome(_obj.getNome());

        List<GenericoItem> itens = _obj.getGenericoItems();
        itens.stream().forEach((i) -> {
            i.setGenerico(generico);
        });
        generico.setGenericoItems(itens);

        if (_obj.getId() == null) {
            return JsonHelper.ToJson(this.GenericoBll.Inserir(generico),true);
        } else {
            return JsonHelper.ToJson(this.GenericoBll.Atualizar(generico),true);
        }
    }

    @RequestMapping(value = "AlterarStatusGenerico" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public String AlterarStatusGenerico(@RequestParam Integer id) throws Exception {
        String json = this.GenericoBll.ToggleStatus(id);
        return json;
    }
    
    @RequestMapping(value = "ExcluirGenerico" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExcluirGenerico(@RequestParam String id) throws Exception {
        Generico obj = new Generico();
        obj.setId(Integer.valueOf(id));
        return JsonHelper.ToJson(this.GenericoBll.ExcluirFisicamente(obj), true);
    }
    
    @RequestMapping(value = "ExcluirGenericoItem" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExcluirGenericoItem(@RequestParam String id) throws Exception {
        GenericoItem obj = new GenericoItem();
        obj.setId(Integer.valueOf(id));
        return JsonHelper.ToJson(this.GenericoItemBll.ExcluirFisicamente(obj), true);
    }
}
