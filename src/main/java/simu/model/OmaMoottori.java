package simu.model;

import Entity.Tulos;
import controller.ChartsIkkunaController;
import controller.GUIkontrolleri;
import dao.DaoController;
import simu.framework.*;
import eduni.distributions.Negexp;
import eduni.distributions.Normal;
import controller.IKontrolleriForM;
import view.SimulaattorinGUI;
import simu.framework.IkaGeneraattori;
import view.ISimulaattorinUI;

import java.util.ArrayList;
import java.util.List;
/**
 * OmaMoottori-luokka, joka perii Moottori-luokan.
 */
public class OmaMoottori extends Moottori{
	private ISimulaattorinUI ui;

	private Saapumisprosessi saapumisprosessi;

	private Palvelupiste[] palvelupisteet;

	private PalvelupisteidenArviot p;

	private Asiakas a;

	private SimulaattorinGUI gui;

	private GUIkontrolleri guiKontrolleri;

	private ArrayList<Double> pankkiaika = new ArrayList<>();

	private ChartsIkkunaController chartController;
	private int arrivedCustomers = 0;
	private int leftCustomers = 0;

	public Palvelupiste[] getPalvelupisteet() {
		return palvelupisteet;
	}

	/**
	 * OmaMoottori-luokan konstruktori.
	 *
	 * @param kontrolleri kontrolleri, joka ohjaa simulaattoria
	 * @param ui käyttöliittymä, joka visualisoi simulaation
	 * @param chartController kontrolleri, joka hallinnoi kaavioita
	 */
	public OmaMoottori(IKontrolleriForM kontrolleri, ISimulaattorinUI ui, ChartsIkkunaController chartController) {
		super(kontrolleri);
		this.ui = ui;
		this.chartController = chartController;
		this.guiKontrolleri = (GUIkontrolleri) ui;
		initialize();
	}

	/**
	 * Alustaa simulaation.
	 */
	public void initialize() {
		SimulaattorinGUI gui = new SimulaattorinGUI();
		p = new PalvelupisteidenArviot();
		palvelupisteet = new Palvelupiste[4];

		palvelupisteet[0]=new Palvelupiste(new Normal(guiKontrolleri.getPalveluaika(), guiKontrolleri.getVariance()), tapahtumalista, TapahtumanTyyppi.DEP1);
		palvelupisteet[1]=new Palvelupiste(new Normal(10,10), tapahtumalista, TapahtumanTyyppi.DEP2);
		palvelupisteet[2]=new Palvelupiste(new Normal(5,3), tapahtumalista, TapahtumanTyyppi.DEP3);
		palvelupisteet[3]=new Palvelupiste(new Normal(5,3), tapahtumalista, TapahtumanTyyppi.DEP4);

		saapumisprosessi = new Saapumisprosessi(new Negexp(15,5), tapahtumalista, TapahtumanTyyppi.ARR1);
	}

	/**
	 * Generoi ensimmäisen saapumisen
	 */
	@Override
	protected void alustukset() {
		saapumisprosessi.generoiSeuraava();
	}
	/**
	 * Suorittaa B-vaiheen tapahtumat.
	 *
	 * @param t tapahtuma, joka suoritetaan
	 */
	@Override
	public void suoritaTapahtuma(Tapahtuma t){  // B-vaiheen tapahtumat
		switch ((TapahtumanTyyppi)t.getTyyppi()){
			case ARR1:
				palvelupisteet[0].lisaaJonoon(new Asiakas());
				arrivedCustomers++;
				saapumisprosessi.generoiSeuraava();
				kontrolleri.visualisoiAsiakas();
				kontrolleri.visualisoiJono();
				if (gui != null) {
					//gui.logEvent("Uusi asiakas " + a + " on pankissa");
				}
				break;
			case DEP1: a = (Asiakas)palvelupisteet[0].otaJonosta();
				   	   palvelupisteet[1].lisaaJonoon(a);
						kontrolleri.visualisoiJonostaPoisto();
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
				leftCustomers++;
				a.setPoistumisaika(Kello.getInstance().getAika());
				a.raportti();
				pankkiaika.add(a.getPoistumisaika() - a.getSaapumisaika());
				p.lisaaAsiakkaanArvio(a, chartController);
		}
	}
	/**
	 * Yrittää suorittaa C-vaiheen tapahtumat.
	 */
	@Override
	protected void yritaCTapahtumat(){
		for (Palvelupiste p: palvelupisteet){
			if (!p.onVarattu() && p.onJonossa()){
				kontrolleri.drawPalveluPiste(0, palvelupisteet[0].onVarattu());
				kontrolleri.drawPalveluPiste(1, palvelupisteet[1].onVarattu());
				kontrolleri.drawPalveluPiste(2, palvelupisteet[2].onVarattu());
				kontrolleri.drawPalveluPiste(3, palvelupisteet[3].onVarattu());
				p.aloitaPalvelu();
			}
		}
	}
	public int getArrivedCustomers() {
		return arrivedCustomers;
	}

	public int getLeftCustomers() {
		return leftCustomers;
	}


	/**
	 * Tulostaa simulaation tulokset.
	 */
	@Override
	protected void tulokset() {
		double kokonaisaika = Kello.getInstance().getAika();
		int asiakkaidenMaara = arrivedCustomers;
		double asiakkaidenKeskimaarainenIka = a.ianKeskiarvo();
		double totalVarattuTime = 0.0;
		double suoritusteho = asiakkaidenMaara/kokonaisaika;
		int saapuneetAsiakkaat = arrivedCustomers;
		int palvellutAsiakkaat = leftCustomers;
		for (Palvelupiste p : palvelupisteet) {
			totalVarattuTime += p.getTotalVarattuTime();
		}
		Tulos tulos = new Tulos(kokonaisaika,asiakkaidenMaara,asiakkaidenKeskimaarainenIka,totalVarattuTime,suoritusteho, saapuneetAsiakkaat, palvellutAsiakkaat);
		DaoController daoController = new DaoController();
		daoController.persist(tulos);

		chartController.addChartData(pankkiaika);

		System.out.println(a.getArviointienKeskiarvo());
		guiKontrolleri.logEvent("Simuloinnin kokonaisaika: "+ MuunnaAika.toMinutes(tulos.getKokonaisaika())+" Minuuttia " + MuunnaAika.toSeconds(tulos.getKokonaisaika())+" sekuntia "+ "("+tulos.getKokonaisaika()+" ms)");
		guiKontrolleri.logEvent("Asiakkaiden määrä: "+ tulos.getAsiakkaiden_maara());
		guiKontrolleri.logEvent("Asiakkaiden keskimääräinen ikä: " + tulos.getAsiakkaiden_keskimaarainen_ika());
		guiKontrolleri.logEvent("Asiakkaiden antamat arviot:\n" + p.palautaKeskiarvoPalveluista());
		guiKontrolleri.logEvent("Palvelupisteiden kokonaisaika aktiivisena: "+ MuunnaAika.toMinutes(tulos.getPalvelupisteidenKokonaisPalveluAika())+" Minuuttia ja "+MuunnaAika.toSeconds(tulos.getPalvelupisteidenKokonaisPalveluAika())+" sekuntia");
		guiKontrolleri.logEvent("Suoritusteho: "+ suoritusteho);
		guiKontrolleri.logEvent("Saapuneet asiakkaat: "+ saapuneetAsiakkaat);
		guiKontrolleri.logEvent("Palvelluksi tulleet asiakkaat: "+ palvellutAsiakkaat);
		kontrolleri.naytaLoppuaika(Kello.getInstance().getAika());
	}
}
