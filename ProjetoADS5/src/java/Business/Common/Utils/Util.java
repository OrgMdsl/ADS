/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Common.Utils;

import java.util.regex.Pattern;

/**
 *
 * @author matheusdsl
 */
public class Util {

    public static String DecimalDuasCasas(double valor)    
    {     
         return String.format("%.2f", valor);      
    }
}
