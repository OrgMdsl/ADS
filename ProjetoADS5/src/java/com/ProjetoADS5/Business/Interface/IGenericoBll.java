/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Business.Interface;

import com.ProjetoADS5.Business.Entity.Map.Generico;
import com.ProjetoADS5.DataAccess.Utils.Helpers.IDalHelper;

/**
 *
 * @author matheusdsl
 */
public interface IGenericoBll extends IDalHelper<Generico>{
    Generico BuscarPorNome(String nome);
}
