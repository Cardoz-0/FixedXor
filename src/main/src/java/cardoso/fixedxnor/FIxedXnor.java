package main.src.java.cardoso.fixedxnor;

import main.src.java.cardoso.fixedxnor.useful.UserInput;

public class FIxedXnor {
    public static void main(String [] args){
        System.out.println("Insira a primeira string de hex");
        String string1 = hexStringToBin(UserInput.scanner());
        System.out.println("Insira a segunda string de hex");
        String string2 = hexStringToBin(UserInput.scanner());

        String xnor = XNOR(string1, string2);
        System.out.println(binToHex(xnor));
    }


    public static String hexStringToBin(String hex) {
        char[] char_arr_hex = hex.toCharArray();
        String binary = "";
        for(int i = 0; i < char_arr_hex.length; i++){
            binary = binary + charToHex(char_arr_hex[i]);
        }
    return binary;
    }

    private static String charToHex(char entrada){
        int num = (Integer.parseInt(String.valueOf(entrada), 16));
        String binary = Integer.toBinaryString(num);

        while (binary.length() != 4) {
            binary = "0" + binary;
        }
        return binary;
    }

    public static String XNOR(String s_bin_um, String s_bin_dois){
        char[] um_char = s_bin_um.toCharArray();
        char[] dois_char = s_bin_dois.toCharArray();
        String resultado = "";
        if (um_char.length != dois_char.length){
            return "ERRO, Strings de tamanhos diferentes";

        }
        else {
            for(int i = 0; i < um_char.length; i++){
                if(um_char[i] == dois_char[i]){
                    resultado = resultado + "0";
                }
                else{
                    resultado = resultado + "1";
                }
            }
        }
        return resultado;
    }
    public static String binToHex(String str_bin){
        char[] bin = str_bin.toCharArray();
        String hex = "";
        for(int i = 0; i < bin.length; i++){
            if(((i+1) % 4 == 0) && (i > 0)){
                String hexa = String.valueOf(bin[i-3]) + String.valueOf(bin[i-2]) + String.valueOf(bin[i-1] + String.valueOf(bin[i]));
                int decimal = Integer.parseInt(hexa,2);
                String hexStr = Integer.toString(decimal,16);
                hex = hex + hexStr;

            }
        }
       return hex;

    }
}
