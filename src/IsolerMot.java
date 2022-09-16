import java.lang.reflect.Array;
import java.util.Arrays;

public class IsolerMot {
    public static String[] listWords(final String sentence){
        return Arrays
                .stream(sentence.split("\s"))
                .distinct()
                .toArray(String[]::new);
    }
}
