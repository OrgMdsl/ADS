/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Business;

import com.ProjetoADS5.Business.Entity.Map.Generico;
import com.ProjetoADS5.Business.Interface.IGenericoBll;
import com.ProjetoADS5.DataAccess.GenericoDal;
import com.ProjetoADS5.DataAccess.Interface.IGenericoDal;
import com.ProjetoADS5.DataAccess.Utils.Helpers.DalHelper;
import static com.ProjetoADS5.Factory.New.New;

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
