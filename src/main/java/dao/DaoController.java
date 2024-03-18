package dao;

import java.sql.*;
import datasource.MariaDbConnection;
import java.util.*;
import Entity.Tulos;
/**
 * Luokka, joka hallinnoi tietokannan toimintoja.
 */
public class DaoController {
    /**
     * Hakee kaikki tulokset tietokannasta.
     *
     * @return Lista tuloksista.
     */
    public List<Tulos> getAllTulokset() {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT * FROM tulokset";
        List<Tulos> tulokset = new ArrayList<Tulos>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                double kokonaisaika = rs.getDouble(1);
                int asiakkaidenMaara = rs.getInt(2);
                double keskimaarainen_ika = rs.getDouble(3);
                double palveluPisteidenKokonaisPalveluAika = rs.getDouble(4);
                double suoritusteho = rs.getDouble(5);
                int saapuneetAsiakkaat = rs.getInt(6);
                int palvellutAsiakkaat = rs.getInt(7);
                double palveluajanKeskiarvo = rs.getDouble(8);
                Tulos tulos = new Tulos(kokonaisaika, asiakkaidenMaara, keskimaarainen_ika,palveluPisteidenKokonaisPalveluAika,suoritusteho,saapuneetAsiakkaat,palvellutAsiakkaat, palveluajanKeskiarvo);
                tulokset.add(tulos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tulokset;

    }
    /**
     * Hakee tuloksen tietokannasta annetun id:n perusteella.
     *
     * @param id Tuloksen id.
     * @return Tulos tai null, jos tulosta ei löydy.
     */
    public Tulos getTulosById(int id) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT kokonaisaika, asiakkaiden_maara, asiakkaiden_keskimaarainen_ika, palvelupisteiden_palveluaika, suoritusteho, saapuneet_asiakkaat, palvellut_asiakkaat, palveluajan_keskiarvo FROM tulokset WHERE id=?";

        double kokonaisaika = 0;
        int asiakkaiden_maara = 0;
        double asiakkaiden_keskimaarainen_ika = 0;
        double palveluPisteidenKokonaisPalveluAika = 0;
        double suoritusteho = 0;
        int saapuneetAsiakkaat = 0;
        int palvellutAsiakkaat = 0;
        double palveluajan_keskiarvo = 0;
        int count = 0;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;
                kokonaisaika = rs.getDouble(1);
                asiakkaiden_maara = rs.getInt(2);
                asiakkaiden_keskimaarainen_ika = rs.getDouble(3);
                palveluPisteidenKokonaisPalveluAika = rs.getDouble(4);
                saapuneetAsiakkaat = rs.getInt(6);
                palvellutAsiakkaat = rs.getInt(7);
                palveluajan_keskiarvo = rs.getDouble(8);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (count==1) {
            return new Tulos(kokonaisaika, asiakkaiden_maara, asiakkaiden_keskimaarainen_ika,palveluPisteidenKokonaisPalveluAika, suoritusteho, saapuneetAsiakkaat, palvellutAsiakkaat, palveluajan_keskiarvo);
        }
        else {
            return null;
        }
    }
    /**
     * Tallentaa tuloksen tietokantaan.
     *
     * @param tulos Tallennettava tulos.
     */
    public void persist(Tulos tulos) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "INSERT INTO tulokset (kokonaisaika,asiakkaiden_maara, asiakkaiden_keskimaarainen_ika, palvelupisteiden_palveluaika, suoritusteho, saapuneet_asiakkaat, palvellut_asiakkaat, palveluajan_keskiarvo) VALUES (?, ?, ?, ?, ?, ?, ?,? )";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, tulos.getKokonaisaika());
            ps.setInt(2, tulos.getAsiakkaiden_maara());
            ps.setDouble(3, tulos.getAsiakkaiden_keskimaarainen_ika());
            ps.setDouble(4, tulos.getPalvelupisteidenKokonaisPalveluAika());
            ps.setDouble(5,tulos.getSuoritusteho());
            ps.setInt(6, tulos.getSaapuneetAsiakkaat());
            ps.setInt(7, tulos.getPalvellutAsiakkaat());
            ps.setDouble(8, tulos.getPalveluajanKeskiarvo());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}