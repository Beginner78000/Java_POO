import java.lang.reflect.Array;
import java.util.Arrays;

public class Pendu {
    public static void main(String[] args) {
        String[] listeMots = Terminal.lireFichierTexte("Pendu.txt");

        // Calcul le nbr de milliseconde jusqu'à maintenant
        int aleatoire = Math.abs((int) (System.currentTimeMillis()));
        int numero = aleatoire % listeMots.length;
        String mot = listeMots[numero];

//        Terminal.ecrireStringln("Index aléatoire : " + numero + " / Mot trouvé : " + mot+ System.currentTimeMillis());

        // Le mot trouvé est transformé en tableau de char
        char[] motATrouve = mot.toCharArray();

        // Le mot caché de la longeur du mot à trouver contient au départ "-"
        char[] motCache = new char[motATrouve.length];

        Arrays.fill(motCache, '-');

        // Nombre d'erreurs du joueur. A plus de 7 il a perdu.
        int nbErreur = 0;
        int nbMaxErreur = 7;

        // Les lettres jouee par le joueur et son nombre de coup joués.
        char[] lettreJouees = new char[15];
        int nbCoupJoues = 0;

        // Boucle de jeu
        boolean fini = false;

        while (!fini) {
            //TODO Si le joueur a perdu
            if (nbErreur >= nbMaxErreur) {
                Terminal.ecrireString("Perdu! Le mot est: " + mot);
                fini = true;
            }
                Terminal.ecrireString("Mot a trouver  : ");
                Terminal.ecrireStringln(new String(motCache));
                Terminal.ecrireString("Lettres jouees : ");
                Terminal.ecrireStringln(new String(lettreJouees));
                Terminal.ecrireString("Nb erreurs     : ");
                Terminal.ecrireStringln("" + nbErreur);
                Terminal.ecrireString("Saisir un car  : ");
                char caracJoue = Terminal.lireChar();


            //TODO Si le caractere joue a deja ete jouee
            if (caracDansTab(caracJoue, lettreJouees)) {
                System.out.println("Caractère déjà entrée");

            } else {
                //TODO Si le caractere joue fait parti du mot a trouve
                //  alors on découvre les lettres
                //  sinon le joueur a fait une erreur
                //
                if (caracDansTab(caracJoue, motATrouve)) {
                    if(majMotCache(caracJoue, motCache, motATrouve)) {
                        fini = true;
                    }

                } else {
                    nbErreur++;
                }

                //TODO On stocke le caractère joué
                lettreJouees[nbErreur] = caracJoue;

                //TODO on incréemente le nombre de coup joués
                nbCoupJoues++;


            }
        }
    }

    //TODO Recherche si le caractere est dans un tableau de caractère
    //
    static boolean caracDansTab(char c, char[] tab) {

        for(char e:tab) {
            if (c == e) return true;
        }
        return false;
    }

    //TODO Remplace les '-' par le caractère joue si il existe.
    // Retourne true si toutes les lettres ont été trouvées
    //
    static boolean majMotCache(char c, char[] motCache, char[] motATrouve) {

        int nbc = 0;
        for(int i =0; i< motCache.length; i++) {
            if (motATrouve[i] == c) motCache[i] = c;
            if (motCache[i] == '-') nbc++;
        }

        if(nbc == 0) return true;
        else return false;
    }
}

