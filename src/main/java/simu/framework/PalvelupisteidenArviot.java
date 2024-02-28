package simu.framework;

import simu.model.Asiakas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PalvelupisteidenArviot {

    HashMap<Integer, Integer> palvelupisteidenArviot = new HashMap<>();
    ArrayList<Integer> tapahtumat = new ArrayList<>();
    int index = 0;
    int numberToAdd = 1;
    int[] tapahtumienMaarat = new int[5];

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
                tapahtumienMaarat[0] = tapahtumienMaarat[0] + numberToAdd;
                break;
            case 1:
                palvelupisteidenArviot.put(1, palvelupisteidenArviot.get(1) + arvio);
                tapahtumienMaarat[1] = tapahtumienMaarat[1] + numberToAdd;
                break;
            case 2:
                palvelupisteidenArviot.put(2, palvelupisteidenArviot.get(2) + arvio);
                tapahtumienMaarat[2] = tapahtumienMaarat[2] + numberToAdd;
                break;
            case 3:
                palvelupisteidenArviot.put(3, palvelupisteidenArviot.get(3) + arvio);
                tapahtumienMaarat[3] = tapahtumienMaarat[3] + numberToAdd;
                break;
            case 4:
                palvelupisteidenArviot.put(4, palvelupisteidenArviot.get(4) + arvio);
                tapahtumienMaarat[4] = tapahtumienMaarat[4] + numberToAdd;
                break;
        }
        System.out.println(Arrays.toString(tapahtumienMaarat));
    }
}
