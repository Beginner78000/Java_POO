public class RomanNumber {
    public static void main(String[] args){
        Terminal.ecrireString("Entrez un nombre a convertir: ");
        Terminal.ecrireIntln(nombreToInt(Terminal.lireString()));

    }

    public static int chiffreToInt(char c){
        int res;
        if (c == 'I'){
            res = 1;
        }else if (c == 'V'){
            res = 5;
        }else if (c == 'X'){
            res = 10;
        }else if (c == 'L'){
            res = 50;
        }else if (c == 'C'){
            res = 100;
        }else if (c == 'D'){
            res = 500;
        }else if (c == 'M'){
            res = 1000;
        }else{
            throw new Error("ce n’est pas un chiffre romain: " + c);
        }
        return res;
    }

    public static int nombreToInt(String s){
        int res = chiffreToInt(s.charAt(s.length()-1));
        int valprec = res;
        int valcour;
        for (int i=s.length()-2; i>=0; i--){
            valcour = chiffreToInt(s.charAt(i));
            if (valcour >= valprec){
                res = res + valcour;
            }else{
                res = res -valcour;
            }
            valprec = valcour;
        }
        return res;
    }
}
