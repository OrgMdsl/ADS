/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Common.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author matheusdsl
 */
public class Valida {

    public static boolean IsCpf(String strCpf) {
        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;
        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;
        strCpf = strCpf.replace(".", "");
        strCpf = strCpf.replace("-", "");
        for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
            digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();
            d1 = d1 + (11 - nCount) * digitoCPF;
            d2 = d2 + (12 - nCount) * digitoCPF;
        };
        resto = (d1 % 11);
        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }

        d2 += 2 * digito1;
        resto = (d2 % 11);
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }
        String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        return nDigVerific.equals(nDigResult);
    }

    public static boolean IsCnpj(String cnpj) {
        cnpj = cnpj.replaceAll(Pattern.compile("\\s").toString(), "");
        cnpj = cnpj.replaceAll(Pattern.compile("\\D").toString(), "");

        int soma = 0;

        if (cnpj.length() != 14) {
            return false;
        }

        aCnpj = cnpj.toCharArray();

        soma += (parseCharToInt(aCnpj[0]) * 5);
        soma += (parseCharToInt(aCnpj[1]) * 4);
        soma += (parseCharToInt(aCnpj[2]) * 3);
        soma += (parseCharToInt(aCnpj[3]) * 2);
        soma += (parseCharToInt(aCnpj[4]) * 9);
        soma += (parseCharToInt(aCnpj[5]) * 8);
        soma += (parseCharToInt(aCnpj[6]) * 7);
        soma += (parseCharToInt(aCnpj[7]) * 6);
        soma += (parseCharToInt(aCnpj[8]) * 5);
        soma += (parseCharToInt(aCnpj[9]) * 4);
        soma += (parseCharToInt(aCnpj[10]) * 3);
        soma += (parseCharToInt(aCnpj[11]) * 2);

        int d1 = soma % 11;
        d1 = d1 < 2 ? 0 : 11 - d1;

        soma = 0;
        soma += (parseCharToInt(aCnpj[0]) * 6);
        soma += (parseCharToInt(aCnpj[1]) * 5);
        soma += (parseCharToInt(aCnpj[2]) * 4);
        soma += (parseCharToInt(aCnpj[3]) * 3);
        soma += (parseCharToInt(aCnpj[4]) * 2);
        soma += (parseCharToInt(aCnpj[5]) * 9);
        soma += (parseCharToInt(aCnpj[6]) * 8);
        soma += (parseCharToInt(aCnpj[7]) * 7);
        soma += (parseCharToInt(aCnpj[8]) * 6);
        soma += (parseCharToInt(aCnpj[9]) * 5);
        soma += (parseCharToInt(aCnpj[10]) * 4);
        soma += (parseCharToInt(aCnpj[11]) * 3);
        soma += (parseCharToInt(aCnpj[12]) * 2);

        int d2 = soma % 11;
        d2 = d2 < 2 ? 0 : 11 - d2;

        if (parseCharToInt(aCnpj[12]) == d1 && parseCharToInt(aCnpj[13]) == d2) {
            return true;
        } else {
            return false;
        }
    }
    private static char[] aCnpj;
    private static int parseCharToInt(char c) {
        return Integer.parseInt(Character.toString(c));
    }
    
    public static boolean IsEmail(String email) {
        if ((email == null) || (email.trim().length() == 0))
            return false;

        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
