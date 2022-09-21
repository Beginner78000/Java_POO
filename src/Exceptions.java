public class Exceptions {
    static int[] tableau = {17, 12, 15, 38, 29, 157, 89, -22, 0, 5};
    static int division(int indice, int diviseur){
        return tableau[indice]/diviseur;
    }
    public static void main(String[] args){
        int x, y;
        boolean ok = true;
        do{
            try{
                Terminal.ecrireString("Entrez l’indice de l’entier a diviser: ");
                x = Terminal.lireInt();
                Terminal.ecrireString("Entrez le diviseur: ");
                y = Terminal.lireInt();
                Terminal.ecrireStringln("Le résultat de la division est: ");
                Terminal.ecrireIntln(division(x,y));
            }catch(ArithmeticException e){
                Terminal.ecrireStringln("Le diviseur ne doit pas être nul.");
                ok = false;
            }catch(ArrayIndexOutOfBoundsException e){
                Terminal.ecrireString("L’indice doit être compris entre 0 ");
                Terminal.ecrireStringln("et " + (tableau.length -1) + ".");
                ok = false;
            }catch(TerminalException e){
                Terminal.ecrireStringln("Vous devez entrer un nombre entier.");
                ok = false;
            }
        }while(!ok);
    }
}
