package simu.model;

import simu.framework.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import simu.framework.Tapahtuma;

// TODO:
// Asiakas koodataan simulointimallin edellyttämällä tavalla (data!)
public class Asiakas {
	private double saapumisaika;
	private double poistumisaika;
	private int id;
	private static int i = 1;
	public static long sum = 0;
	private int tapahtumanNumero = (int)(Math.random()*5);
	public static int arviointienSumma;

	double arviointi;

	public double keskiarvo;

	double kokonaisAika;

	public Asiakas(){
		id = i++;

		saapumisaika = Kello.getInstance().getAika();
		Trace.out(Trace.Level.INFO, "Uusi asiakas nro " + id + " saapui klo "+saapumisaika);
	}

	public double getPoistumisaika() {
		return poistumisaika;
	}

	public void setPoistumisaika(double poistumisaika) {
		this.poistumisaika = poistumisaika;
	}

	public double getSaapumisaika() {
		return saapumisaika;
	}

	public void setSaapumisaika(double saapumisaika) {
		this.saapumisaika = saapumisaika;
	}



	public int getId() {
		return id;
	}

	public void raportti(){
		Trace.out(Trace.Level.INFO, "\nAsiakas "+id+ " valmis! ");
		Trace.out(Trace.Level.INFO, "Asiakas "+id+ " saapui: " +saapumisaika);
		Trace.out(Trace.Level.INFO,"Asiakas "+id+ " poistui: " +poistumisaika);
		Trace.out(Trace.Level.INFO,"Asiakas "+id+ " viipyi: " +(poistumisaika-saapumisaika));
		palvelunArvio();
		sum += (poistumisaika-saapumisaika);
		keskiarvo = sum/id;
		System.out.println("Asiakkaiden läpimenoaikojen keskiarvo tähän asti "+ keskiarvo);
	}

	public void tulokset(){
		keskiarvo = sum/id;
		System.out.println("Asiakkaiden läpimenoaikojen keskiarvo: "+ keskiarvo);
	}

	public void palvelunArvio() {
		kokonaisAika = (getPoistumisaika() - getSaapumisaika());

		if (kokonaisAika < 22) {
			arviointi = 5;
			arviointienSumma += arviointi;
		}
		else if (kokonaisAika < 26 && kokonaisAika > 22) {
			arviointi = 4;
			arviointienSumma += arviointi;
		}
		else if (kokonaisAika < 30 && kokonaisAika > 26) {
			arviointi = 3;
			arviointienSumma += arviointi;
		}
		else if (kokonaisAika < 34 && kokonaisAika > 30) {
			arviointi = 2;
			arviointienSumma += arviointi;
		}
		else {
			arviointi = 1;
			arviointienSumma += arviointi;
		}

		switch((int)arviointi) {
			case 1:
				System.out.println("Asiakas "+id+ " asiakas soitti managerille");
				break;
			case 2:
				System.out.println("Asiakas "+id+ " oli pettynyt palveluun");
				break;
			case 3:
				System.out.println("Asiakas "+id+ " oli tyytyväinen palveluun");
				break;
			case 4:
				System.out.println("Asiakas "+id+ " oli erittäin tyytyväinen palveluun");
				break;
			case 5:
				System.out.println("Asiakas "+id+ " oli erittäin tyytyväinen palveluun ja suositteli pankkia ystävilleen");
				break;
		}
	}

	public int palautaArviointi() {
		return (int)arviointi;
	}

	//public void arvoTapahtuma() {
	//	System.out.println("Asiakas "+id+ " arpoi tapahtuman: "+ tapahtumanNumero);
	//}

	public int getTapahtuma() {
		return tapahtumanNumero;
	}

	public int getArviointienKeskiarvo() {
		return arviointienSumma/id;
	}

}