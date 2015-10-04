/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Interface.IExemploBll;
import DataAccess.ExemploDal;
import DataAccess.Interface.IExemploDal;
import Business.Entity.Exemplo;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 *
 * @author matheusdsl
 */
public class ExemploBll implements IExemploBll {

    private final IExemploDal ExemploDal;

    public ExemploBll() {
        this.ExemploDal = new ExemploDal();
    }

    @Override
    public Exemplo Buscar(int id) {
        return this.ExemploDal.Buscar(id);
    }

    
}
