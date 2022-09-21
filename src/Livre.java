import java.util.ArrayList;

public class Livre {
    public static void main (String[] args) {
        ArrayList<Livre> bibliotheque = new ArrayList<>();

        boolean add;

        do{
            bibliotheque.add(Livre.addLivre());
            Terminal.ecrireString("Voulez-vous ajouter un livre (o / n) : ");
            char res = Terminal.lireChar();
            if(res == 'o'){
                add = true;
            }else {
                add= false;
            }
        }while(add);
        //Livre chartreuse = new Livre("La Chartreuse de Parme", "Stendhal", "Gallimard");

        for (Livre book : bibliotheque) {
            afficher(book.toString());
        }
    }

    static String titre;
    static String author;
    static String editor;

    public Livre(String titre, String author, String editor){
        Livre.titre = titre;
        Livre.author = author;
        Livre.editor = editor;
    }

    static void afficher(String book){
        book = "Le livre " + titre + " a été écrit par " + author + " et publié par " + editor;
        System.out.println(book);
    }

    static Livre addLivre(){
        Terminal.ecrireStringln("Saisir titre du livre : ");
        String t = Terminal.lireString();

        Terminal.ecrireStringln("Saisir le nom de l'auteur : ");
        String a = Terminal.lireString();

        Terminal.ecrireStringln("Saisir l'éditeur : ");
        String e = Terminal.lireString();

        return new Livre(t, a, e);
    }
}
