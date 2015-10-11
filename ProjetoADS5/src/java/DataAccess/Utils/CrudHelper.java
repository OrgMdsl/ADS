/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Utils;

import Business.Common.Enum.CrudEnum;
import br.com.configuration.HibernateUtility;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author matheusdsl
 */
public class CrudHelper<T> {

    public static final Session sessao = HibernateUtility.getSession();

    public void Crud(T obj, CrudEnum crud) throws Exception {
        Transaction transaction = sessao.beginTransaction();

        switch (crud) {
            case Delete:
                sessao.delete(obj);
                break;
            case Save:
                sessao.save(obj);
                break;
            case SaveUpdate:
                sessao.saveOrUpdate(obj);
                break;
            case Update:
                sessao.update(obj);
                break;
        }
        transaction.commit();
        sessao.close();
    }
}
