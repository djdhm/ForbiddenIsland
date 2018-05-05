package Models;

public class CarteZone implements  Carte {
    private Zone zone;

    public CarteZone(Zone zone) {
        this.zone = zone;
    }

    @Override
    public void effetCarte(Joueur joueur) {
        System.out.println("Effectuer innondation de zone ");
        System.out.println("La zone precedemment"+zone.toString());
        zone.innoderZone();
        System.out.println("La zone actuellement"+zone.toString());


    }

    public Zone getZone() {
        return zone;
    }
}
