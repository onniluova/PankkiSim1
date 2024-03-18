package Entity;
import dao.DaoController;
import simu.framework.*;
import simu.model.*;

/**
 * Luokka, joka hallinnoi tulosten toimintoja.
 */
public class Tulos {
    private int saapuneetAsiakkaat;
    private int palvellutAsiakkaat;
    private double kokonaisaika;
    private int asiakkaiden_maara;
    private double asiakkaiden_keskimaarainen_ika;
    private double palvelupisteidenKokonaisPalveluAika;
    private double suoritusteho;

    /**
     * Tulos-luokan konstruktori.
     *
     * @param kokonaisaika Kokonaisaika.
     * @param asiakkaiden_maara Asiakkaiden määrä.
     * @param asiakkaiden_keskimaarainen_ika Asiakkaiden keskimääräinen ikä.
     * @param palvelupisteidenKokonaisPalveluAika Palvelupisteiden kokonaispalveluaika.
     * @param suoritusteho Suoritusteho.
     */
    public Tulos(double kokonaisaika,int asiakkaiden_maara, double asiakkaiden_keskimaarainen_ika,double palvelupisteidenKokonaisPalveluAika, double suoritusteho,int saapuneetAsiakkaat, int palvellutAsiakkaat){
        this.kokonaisaika = kokonaisaika;
        this.asiakkaiden_maara = asiakkaiden_maara;
        this.asiakkaiden_keskimaarainen_ika = asiakkaiden_keskimaarainen_ika;
        this.palvelupisteidenKokonaisPalveluAika = palvelupisteidenKokonaisPalveluAika;
        this.suoritusteho = suoritusteho;
        this.saapuneetAsiakkaat = saapuneetAsiakkaat;
        this.palvellutAsiakkaat = palvellutAsiakkaat;
    }

    /**
     * Palauttaa kokonaisajan.
     *
     * @return Kokonaisaika.
     */
    public double getKokonaisaika() {
        return kokonaisaika;
    }

    /**
     * Palauttaa asiakkaiden keskimääräisen iän.
     *
     * @return Asiakkaiden keskimääräinen ikä.
     */
    public double getAsiakkaiden_keskimaarainen_ika() {
        return asiakkaiden_keskimaarainen_ika;
    }

    /**
     * Asettaa kokonaisajan.
     *
     * @param kokonaisaika Kokonaisaika.
     */
    public void setKokonaisaika(double kokonaisaika) {
        this.kokonaisaika = kokonaisaika;
    }

    /**
     * Asettaa asiakkaiden keskimääräisen iän.
     *
     * @param asiakkaiden_keskimaarainen_ika Asiakkaiden keskimääräinen ikä.
     */
    public void setAsiakkaiden_keskimaarainen_ika(double asiakkaiden_keskimaarainen_ika) {
        this.asiakkaiden_keskimaarainen_ika = asiakkaiden_keskimaarainen_ika;
    }

    /**
     * Palauttaa asiakkaiden määrän.
     *
     * @return Asiakkaiden määrä.
     */
    public int getAsiakkaiden_maara() {
        return asiakkaiden_maara;
    }

    /**
     * Asettaa asiakkaiden määrän.
     *
     * @param asiakkaiden_maara Asiakkaiden määrä.
     */
    public void setAsiakkaiden_maara(int asiakkaiden_maara) {
        this.asiakkaiden_maara = asiakkaiden_maara;
    }

    /**
     * Palauttaa palvelupisteiden kokonaispalveluajan.
     *
     * @return Palvelupisteiden kokonaispalveluaika.
     */
    public double getPalvelupisteidenKokonaisPalveluAika() {
        return palvelupisteidenKokonaisPalveluAika;
    }

    /**
     * Asettaa palvelupisteiden kokonaispalveluajan.
     *
     * @param palvelupisteidenKokonaisPalveluAika Palvelupisteiden kokonaispalveluaika.
     */
    public void setPalvelupisteidenKokonaisPalveluAika(double palvelupisteidenKokonaisPalveluAika) {
        this.palvelupisteidenKokonaisPalveluAika = palvelupisteidenKokonaisPalveluAika;
    }

    /**
     * Palauttaa suoritustehon.
     *
     * @return Suoritusteho.
     */
    public double getSuoritusteho() {
        return suoritusteho;
    }

    /**
     * Asettaa suoritustehon.
     *
     * @param suoritusteho Suoritusteho.
     */
    public void setSuoritusteho(double suoritusteho) {
        this.suoritusteho = suoritusteho;
    }

    public int getPalvellutAsiakkaat() {
        return palvellutAsiakkaat;
    }

    public void setPalvellutAsiakkaat(int palvellutAsiakkaat) {
        this.palvellutAsiakkaat = palvellutAsiakkaat;
    }

    public int getSaapuneetAsiakkaat() {
        return saapuneetAsiakkaat;
    }

    public void setSaapuneetAsiakkaat(int saapuneetAsiakkaat) {
        this.saapuneetAsiakkaat = saapuneetAsiakkaat;
    }
}