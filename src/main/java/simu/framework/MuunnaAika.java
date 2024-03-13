package simu.framework;


public class MuunnaAika {
    double kokonaisAika;

    public static int toMinutes(double kokonaisAika) {
        double minutes = kokonaisAika / 60;
        int result = (int) minutes;
        return result;
    }

    public static int toSeconds(double kokonaisAika) {
        double seconds = kokonaisAika % 60;
        int result = (int) seconds;
        return result;
    }
}
