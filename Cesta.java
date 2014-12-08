
/**
 *
 * @author midlan_
 */
public class Cesta {

    private final Budova kam;
    private final double vzdalenost;

    public Cesta(Budova kam, double vzdalenost) {
        this.kam = kam;
        this.vzdalenost = vzdalenost;
    }

    public Budova getKam() {
        return kam;
    }

    public double getVzdalenost() {
        return vzdalenost;
    }
}
