/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Dto.Common;

import Web.Utils.Enum.BotaoEnum;
import java.util.List;

/**
 *
 * @author matheusdsl
 */
public class ModalDto {
    String titulo;
    String corpo;
    BotaoEnum btns[];

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public BotaoEnum[] getBtns() {
        return btns;
    }

    public void setBtns(BotaoEnum[] btns) {
        this.btns = btns;
    }

   
    
}
