package simu.framework;

import eduni.distributions.*;

/**
 * Luokka, joka generoi satunnaisia ikäarvoja.
 */
public class IkaGeneraattori {
    private Uniform uniformDistribution;

    /**
     * IkaGeneraattori-luokan konstruktori.
     *
     * @param lowerBound Alaraja ikäarvolle.
     * @param upperBound Yläraja ikäarvolle.
     */
    public IkaGeneraattori(double lowerBound, double upperBound) {
        uniformDistribution = new Uniform(lowerBound, upperBound);
    }

    /**
     * Generoi satunnaisen ikäarvon.
     *
     * @return Satunnainen ikäarvo.
     */
    public int generoiIka() {
        return (int) uniformDistribution.sample();
    }

    /**
     * Pääohjelma testausta varten.
     *
     * @param args Komentoriviparametrit.
     */
    public static void main(String[] args) {
        double lowerBound = 18; // minimum age
        double upperBound = 65; // maximum age

        IkaGeneraattori ageGenerator = new IkaGeneraattori(lowerBound, upperBound);
    }
}