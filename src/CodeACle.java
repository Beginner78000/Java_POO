public class CodeACle {
    public static void main(String[] args){
        String st = "bonjourcommentva";
        int[] cle = {2,3,7,8,1};
        Terminal.ecrireStringln(st + " => " + aCleEncode(st,cle));
        st = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Terminal.ecrireStringln(st + " => " + aCleEncode(st,cle));
        Terminal.ecrireStringln("23781237812378123781237812378123781");
        Terminal.ecrireStringln(aCleDecode(aCleEncode(st,cle),cle));

    }

    static String aCleEncode(String s, int[] cle){
        String res = "";
        for (int i=0; i<s.length(); i++){
            res = res + charACleEncode(s.charAt(i),cle[i % cle.length]);
        }
        return res;
    }
    static String aCleDecode(String s, int[] cle){
        String res = "";
        for (int i=0; i<s.length(); i++){
            res = res + charACleDecode(s.charAt(i),cle[i % cle.length]);
        }
        return res;
    }
    static char charACleDecode(char c, int n){
        if ((c>= 'A') && (c<(char) 'A'+n)){
            return (char) (c+ 26 -n);
        }
        if ((c>= 'a') && (c<(char) 'a'+n)){
            return (char) (c+ 26 -n);
        }
        if ((c>=(char) 'A'+n) && (c<='z')){
            return (char) (c-n);
        }
        if ((c>=(char) 'a'+n) && (c<='Z')){
            return (char) (c-n);
        }
        return c;
    }
    static char charACleEncode(char c, int n){
        if ((c>= 'A') && (c<=(char) 'Z'-n)){
            return (char) (c+ n);
        }
        if ((c>= 'a') && (c<=(char) 'z'-n)){
            return (char) (c+n);
        }
        if ((c>(char) 'z'-n) && (c<='z')){
            return (char) (c-26+n);
        }
        if ((c> (char) 'Z'-n) && (c<='Z')){
            return (char) (c-26+n);
        }
        return c;
    }
}
