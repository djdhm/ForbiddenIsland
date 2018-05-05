import Models.PaquetRechercheCle;
import Views.MenuPrincipal;

public class Main {

    public static void main(String[] argc){
        System.out.print("Ell");
        PaquetRechercheCle test=new PaquetRechercheCle();
        test.initialisationPaquet();
        MenuPrincipal menu=new MenuPrincipal();

        menu.show();

    }
}
