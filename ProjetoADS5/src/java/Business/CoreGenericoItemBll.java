/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Entity.Map.CoreGenerico;
import Business.Entity.Map.CoreGenericoItem;
import Business.Interface.ICoreGenericoItemBll;
import DataAccess.CoreGenericoItemDal;
import DataAccess.Interface.ICoreGenericoItemDal;
import DataAccess.Utils.Helpers.DalHelper;
import java.util.Set;

/**
 *
 * @author matheusdsl
 */
public class CoreGenericoItemBll extends DalHelper<CoreGenericoItem> implements ICoreGenericoItemBll {

    public final ICoreGenericoItemDal CoreGenericoItemDal = new CoreGenericoItemDal();

    @Override
    public CoreGenericoItem BuscarPorSigla(String sigla, String nomePai) {
        return CoreGenericoItemDal.BuscarPorSigla(sigla, nomePai);
    }

    @Override
    public Set<CoreGenericoItem> GetItens(Integer idPai) {
        return CoreGenericoItemDal.GetItens(idPai);
    }

}
