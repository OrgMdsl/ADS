/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Entity.Map.CoreGenerico;
import Business.Interface.ICoreGenericoBll;
import DataAccess.CoreGenericoDal;
import DataAccess.Interface.ICoreGenericoDal;
import DataAccess.Utils.Helpers.DalHelper;

/**
 *
 * @author matheusdsl
 */

public class CoreGenericoBll extends DalHelper<CoreGenerico> implements ICoreGenericoBll {

    private final ICoreGenericoDal CoreGenericoDal = new CoreGenericoDal();
    
    public CoreGenerico BuscarPorNome(String nome)
    {
       return this.CoreGenericoDal.Buscar(nome);
    } 
}
