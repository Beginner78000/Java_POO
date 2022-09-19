import java.util.Arrays;
import java.util.HashMap;

public class IsolerMots {
    public static void main(String[] args) {
        String phrase = "J'aime le Java car le Java c'est cool";
        String[] words = phrase.split(" ");
        System.out.print(Arrays.toString(words));

        //create a hashmap having String type of key-value
        HashMap<String,String> hashmap = new HashMap<>();

        //use for loop to pull the elements of array to hashmap's key
        for (int j = 0; j < words.length; j++) {
            hashmap.put(words[j], String.valueOf(j));
        }

        // use hashmap.keySet() for printing all keys of hashmap using its keySet() method
        System.out.println(hashmap.keySet());

        // We determine the longest word
        int longest = 0;
        String word = null;

        for(int i=0; i<words.length-1; i++){
            if(longest < words[i].length()){
                longest = words[i].length();
                word = words[i];
            }
        }

        System.out.println(word);

    }

}
