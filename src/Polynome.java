class Polynome{
    int[] tab=new int[0];
    void affiche(){
        if (tab.length > 0){
            Terminal.ecrireString(""+tab[tab.length-1]+"*x^" + (tab.length-1));
            for (int i=tab.length-2; i>=0; i--){
                if (tab[i]!=0){
                    if (tab[i]>0){
                        Terminal.ecrireString("+");
                    }
                    Terminal.ecrireString(""+tab[i]+"*x^" +i);
                }
            }
        }
    }
    void ajouteFacteur(int coeff,int degre){
        if (degre>= tab.length){
            int[] newTab = new int[degre+1];
            for (int i=0; i<tab.length; i++){
                newTab[i]=tab[i];
            }
            newTab[degre]=coeff;
            tab=newTab;
        }else{
            tab[degre]=tab[degre]+coeff;
        }
    }
    Polynome ajouter(Polynome p){
        Polynome res = new Polynome();
        for (int i=0; i<tab.length; i++){
            res.ajouteFacteur(tab[i],i);
        }
        for (int i=0; i<p.tab.length; i++){
            res.ajouteFacteur(p.tab[i],i);
        }
        return res;
    }
    Polynome multiplier(Polynome p){
        Polynome res = new Polynome();
        for (int i=0; i<tab.length; i++){
            for (int j=0; j<p.tab.length;j++){
                res.ajouteFacteur(tab[i]*p.tab[j],i+j);
            }
        }
        return res;
    }
}
class Exo_14_4_bis{
    public static void main(String[] argv){
        Polynome p1=new Polynome();
        Polynome p2=new Polynome();
        p1.ajouteFacteur(3,3);
        p1.ajouteFacteur(-5,2);
        p1.ajouteFacteur(2,0);
        p1.affiche();
        Terminal.sautDeLigne();
        p2.ajouteFacteur(2,3);
        p2.ajouteFacteur(-4,1);
        p2.ajouteFacteur(-3,0);
        p2.affiche();
        Terminal.sautDeLigne();
        (p1.ajouter(p2)).affiche();
        Terminal.sautDeLigne();
        (p1.multiplier(p2)).affiche();
        Terminal.sautDeLigne();
    }
}