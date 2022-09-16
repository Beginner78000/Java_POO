import java.util.Scanner;

public class Palindrome {

    public static boolean TestPhrase(String word) {
        int i = 0;
        int longueur = word.length()-1;
        boolean equal = true;

        // Tester le 1er caractère avec le dernier, s'ils sont égaux le programme continue
        // On déroule la boucle while et on test i+1 avec longeur-(i+1) jusqu'a ce que i = longueur/2
        // Sinon le boolean reçoit false et retourne false

        while(i<longueur/2 && equal) {
            if(word.charAt(i) == word.charAt(longueur-i)) {
                equal = true;
            }else {
                equal = false;
            }
            i++;
        }

        return equal;
    }

    public static void main(String[] args) {
        String word, reverse_word = "";
        Scanner in = new Scanner(System.in);

        System.out.println("Entrer un mot");
        word = in.nextLine();

        Phrase mot = new Phrase(word);


        if(TestPhrase(word)) {
            System.out.println("Le mot '"+word+"' est un palindrome");
        } else {
            System.out.println("Le mot '"+word+"' n'est pas un palindrome");
        }
    }
}
