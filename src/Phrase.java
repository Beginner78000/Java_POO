public class Phrase {
    String phrase;

    public Phrase(String in){
        this.phrase = in;
    }

    public void setPhrase() {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    public void diminuerBlancs() {
        String res = "";
        // parcourir la phrase
        for(int i = 0; i < this.phrase.length(); i++) {
            if(this.phrase.charAt(i) != ' '){
                res += this.phrase.charAt(i);
            }
        }
        this.phrase = res;

    }
}
