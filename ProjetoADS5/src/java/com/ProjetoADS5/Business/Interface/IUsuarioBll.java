/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Business.Interface;

import com.ProjetoADS5.Common.Dto.TransferObjectDto;
import com.ProjetoADS5.Business.Entity.Map.Usuario;
import com.ProjetoADS5.DataAccess.Utils.Helpers.IDalHelper;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel
 */
public interface IUsuarioBll extends IDalHelper<Usuario> {

    Usuario ValidarUsuario(String usuario, String senha);
}
