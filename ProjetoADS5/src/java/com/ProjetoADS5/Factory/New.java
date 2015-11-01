/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Factory;

/**
 *
 * @author matheusdsl
 */
public class New {
    
    public static <T> T New(Class<T> clazz) {
        try {
            System.out.println(" :: CLASSE INSTANCIADA :: " + clazz.getName());
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            return null;
        }
    }
}
