class Menu{
    String[] tabChoix;
    String question;
    Menu(String q, String[] t) throws NPasBon{
        if (t.length > 9){
            throw new NPasBon();
        }
        tabChoix = t;
        question = q;
    }

    public static void main(String[] args){
        String[] st1 = {"Partir loin", "Rester au lit", "Se lever"};
        String[] st2 = {"Rouge", "Vert", "Bleu", "Jaune", "Violet"};
        String[] st3 = {"Canard", "Poule", "Pintade", "Oie", "Dinde", "Pleiades"};
        Menu[] mt = new Menu[3];
        boolean saisieOk;
        try{
            mt[0] = new Menu("Que voulez-vous faire? ", st1);
            mt[1] = new Menu("Quelle est votre couleur préférée?", st2);
            mt[2] = new Menu("Trouvez l’intrus.", st3);
        }catch(NPasBon ex){
            Terminal.ecrireStringln("Le nombre doit être supérieur à 1");
        }
        for (int i=0; i<5; i++){
            do{
                try{
                    saisieOk = true;
                    mt[i % 3].executerMenu();
                }catch(HorsIntervalle ex){
                    Terminal.ecrireString("Vous devez entrer un");
                    Terminal.ecrireStringln(" des choix proposés.");
                    saisieOk = false;
                }catch(PasNombre ex){
                    Terminal.ecrireStringln("Vous devez entrer un nombre.");
                    saisieOk = false;
                }
            }while(!saisieOk);
        }
    }
    void affiche(){
        Terminal.ecrireStringln(question);
        for(int i=0; i<tabChoix.length; i++){
            Terminal.ecrireStringln(tabChoix[i] + ": tapez " + (i+1));
        }
        Terminal.ecrireString("Entrez votre choix: ");
    }
    int charToInt(char c) throws PasNombre{
        if (c == '1'){
            return 1;
        }else if(c == '2'){
            return 2;
        }else if(c == '3'){
            return 3;
        }else if(c == '4'){
            return 4;
        }else if(c == '5'){
            return 5;
        }else if(c == '6'){
            return 6;
        }else if(c == '7'){
            return 7;
        }else if(c == '8'){
            return 8;
        }else if(c == '9'){
            return 9;
        }else if(c == '0'){
            return 0;
        }
        throw new PasNombre();
    }
    int saisir() throws PasNombre, HorsIntervalle{
        char rep = Terminal.lireChar();
        int repInt;
        repInt = charToInt(rep);
        if ((repInt ==0) || (repInt > tabChoix.length)){
            throw new HorsIntervalle();
        }
        return repInt;
    }
    int executerMenu() throws PasNombre, HorsIntervalle{
        affiche();
        return saisir();
    }

class NPasBon extends Exception{}

class PasNombre extends Exception{}

class HorsIntervalle extends Exception{}
}


