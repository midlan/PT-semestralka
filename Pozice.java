/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kate
 */
public class Pozice {

    final Uzemi mapa;
    private double x;
    private double y;

    public Pozice(double x, double y, Uzemi mapa) throws SouradniceException {
        this.setX(x);
        this.setY(y);
        this.mapa = mapa;
    }

    public void setX(double x) throws SouradniceException {
        if (x < mapa.sirka) {
            this.x = x;
            return;
        }
        throw new SouradniceException();
    }

    public void setY(double y) throws SouradniceException {
        if (y < mapa.vyska) {
            this.y = y;
            return;
        }
        throw new SouradniceException();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
