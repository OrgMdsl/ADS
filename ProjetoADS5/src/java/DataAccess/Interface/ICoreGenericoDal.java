/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Interface;

import Business.Entity.Map.CoreGenerico;
import DataAccess.Utils.Helpers.IDalHelper;

/**
 *
 * @author matheusdsl
 */
public interface ICoreGenericoDal extends IDalHelper<CoreGenerico> {
    CoreGenerico Buscar(String nome);
}
