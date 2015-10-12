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
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

/**
 *
 * @author matheusdsl
 */

public class CoreGenericoBll extends DalHelper<CoreGenerico> implements ICoreGenericoBll {

    private final ICoreGenericoDal CoreGenericoDal = new CoreGenericoDal();
    
    public CoreGenerico GetByName(String nome)
    {
       return this.CoreGenericoDal.Buscar(nome);
    } 
}
