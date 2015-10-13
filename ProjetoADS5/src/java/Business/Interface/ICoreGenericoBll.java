/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Interface;

import Business.Entity.Map.CoreGenerico;
import DataAccess.Utils.Helpers.IDalHelper;

/**
 *
 * @author matheusdsl
 */
public interface ICoreGenericoBll extends IDalHelper<CoreGenerico> {
    CoreGenerico BuscarPorNome(String nome);
}
