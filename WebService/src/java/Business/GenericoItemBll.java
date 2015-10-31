/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Entity.Map.GenericoItem;
import Business.Interface.IGenericoItemBll;
import DataAccess.GenericoItemDal;
import DataAccess.Interface.IGenericoItemDal;
import DataAccess.Utils.Helpers.DalHelper;
import java.util.List;
import java.util.Set;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author matheusdsl
 */
public class GenericoItemBll extends DalHelper<GenericoItem> implements IGenericoItemBll {

    public final IGenericoItemDal GenericoItemDal = new GenericoItemDal();

    @Override
    public GenericoItem BuscarPorSigla(String sigla, String nomePai) {
        return GenericoItemDal.BuscarPorSigla(sigla, nomePai);
    }

    @Override
    public List<GenericoItem> GetItens(Integer idPai) {
        return GenericoItemDal.GetItens(idPai);
    }

    @Override
    public ResponseEntity<String> AtivarDesativar(Integer id) {
        GenericoItem obj = GenericoItemDal.Buscar(id);
        obj.setAtivo(!obj.getAtivo());      
        return GenericoItemDal.Atualizar(obj);         
    }
}
