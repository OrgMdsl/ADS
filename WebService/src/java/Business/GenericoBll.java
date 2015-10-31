/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Entity.Map.Generico;
import Business.Interface.IGenericoBll;
import DataAccess.GenericoDal;
import DataAccess.Interface.IGenericoDal;
import DataAccess.Utils.Helpers.DalHelper;
import static Factory.New.New;

/**
 *
 * @author matheusdsl
 */

public class GenericoBll extends DalHelper<Generico> implements IGenericoBll {

    private final IGenericoDal GenericoDal = New(GenericoDal.class);

    @Override
    public Generico BuscarPorNome(String nome)
    {
       return this.GenericoDal.Buscar(nome);
    } 
}
