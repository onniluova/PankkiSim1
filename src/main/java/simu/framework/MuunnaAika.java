package simu.framework;

/**
 * MuunnaAika-luokka, joka muuntaa ajan minuuteiksi ja sekunneiksi.
 */
public class MuunnaAika {
    double kokonaisAika;

    /**
     * Muuntaa kokonaisajan minuuteiksi.
     *
     * @param kokonaisAika aika, joka halutaan muuntaa minuuteiksi
     * @return aika minuutteina
     */
    public static int toMinutes(double kokonaisAika) {
        double minutes = kokonaisAika / 60;
        int result = (int) minutes;
        return result;
    }

    /**
     * Muuntaa kokonaisajan sekunneiksi.
     *
     * @param kokonaisAika aika, joka halutaan muuntaa sekunneiksi
     * @return aika sekunteina
     */
    public static int toSeconds(double kokonaisAika) {
        double seconds = kokonaisAika % 60;
        int result = (int) seconds;
        return result;
    }
}