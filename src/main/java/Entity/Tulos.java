package Entity;
import dao.DaoController;
import simu.framework.*;
import simu.model.*;


public class Tulos {
    private double kokonaisaika;
    private int asiakkaiden_maara;
    private double asiakkaiden_keskimaarainen_ika;
    private double palvelupisteidenKokonaisPalveluAika;
    private double suoritusteho;

    public Tulos(double kokonaisaika,int asiakkaiden_maara, double asiakkaiden_keskimaarainen_ika,double palvelupisteidenKokonaisPalveluAika, double suoritusteho){
        this.kokonaisaika = kokonaisaika;
        this.asiakkaiden_maara = asiakkaiden_maara;
        this.asiakkaiden_keskimaarainen_ika = asiakkaiden_keskimaarainen_ika;
        this.palvelupisteidenKokonaisPalveluAika = palvelupisteidenKokonaisPalveluAika;
        this.suoritusteho = suoritusteho;
    }

    public double getKokonaisaika() {
        return kokonaisaika;
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

    public int getAsiakkaiden_maara() {
        return asiakkaiden_maara;
    }

    public void setAsiakkaiden_maara(int asiakkaiden_maara) {
        this.asiakkaiden_maara = asiakkaiden_maara;
    }

    public double getPalvelupisteidenKokonaisPalveluAika() {
        return palvelupisteidenKokonaisPalveluAika;
    }

    public void setPalvelupisteidenKokonaisPalveluAika(double palvelupisteidenKokonaisPalveluAika) {
        this.palvelupisteidenKokonaisPalveluAika = palvelupisteidenKokonaisPalveluAika;
    }

    public double getSuoritusteho() {
        return suoritusteho;
    }

    public void setSuoritusteho(double suoritusteho) {
        this.suoritusteho = suoritusteho;
    }
}
