/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.DataAccess;

import com.ProjetoADS5.Common.Const.MessagesConst;
import com.ProjetoADS5.Common.Dto.TransferObjectDto;
import com.ProjetoADS5.Business.Entity.Map.Usuario;
import com.ProjetoADS5.DataAccess.Interface.IUsuarioDal;
import com.ProjetoADS5.DataAccess.Utils.Helpers.DalHelper;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Gabriel
 */
public class UsuarioDal extends DalHelper<Usuario> implements IUsuarioDal {

    public UsuarioDal(Class<Usuario> entidade) {
        super(entidade);
    }

    @Override
    public Usuario ValidarUsuario(
            String usuario,
            String senha) {
        Session s = getSession();
        Criteria crit = s.createCriteria(Usuario.class);
        try {
            crit.add(Restrictions.eq("usuario", usuario));
            crit.add(Restrictions.eq("senha", senha))
            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            return (Usuario) crit.uniqueResult();
        } finally {
            s.close();
        }
    }
}
