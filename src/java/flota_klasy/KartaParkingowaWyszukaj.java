/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Michal
 */
@ManagedBean
@SessionScoped
public class KartaParkingowaWyszukaj {
    public static List getListWyszukanychParkingowych(KartaParkingowa parkingowa) {
        Connection c = null;

        List<KartaParkingowa> listaParkingowych = new ArrayList<KartaParkingowa>();
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "SELECT id_karta_parkingowa as id, karta_parkingowa_statusy.status_karta_parkingowa_statusy as status, \n"
                    + "  lokalizacja.nazwa_lokalizacja as lok, \n"
                    + "  numer_karta_parkingowa as numer\n"
                    + "  FROM karta_parkingowa \n"
                    + "left join lokalizacja on karta_parkingowa.id_lokalizacja_parkingowa = lokalizacja.id_lokalizacja \n"
                    + "left join karta_parkingowa_statusy on karta_parkingowa.id_status_parkingowa = karta_parkingowa_statusy.id_karta_parkingowa_statusy "
                    + "where id_karta_parkingowa is not null";

            if (!parkingowa.getId_status_parkingowa().isEmpty()) {
                sql = sql + " and karta_parkingowa_statusy.status_karta_parkingowa_statusy ilike ('" + parkingowa.getId_status_parkingowa() + "'))";
            }
            if (!parkingowa.getId_lokalizacja_parkingowa().isEmpty()) {
                sql = sql + " and lokalizacja.nazwa_lokalizacja ilike ('" + parkingowa.getId_lokalizacja_parkingowa() + "'))";
            }
            if (!parkingowa.getNumer_karta_parkingowa().isEmpty()) {
                sql = sql + " and karta_parkingowa.numer_karta_parkingowa ilike('" + parkingowa.getNumer_karta_parkingowa() + "')";
            }
            

            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KartaParkingowa parkingowaZnaleziona = new KartaParkingowa();
                parkingowaZnaleziona.setId_karta_parkingowa(rs.getInt("id"));
                parkingowaZnaleziona.setId_status_parkingowa(rs.getString("status"));
                parkingowaZnaleziona.setId_lokalizacja_parkingowa(rs.getString("lok"));
                
                parkingowaZnaleziona.setNumer_karta_parkingowa(rs.getString("numer"));

                listaParkingowych.add(parkingowaZnaleziona);


            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return listaParkingowych;
    }

    public static List getListaParkingowych() {
        Connection c = null;

        List<KartaParkingowa> listaParkingowych = new ArrayList<KartaParkingowa>();
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "SELECT id_karta_parkingowa as id, karta_parkingowa_statusy.status_karta_parkingowa_statusy as status, \n"
                    + "  lokalizacja.nazwa_lokalizacja as lok, \n"
                    + "  numer_karta_parkingowa as numer \n"
                    + "  FROM karta_parkingowa \n"
                    + "left join lokalizacja on karta_parkingowa.id_lokalizacja_parkingowa = lokalizacja.id_lokalizacja \n"
                    + "left join karta_parkingowa_statusy on karta_parkingowa.id_status_parkingowa = karta_parkingowa_statusy.id_karta_parkingowa_statusy;";

            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KartaParkingowa parkingowa = new KartaParkingowa();
                parkingowa.setId_karta_parkingowa(rs.getInt("id"));
                parkingowa.setId_status_parkingowa(rs.getString("status"));
                parkingowa.setId_lokalizacja_parkingowa(rs.getString("lok"));
               
                parkingowa.setNumer_karta_parkingowa(rs.getString("numer"));

                listaParkingowych.add(parkingowa);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return listaParkingowych;
    }
}
