/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import DataAccess.Interface.IExemploDal;
import Business.Entity.Exemplo;
import java.util.List;

/**
 *
 * @author matheusdsl
 */
public class ExemploDal implements IExemploDal {

    @Override
    public Exemplo Buscar(int id) {
       Exemplo e = new Exemplo();
       e.setId(id);
       e.setNome("Nome Exemplo Teste");
       return e;
    }
    
    
    
}
