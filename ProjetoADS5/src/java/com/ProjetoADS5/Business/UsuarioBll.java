/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Business;

import com.ProjetoADS5.Common.Dto.TransferObjectDto;
import com.ProjetoADS5.Business.Entity.Map.Usuario;
import com.ProjetoADS5.Business.Interface.IUsuarioBll;
import com.ProjetoADS5.DataAccess.UsuarioDal;
import com.ProjetoADS5.DataAccess.Utils.Helpers.DalHelper;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Gabriel
 */
public class UsuarioBll extends DalHelper<Usuario> implements IUsuarioBll{

    UsuarioDal UsuarioDal = new UsuarioDal(Usuario.class);

    public UsuarioBll(Class<Usuario> entidade) {
        super(entidade);
    }
    
    @Override
    public Usuario ValidarUsuario(String usuario, String senha) {
       Usuario obj =  UsuarioDal.ValidarUsuario(usuario, senha);
       return obj;
    }
    
}
