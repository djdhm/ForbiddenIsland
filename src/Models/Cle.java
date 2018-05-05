package Models;

public class Cle {

   private ElementArtefact elementCle;

   public Cle(ElementArtefact elementArtefact){
       this.elementCle=elementArtefact;
   }

    public ElementArtefact getElementCle() {
        return elementCle;
    }

    static Cle CLEAIR=new Cle(ElementArtefact.AIR);
    static Cle CLEFEU=new Cle(ElementArtefact.FEU);
    static  Cle CLEEAU =new Cle(ElementArtefact.EAU);
    static Cle CLETERRE=new Cle(ElementArtefact.TERRE);


}
