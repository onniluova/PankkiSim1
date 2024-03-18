package simu.framework;

import eduni.distributions.*;

public class IkaGeneraattori {
    private Uniform uniformDistribution;

    /**
     * IkaGeneraattori-luokan konstruktori.
     *
     * @param lowerBound Alaraja iälle.
     * @param upperBound Yläraja iälle.
     */
    public IkaGeneraattori(double lowerBound, double upperBound) {
        uniformDistribution = new Uniform(lowerBound, upperBound);
    }

    /**
     * Generoi iän.
     *
     * @return Satunnaisesti generoitu ikä.
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