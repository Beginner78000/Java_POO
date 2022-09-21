class NotFound extends Error{}
class Exo_14_3{
    public static void main(String[] argv){
        Produit.Stock st = new Produit.Stock();
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
