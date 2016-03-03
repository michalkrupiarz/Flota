/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

/**
 *
 * @author michal.krupiarz
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class KartaParkingowaZapytania {

    public List<KartaParkingowa> getListaKartParkingowych() {
        Connection c = null;
        List<KartaParkingowa> listaKartParkingowych = new ArrayList<KartaParkingowa>();
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
            
            stmt = c.createStatement();
            String sql = "Select * from karta_parkingowa where (karta_parkingowa.id_status_parkingowa = 1 or karta_parkingowa.id_status_parkingowa=6)";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KartaParkingowa lok = new KartaParkingowa();
                lok.setId_karta_parkingowa(rs.getInt("id_karta_parkingowa"));
                lok.setId_status_parkingowa(rs.getInt("id_status_parkingowa"));
                lok.setId_lokalizacja_parkingowa(rs.getInt("id_lokalizacja_parkingowa"));
                lok.setNumer_karta_parkingowa(rs.getString("numer_karta_parkingowa"));
                lok.setId_importu(rs.getInt("id_importu"));
                listaKartParkingowych.add(lok);

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        try {
            c.commit();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaKartParkingowych;
    }
}
