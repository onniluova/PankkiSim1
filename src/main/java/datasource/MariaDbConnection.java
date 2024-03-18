package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Luokka, joka hallinnoi MariaDB-tietokantayhteyden luomista ja lopettamista.
 */
public class MariaDbConnection {
    private static Connection conn = null;

    /**
     * Luo yhteyden MariaDB-tietokantaan, jos yhteyttä ei ole jo olemassa.
     *
     * @return Yhteys MariaDB-tietokantaan.
     */
    public static Connection getConnection(){
        if (conn == null){
            try {
                conn = DriverManager.getConnection( "jdbc:mariadb://localhost:3306/simu_database?user=root&password=Nasslingmaga98");
            }catch (SQLException e){
                System.out.println("Connection failed");
                e.printStackTrace();
            }
            return conn;
        }
        else{
            return conn;
        }
    }

    /**
     * Lopettaa yhteyden MariaDB-tietokantaan.
     */
    public static void terminate() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}