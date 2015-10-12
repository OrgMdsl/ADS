/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Interface;

import Business.Entity.Map.CoreGenerico;
import Business.Entity.Map.CoreGenericoItem;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import java.util.Set;

/**
 *
 * @author matheusdsl
 */
public interface ICoreGenericoDal extends GenericDAO<CoreGenerico, Long> {
    public CoreGenerico Buscar(Integer id);
    public CoreGenerico Buscar(String nome);
}
