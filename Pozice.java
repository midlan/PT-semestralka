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
    private int x;
    private int y;

    public Pozice(int x, int y, Uzemi mapa) throws SouradniceException {
        this.setX(x);
        this.setY(y);
        this.mapa = mapa;
    }

    public void setX(int x) throws SouradniceException {
        if (x < mapa.sirka) {
            this.x = x;
            return;
        }
        throw new SouradniceException();
    }

    public void setY(int y) throws SouradniceException {
        if (y < mapa.vyska) {
            this.y = y;
            return;
        }
        throw new SouradniceException();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
