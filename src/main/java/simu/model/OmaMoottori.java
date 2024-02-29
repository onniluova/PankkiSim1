package simu.model;

import simu.framework.*;
import eduni.distributions.Negexp;
import eduni.distributions.Normal;
import controller.IKontrolleriForM;
import view.SimulaattorinGUI;
import simu.framework.IkaGeneraattori;

import java.util.ArrayList;

public class OmaMoottori extends Moottori{
	
	private Saapumisprosessi saapumisprosessi;

	private Palvelupiste[] palvelupisteet;

	private PalvelupisteidenArviot p;

	private Asiakas a;

	private SimulaattorinGUI gui;


	public OmaMoottori(IKontrolleriForM kontrolleri, SimulaattorinGUI gui){

		super(kontrolleri);
		this.gui = gui;
		initialize();

	}

	private void initialize() {
		SimulaattorinGUI gui = new SimulaattorinGUI();
		p = new PalvelupisteidenArviot();
		palvelupisteet = new Palvelupiste[4];

		palvelupisteet[0]=new Palvelupiste(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.DEP1);
		palvelupisteet[1]=new Palvelupiste(new Normal(10,10), tapahtumalista, TapahtumanTyyppi.DEP2);
		palvelupisteet[2]=new Palvelupiste(new Normal(5,3), tapahtumalista, TapahtumanTyyppi.DEP3);
		palvelupisteet[3]=new Palvelupiste(new Normal(5,3), tapahtumalista, TapahtumanTyyppi.DEP4);

		saapumisprosessi = new Saapumisprosessi(new Negexp(15,5), tapahtumalista, TapahtumanTyyppi.ARR1);
	}

	@Override
	protected void alustukset() {
		saapumisprosessi.generoiSeuraava(); // Ensimmäinen saapuminen järjestelmään
	}

	@Override
	protected void suoritaTapahtuma(Tapahtuma t){  // B-vaiheen tapahtumat
		switch ((TapahtumanTyyppi)t.getTyyppi()){
			case ARR1: palvelupisteet[0].lisaaJonoon(new Asiakas());
				       saapumisprosessi.generoiSeuraava();
					   kontrolleri.visualisoiAsiakas();
					if (gui != null) {
						//gui.logEvent("Uusi asiakas " + a + " on pankissa");
					}
				break;
			case DEP1: a = (Asiakas)palvelupisteet[0].otaJonosta();
				   	   palvelupisteet[1].lisaaJonoon(a);
						  a.getTapahtuma();
						//gui.logEvent("Asiakas " + a + " valitsi tapahtuman " + a.getTapahtuma());
				break;
			case DEP2: a = (Asiakas)palvelupisteet[1].otaJonosta();
				   	   palvelupisteet[2].lisaaJonoon(a);
				break;
			case DEP3:
				       a = (Asiakas)palvelupisteet[2].otaJonosta();
						palvelupisteet[3].lisaaJonoon(a);

			case DEP4:
				a = (Asiakas)palvelupisteet[3].otaJonosta();
				a.setPoistumisaika(Kello.getInstance().getAika());
				a.raportti();
				p.lisaaAsiakkaanArvio(a);
		}
	}

	@Override
	protected void yritaCTapahtumat(){
		for (Palvelupiste p: palvelupisteet){
			if (!p.onVarattu() && p.onJonossa()){
				p.aloitaPalvelu();
			}
		}
	}

	//TODO: Kunnon tulokset eventLogilla.
	@Override
	protected void tulokset() {
		System.out.println("Simulointi päättyi kello " + Kello.getInstance().getAika());
		a.tulokset();
		System.out.println(a.getArviointienKeskiarvo());
		gui.logEvent(p.palautaArviotStringina());


		// UUTTA graafista
		kontrolleri.naytaLoppuaika(Kello.getInstance().getAika());
	}
}
