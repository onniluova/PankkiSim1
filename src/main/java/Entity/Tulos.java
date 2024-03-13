package Entity;
import dao.DaoController;
import simu.framework.*;
import simu.model.*;


public class Tulos {
    private double kokonaisaika;
    private int asiakkaiden_maara;
    private double palvelun_keskiarvo;
    private double asiakkaiden_keskimaarainen_ika;
    public Tulos(double kokonaisaika,double palvelun_keskiarvo,int asiakkaiden_maara, double asiakkaiden_keskimaarainen_ika){
        this.kokonaisaika = kokonaisaika;
        this.palvelun_keskiarvo = palvelun_keskiarvo;
        this.asiakkaiden_maara = asiakkaiden_maara;
        this.asiakkaiden_keskimaarainen_ika = asiakkaiden_keskimaarainen_ika;
    }

    public double getKokonaisaika() {
        return kokonaisaika;
    }

    public double getPalvelun_keskiarvo() {
        return palvelun_keskiarvo;
    }

    public double getAsiakkaiden_keskimaarainen_ika() {
        return asiakkaiden_keskimaarainen_ika;
    }

    public void setKokonaisaika(double kokonaisaika) {
        this.kokonaisaika = kokonaisaika;
    }

    public void setAsiakkaiden_keskimaarainen_ika(double asiakkaiden_keskimaarainen_ika) {
        this.asiakkaiden_keskimaarainen_ika = asiakkaiden_keskimaarainen_ika;
    }

    public void setPalvelun_keskiarvo(double palvelun_keskiarvo) {
        this.palvelun_keskiarvo = palvelun_keskiarvo;
    }

    public int getAsiakkaiden_maara() {
        return asiakkaiden_maara;
    }

    public void setAsiakkaiden_maara(int asiakkaiden_maara) {
        this.asiakkaiden_maara = asiakkaiden_maara;
    }
}
