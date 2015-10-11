/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller;

import Business.ExemploBll;
import Business.Interface.IExemploBll;
import Business.Entity.Map.Exemplo;
import Business.Entity.Map.CoreGenerico;
import Business.Entity.Map.CoreGenericoItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Web.Controller.Helpers.JsonHelper;
import br.com.configuration.HibernateUtility;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author matheusdsl
 */
@Controller
public class ExemploController {

    private final IExemploBll ExemploBll;

    public ExemploController() {
        this.ExemploBll = new ExemploBll();
    }

    @RequestMapping(value = "ExibeExemplo", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ExibeExemplo(@RequestParam int id) {
        return new JsonHelper<Exemplo>().ToJson(this.ExemploBll.Buscar(id));
    }

    @RequestMapping(value = "Teste", produces = "text/html; charset=UTF8")
    @ResponseBody
    public String Teste() {

        try {
            
            Session sessao = HibernateUtility.getSession();
            Transaction transaction = sessao.beginTransaction();
   
            CoreGenerico o = new CoreGenerico();
            o.setDescricao("Prioridade");
            o.setNome("Prioridade");

            Set<CoreGenericoItem> list = new HashSet<CoreGenericoItem>();

            CoreGenericoItem obj = new CoreGenericoItem();
            obj.setAtivo(Boolean.TRUE);
            obj.setCoreGenerico(o);
            obj.setDescricao("Alta");
            obj.setSigla("A");
            list.add(obj);

            obj = new CoreGenericoItem();
            obj.setAtivo(Boolean.TRUE);
            obj.setCoreGenerico(o);
            obj.setDescricao("Média");
            obj.setSigla("M");
            list.add(obj);

            obj = new CoreGenericoItem();
            obj.setAtivo(Boolean.TRUE);
            obj.setCoreGenerico(o);
            obj.setDescricao("Baixa");
            obj.setSigla("B");
            list.add(obj);
            
            o.setCoreGenericoItems(list);
            sessao.saveOrUpdate(o);
            
            

            transaction.commit();
            sessao.close();

            return "OK";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
