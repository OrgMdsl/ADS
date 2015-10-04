/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Interface;

import DataAccess.Interface.IExemploDal;
import Business.Entity.Exemplo;

/**
 *
 * @author matheusdsl
 */
public interface IExemploBll {
    public Exemplo Buscar(int id);
}
