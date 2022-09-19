public class JulesCesar {
    public static void main(String[] args) {
        Terminal.ecrireString("Saisir une chaîne de caractères : ");
        String st = Terminal.lireString();
        Terminal.ecrireStringln(st + " => " + cesarEncode(st));
        Terminal.ecrireStringln(cesarDecode(cesarEncode(st)));

    }
    static String cesarEncode(String s){
        String res = "";
        for (int i=0; i<s.length(); i++){
            res += charCesarEncode(s.charAt(i));
        }
        return res;
    }

    static String cesarDecode(String s){
        String res = "";
        for (int i=0; i<s.length(); i++){
            res += charCesarDecode(s.charAt(i));
        }
        return res;
    }

    static char charCesarDecode(char c){
        if ((c>= 'A') && (c<='C')){
            return (char) (c+ 23); // X, Y, Z
        }
        if ((c>= 'a') && (c<='c')){
            return (char) (c+23); // x, y, z
        }
        if ((c>= 'd') && (c<='z')){
            return (char) (c-3);
        }
        if ((c>= 'D') && (c<='Z')){
            return (char) (c-3);
        }
        return c;
    }

    static char charCesarEncode(char c){
        if ((c>= 'A') && (c<='W')){
            return (char) (c+ 3);
        }
        if ((c>= 'a') && (c<='w')){
            return (char) (c+3);
        }
        if ((c>= 'x') && (c<='z')){
            return (char) (c-23);
        }
        if ((c>= 'X') && (c<='Z')){
            return (char) (c-23);
        }
        return c;
    }
}
