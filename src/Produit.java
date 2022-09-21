class Produit{
    static String nom;
    static int reference;
    static double prixHT;
    Produit(String n, int ref, double prix){
            nom=n;
            reference=ref;
            prixHT=prix;
    }
    void affiche(){
            Terminal.ecrireString(nom + " reference: " + reference + " prix: ");
            Terminal.ecrireDoubleln(prixHT);
    }
    boolean precede(Produit p){
            return reference < p.reference;
    }

    static class Stock{
        Produit[] tab = new Produit[15];
        int nbProduits = 0;
        void affiche(){
            for (int i=0; i<nbProduits; i++){
                tab[i].affiche();
            }
            Terminal.sautDeLigne();
        }
        Stock ajouter(Produit p){
            int i=0;
            /**
             * On cherche d’abord l’indice i où le produit p doit être inséré.
             * Cet indice est soit celui de la première case libre (c’est-à-dire nbProduits)
             * Soit la case du premier produit qui a une référence supérieure à celle de p.
             */
            while ((i<nbProduits) && (tab[i].precede(p))){
                i++;
            }

            /**
             *  Une fois qu’on a déterminé cet emplacement, il faut décaler d’un cran tous les produits qui dans
             *  le tableau sont entre cet indice i et le dernier produit (contenu de la case d’indice nbProduits-1).
             *  Pour réaliser ce décalage, il est plus pratique de commencer par la fin,
             *  parce que la copie n’efface pas de valeur utile du tableau.
             */
            for (int j=nbProduits; j>i; j--){
                tab[j]=tab[j-1];
            }

            // Une fois ce décalage réalisé, on peut mettre p dans la case i et incrémenter nbProduits.
            tab[i]=p;
            nbProduits++;
            return this;
        }
        // On va rechercher un prix en fonction de sa reference
        double prix(int ref){
            int i=0;
            while ((i<nbProduits) && (tab[i].reference != ref)){
                i++;
            }
            if (i == nbProduits){
                throw new NotFound();
            }
            return tab[i].prixHT;
        }
    }
    static class NotFound extends Error{}
    static class TableauTrie{
        public static void main(String[] argv){
            Produit.Stock st = new Stock();
            st.ajouter(new Produit("Brosse",10025,12.50));
            st.affiche();
            st.ajouter(new Produit("Balai",10012,13.75));
            st.affiche();
            st.ajouter(new Produit("Seau",10019,7.60));
            st.affiche();
            st.ajouter(new Produit("Chiffon",10032,2.30));
            st.affiche();
            Terminal.ecrireDoubleln(st.prix(10025));

        }
    }
}


