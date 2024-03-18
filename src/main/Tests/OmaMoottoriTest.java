import controller.ChartsIkkunaController;
import controller.GUIkontrolleri;
import controller.IKontrolleriForM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import simu.framework.Tapahtuma;
import simu.framework.Trace;
import simu.model.Asiakas;
import simu.model.OmaMoottori;
import simu.model.Palvelupiste;
import simu.model.TapahtumanTyyppi;
import view.ISimulaattorinUI;
import simu.framework.Trace.Level;

public class OmaMoottoriTest {
    private ISimulaattorinUI mockUi;
    private IKontrolleriForM mockKontrolleri;
    private OmaMoottori moottori;
    private ChartsIkkunaController mockChartController;

    @BeforeEach
    public void setUp() {
        mockUi = Mockito.mock(GUIkontrolleri.class);
        mockKontrolleri = Mockito.mock(IKontrolleriForM.class);
        mockChartController = Mockito.mock(ChartsIkkunaController.class);
        moottori = new OmaMoottori(mockKontrolleri, mockUi, mockChartController);
        Trace.setTraceLevel(Level.INFO);

        Mockito.when(mockUi.getAika()).thenReturn(1.0);
        Mockito.when(mockUi.getViive()).thenReturn(1L);
    }

    @Test
    public void testDEP1() {
        Palvelupiste piste = moottori.getPalvelupisteet()[0];
        piste.lisaaJonoon(new Asiakas());
        moottori.suoritaTapahtuma(new Tapahtuma(TapahtumanTyyppi.DEP1, 0));
        assertFalse(piste.onJonossa());
    }

    @Test
    public void testDEP2() {
        Palvelupiste piste = moottori.getPalvelupisteet()[1];
        piste.lisaaJonoon(new Asiakas());
        moottori.suoritaTapahtuma(new Tapahtuma(TapahtumanTyyppi.DEP2, 0));
        assertFalse(piste.onJonossa());
    }

    @Test
    public void testDEP3() {
        Palvelupiste piste = moottori.getPalvelupisteet()[2];
        piste.lisaaJonoon(new Asiakas());
        moottori.suoritaTapahtuma(new Tapahtuma(TapahtumanTyyppi.DEP3, 0));
        assertFalse(piste.onJonossa());
    }

    @Test
    public void testDEP4() {
        Palvelupiste piste = moottori.getPalvelupisteet()[3];
        piste.lisaaJonoon(new Asiakas());
        moottori.suoritaTapahtuma(new Tapahtuma(TapahtumanTyyppi.DEP4, 0));
        assertFalse(piste.onJonossa());
    }
}