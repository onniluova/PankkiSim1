package simu.framework;

import simu.model.Asiakas;
import java.util.ArrayList;
import java.util.HashMap;

public class PalvelupisteidenArviot {

    HashMap<Integer, Integer> palvelupisteidenArviot = new HashMap<>();
    ArrayList<Integer> tapahtumat = new ArrayList<>();

    public PalvelupisteidenArviot() {
        tapahtumat.add(0);
        tapahtumat.add(1);
        tapahtumat.add(2);
        tapahtumat.add(3);
        tapahtumat.add(4);

        for (int tapahtuma : tapahtumat) {
            palvelupisteidenArviot.put(tapahtuma, 0);
        }
    }

    public void lisaaAsiakkaanArvio(Asiakas asiakas){
        int tapahtuma = asiakas.getTapahtuma();
        int arvio = asiakas.palautaArviointi();

        switch (tapahtuma){
            case 0:
                palvelupisteidenArviot.put(0, palvelupisteidenArviot.get(0) + arvio);
                break;
            case 1:
                palvelupisteidenArviot.put(1, palvelupisteidenArviot.get(1) + arvio);
                break;
            case 2:
                palvelupisteidenArviot.put(2, palvelupisteidenArviot.get(2) + arvio);
                break;
            case 3:
                palvelupisteidenArviot.put(3, palvelupisteidenArviot.get(3) + arvio);
                break;
            case 4:
                palvelupisteidenArviot.put(4, palvelupisteidenArviot.get(4) + arvio);
                break;
        }
    }
}
