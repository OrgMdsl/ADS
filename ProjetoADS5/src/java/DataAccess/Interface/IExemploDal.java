/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Interface;

import Business.Entity.Map.Exemplo;
import java.util.List;

/**
 *
 * @author matheusdsl
 */
public interface IExemploDal {
    
    public Exemplo Buscar(int id);
    
}
