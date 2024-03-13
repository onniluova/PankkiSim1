package dao;

import java.sql.*;
import datasource.MariaDbConnection;
import java.util.*;
import Entity.Tulos;

public class DaoController {
    public List<Tulos> getAllTulokset() {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT * FROM tulokset";
        List<Tulos> tulokset = new ArrayList<Tulos>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                double kokonaisaika = rs.getDouble(1);
                double palvelunKeskiarvo = rs.getDouble(2);
                int asiakkaidenMaara = rs.getInt(3);
                double keskimaarainen_ika = rs.getDouble(4);
                Tulos tulos = new Tulos(kokonaisaika, palvelunKeskiarvo, asiakkaidenMaara, keskimaarainen_ika);
                tulokset.add(tulos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tulokset;

    }
    public Tulos getTulosById(int id) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT kokonaisaika, palvelun_keskiarvo, asiakkaiden_maara, asiakkaiden_keskimaarainen_ika FROM tulokset WHERE id=?";

        double kokonaisaika = 0;
        double palvelun_keskiarvo = 0;
        int asiakkaiden_maara = 0;
        double asiakkaiden_keskimaarainen_ika = 0;
        int count = 0;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;
                kokonaisaika = rs.getDouble(1);
                palvelun_keskiarvo = rs.getDouble(2);
                asiakkaiden_maara = rs.getInt(3);
                asiakkaiden_keskimaarainen_ika = rs.getDouble(4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (count==1) {
            return new Tulos(kokonaisaika, palvelun_keskiarvo, asiakkaiden_maara, asiakkaiden_keskimaarainen_ika);
        }
        else {
            return null;
        }
    }
    public void persist(Tulos tulos) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "INSERT INTO tulokset (kokonaisaika, palvelun_keskiarvo, asiakkaiden_maara, asiakkaiden_keskimaarainen_ika) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, tulos.getKokonaisaika());
            ps.setDouble(2, tulos.getPalvelun_keskiarvo());
            ps.setInt(3, tulos.getAsiakkaiden_maara());
            ps.setDouble(4, tulos.getAsiakkaiden_keskimaarainen_ika());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}