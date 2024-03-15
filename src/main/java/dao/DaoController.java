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
                int asiakkaidenMaara = rs.getInt(2);
                double keskimaarainen_ika = rs.getDouble(3);
                Tulos tulos = new Tulos(kokonaisaika, asiakkaidenMaara, keskimaarainen_ika);
                tulokset.add(tulos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tulokset;

    }
    public Tulos getTulosById(int id) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT kokonaisaika, asiakkaiden_maara, asiakkaiden_keskimaarainen_ika FROM tulokset WHERE id=?";

        double kokonaisaika = 0;
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
                asiakkaiden_maara = rs.getInt(2);
                asiakkaiden_keskimaarainen_ika = rs.getDouble(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (count==1) {
            return new Tulos(kokonaisaika, asiakkaiden_maara, asiakkaiden_keskimaarainen_ika);
        }
        else {
            return null;
        }
    }
    public void persist(Tulos tulos) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "INSERT INTO tulokset (kokonaisaika,asiakkaiden_maara, asiakkaiden_keskimaarainen_ika) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, tulos.getKokonaisaika());
            ps.setInt(2, tulos.getAsiakkaiden_maara());
            ps.setDouble(3, tulos.getAsiakkaiden_keskimaarainen_ika());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}