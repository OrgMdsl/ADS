/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Factory;

import java.util.Arrays;

/**
 *
 * @author matheusdsl
 */
public class New {

    public static <T> T New(Class<T> clazz) {
        try {
            System.out.println(" :: CLASSE INSTANCIADA :: " + clazz.getName());
            T classe = clazz.newInstance();
            return classe;
        } catch (InstantiationException | IllegalAccessException ex) {
            System.out.println(" :: ##### ERRO :: " + ex.getMessage());
            System.out.println(" :: # :: " + Arrays.toString(ex.getStackTrace()));
            return null;
        }
    }
}
