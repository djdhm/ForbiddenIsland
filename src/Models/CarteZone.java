package Models;


public class CarteZone implements  Carte {
    private Zone zone;

    public CarteZone(Zone zone) {
        this.zone = zone;
    }

    @Override
    public void effetCarte(Joueur joueur)  {
        if(!zone.getSituationZone().equals(EtatZone.SUBMERGEE)){
            System.out.println("Effectuer innondation de zone "+joueur.getPseudo());
            System.out.println("La zone precedemment"+zone.toString());
            zone.innoderZone();
            System.out.println("La zone actuellement"+zone.toString());


        }
    }

    public boolean aDefausser(){
        return this.zone.equals(EtatZone.SUBMERGEE);

    }
    public Zone getZone() {
        return zone;
    }
}
