package controller;

public interface IKontrolleriForM {

    // Rajapinta, joka tarjotaan moottorille:

    public void naytaLoppuaika(double aika);
    public void visualisoiAsiakas();

    public void visualisoiJono();

    public void visualisoiJonostaPoisto();

    public void drawPalveluPiste(int index, boolean isReserved);
}
