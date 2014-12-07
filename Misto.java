
/**
 *
 * @author midlan_
 */
public class Misto {

    public final double x, y;
    public final Uzemi u;

    public Misto(double x, double y, Uzemi u) throws Exception {

        if (!u.souradniceUvnitr(x, y)) {
            throw new Exception("Místo není v území"); //todo special exception?
        }

        this.x = x;
        this.y = y;
        this.u = u;
    }

    public double vzdalenostOd(Misto m) throws Exception {
        if (this.u != m.u) {
            throw new Exception("Místa nejsou ve stejném území."); //todo special exception?
        }
        return Math.sqrt(Math.pow(this.x - m.x, 2) + Math.pow(this.y - m.y, 2));
    }
}
