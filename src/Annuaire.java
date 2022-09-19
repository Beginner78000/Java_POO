import java.util.*;

public class Annuaire {
    public static void main(String[] args){

        String[] annuaire = Terminal.lireFichierTexte("Annuaire.txt");

        System.out.println(Arrays.toString(annuaire));

        Terminal.ecrireString("Saisir un nom : ");
        String n = Terminal.lireString();

        boolean isFound = false;

        for(String word : annuaire) {
            StringTokenizer str = new StringTokenizer(word, ";");
            Terminal.ecrireIntln(str.countTokens());
            String nom = str.nextToken();
            String firstname = str.nextToken();
            String adresse = str.nextToken();
            String tel = str.nextToken();

            if(nom.equals(n)){
                isFound = true;
                //create a hashmap having String type of key-value
                HashMap<String,String> hashmap = new HashMap<>();

                //use for loop to pull the elements of array to hashmap's key
                for (int j = 0; j < annuaire.length; j++) {
                    hashmap.put(annuaire[j], String.valueOf(j));
                }
                Terminal.ecrireStringln(firstname + " "+ nom +" : "+ adresse +" / "+ tel);
                
                // use hashmap.keySet() for printing all keys of hashmap using its keySet() method
                System.out.println(hashmap.keySet());

            }
        }
        if(!isFound){
            System.out.println("Le nom ne se trouve pas dans l'annuaire");
        }
    }
}
