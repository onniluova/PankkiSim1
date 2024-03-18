import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simu.framework.Trace;
import simu.model.Asiakas;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsiakasTest {
    private Asiakas asiakas;

    @BeforeEach
    public void setUp() {
        Trace.setTraceLevel(Trace.Level.INFO); // Add this line
        asiakas = new Asiakas();
    }

    @Test
    public void testGetSaapumisaika() {
        double expectedSaapumisaika = asiakas.getSaapumisaika();
        assertEquals(expectedSaapumisaika, asiakas.getSaapumisaika());
    }

    @Test
    public void testGetPoistumisaika() {
        double expectedPoistumisaika = asiakas.getPoistumisaika();
        assertEquals(expectedPoistumisaika, asiakas.getPoistumisaika());
    }

    @Test
    public void testGetId() {
        int expectedId = asiakas.getId();
        assertEquals(expectedId, asiakas.getId());
    }

    @Test
    public void testGetTapahtuma() {
        int expectedTapahtuma = asiakas.getTapahtuma();
        assertEquals(expectedTapahtuma, asiakas.getTapahtuma());
    }

    @Test
    public void testGetArviointienKeskiarvo() {
        int expectedArviointienKeskiarvo = asiakas.getArviointienKeskiarvo();
        assertEquals(expectedArviointienKeskiarvo, asiakas.getArviointienKeskiarvo());
    }
}