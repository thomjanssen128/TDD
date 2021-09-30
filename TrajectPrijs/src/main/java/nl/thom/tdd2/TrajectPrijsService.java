package nl.thom.tdd2;

public class TrajectPrijsService {

    private final TrajectNaarTrajectEenhedenService tntes;
    private final TrajectEenhedenNaarPrijsService tenps;

    public TrajectPrijsService(TrajectNaarTrajectEenhedenService tntes, TrajectEenhedenNaarPrijsService tenps) {
        this.tntes = tntes;
        this.tenps = tenps;
    }

    public double getTrajectPrijs(String from, String to) {
        int eenheden = tenps.getTrajectEenheden(from, to);
        return tntes.getPriceTrajectEenheden(eenheden);
    }

}
