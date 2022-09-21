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
            return false;
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
            while ((i<nbProduits) && (tab[i].precede(p))){
                i++;
            }
            for (int j=nbProduits; j>i; j--){
                tab[j]=tab[j-1];
            }
            tab[i]=p;
            nbProduits++;
            return this;
        }
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
}


