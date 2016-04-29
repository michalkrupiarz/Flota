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
                lok.setId_status_parkingowa(rs.getString("id_status_parkingowa"));
                lok.setId_lokalizacja_parkingowa(rs.getString("id_lokalizacja_parkingowa"));
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
    public static void zmienStatusKartyParkingowej(String idKarty, Long statusKarty){
           
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sqlKartaParkingowaNowa ="UPDATE karta_parkingowa "
                        + "SET id_status_parkingowa="+statusKarty+" "
                        + "WHERE id_karta_parkingowa=(select karta_parkingowa.id_karta_parkingowa from karta_parkingowa where karta_parkingowa.numer_karta_parkingowa ilike ('" + idKarty + "'))";
               
                stmt.executeUpdate(sqlKartaParkingowaNowa);
           } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        try {
            c.commit();
            c.close();
            System.out.println("XXX ZAPISANIE WYEDYTOWANEGO POJAZDU POWIODŁO SIE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public static String zapiszWyedytowanaKarteParkingowa(KartaParkingowa wyedytowanaKarta) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE karta_parkingowa"
                    + "     SET  "
                    + "     id_status_parkingowa=(select id_karta_parkingowa_statusy from karta_parkingowa_statusy where status_karta_parkingowa_statusy ilike('" + wyedytowanaKarta.getId_status_parkingowa() + "')), "
                    + "     id_lokalizacja_parkingowa=(select id_lokalizacja from lokalizacja where nazwa_lokalizacja ilike('" + wyedytowanaKarta.getId_lokalizacja_parkingowa()+ "')), "
                    + "     numer_karta_parkingowa='" + wyedytowanaKarta.getNumer_karta_parkingowa() + "' "
                    
                    + "     WHERE "
                    + "     id_karta_parkingowa=" + wyedytowanaKarta.getId_karta_parkingowa();
            System.out.println("XXX");
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        try {
            c.commit();
            c.close();
            System.out.println("XXX ZAPISANIE WYEDYTOWANEGO POJAZDU POWIODŁO SIE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "zapisano";
    }

    public static void usunKarteParkingowa(Long idKarty) {
        Connection c = null;
        String sql;

        Statement stmt = null;
        System.out.print("weszklo do tworzenia zapytania");
        sql = "DELETE FROM karta_parkingowa where id_karta_parkingowa=" + idKarty;
        
        System.out.println("XXX "+sql);
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:7886/", "postgres", "ponczus21");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }

        try {
            c.commit();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String dodajKarteParkingowa(KartaParkingowa karta) {
        Connection c = null;
        String sql;
        Statement stmt = null;
        sql = "INSERT INTO karta_parkingowa(\n"
                + "            id_karta_parkingowa, id_status_parkingowa, id_lokalizacja_parkingowa, \n"
                + "            numer_karta_parkingowa)"
                + "    VALUES ((select max(id_karta_parkingowa)+1 from karta_parkingowa), "
                + "(select id_karta_parkingowa_statusy from karta_parkingowa_statusy where status_karta_parkingowa_statusy ilike('" + karta.getId_status_parkingowa() + "')), "
                + "(select id_lokalizacja from lokalizacja where nazwa_lokalizacja ilike('" + karta.getId_lokalizacja_parkingowa() + "')), "
                + "'" + karta.getNumer_karta_parkingowa() + "');";
                

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:7886/", "postgres", "ponczus21");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            System.out.println("dodawanie karty parkingowej "+sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }

        try {
            c.commit();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "dodano";
    }
}
