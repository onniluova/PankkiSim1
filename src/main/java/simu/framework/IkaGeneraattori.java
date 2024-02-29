package simu.framework;

import eduni.distributions.*;

import java.util.ArrayList;

public class IkaGeneraattori {
    private Uniform uniformDistribution;

    public IkaGeneraattori(double lowerBound, double upperBound) {
        uniformDistribution = new Uniform(lowerBound, upperBound);
    }

    public int generoiIka() {
        return (int) uniformDistribution.sample();
    }

    public static void main(String[] args) {
        double lowerBound = 18; // minimum age
        double upperBound = 65; // maximum age

        IkaGeneraattori ageGenerator = new IkaGeneraattori(lowerBound, upperBound);
    }
}
