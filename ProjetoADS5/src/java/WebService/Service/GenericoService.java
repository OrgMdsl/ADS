/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService.Service;

import Business.Common.Const.ActionsConst;
import Business.Entity.Map.Generico;
import Business.GenericoBll;
import Business.GenericoItemBll;
import Business.Interface.IGenericoBll;
import Business.Interface.IGenericoItemBll;
import static Factory.New.New;
import Web.Controller.Helpers.JsonHelper;
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
public class GenericoService {

    private final IGenericoBll GenericoBll = New(GenericoBll.class);
    private final IGenericoItemBll GenericoItemBll = New(GenericoItemBll.class);
    private final JsonHelper JsonHelper = New(JsonHelper.class);

    @RequestMapping(value = "BuscarGenerico" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenerico(@RequestParam Integer id) {
        ResponseEntity<String> json = JsonHelper.ToJson(this.GenericoBll.Buscar(id));
        return json;
    }

    @RequestMapping(value = "BuscarGenericoNome" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenericoNome(@RequestParam String nome) {
        return JsonHelper.ToJson(this.GenericoBll.BuscarPorNome(nome));
    }

    @RequestMapping(value = "ListarGenerico" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListarGenerico() {
        ResponseEntity<String> json = JsonHelper.ToJson(this.GenericoBll.PesquisarTodos());
        return json;
    }

    @RequestMapping(value = "ListarGenericoItem" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ListarGenericoItem(@RequestParam Integer id) {
        ResponseEntity<String> json = JsonHelper.ToJson(this.GenericoItemBll.GetItens(id));
        return json;
    }

    @RequestMapping(value = "BuscarGenericoItem" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscarGenericoItem(@RequestParam String sigla, @RequestParam String nomePai) {
        return JsonHelper.ToJson(this.GenericoItemBll.BuscarPorSigla(sigla, nomePai));
    }

    @RequestMapping(value = "CadastrarGenerico" + ActionsConst.WEB_SERVICE, method = RequestMethod.POST, consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseEntity<String> CadastrarGenerico(@RequestBody String obj) {
        Generico _obj = JsonHelper.FromJson(obj, Generico.class);
        return this.GenericoBll.InserirAtualizar(_obj);
    }

    @RequestMapping(value = "AlterarStatusGenerico" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> AlterarStatusGenerico(@RequestParam Integer id) {
        ResponseEntity<String> json = this.GenericoBll.ToggleStatus(id);
        return json;
    }
}
