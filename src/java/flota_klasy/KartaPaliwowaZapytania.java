/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

/**
 *
 * @author M
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
public class KartaPaliwowaZapytania {

    public List<KartaPaliwowa> getListaKartPaliwowych() {
        Connection c = null;
        List<KartaPaliwowa> listaKartPaliwowych = new ArrayList<KartaPaliwowa>();
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "Select * from karta_paliwowa where (karta_paliwowa.id_status_paliwowa = 1 or karta_paliwowa.id_status_paliwowa = 6)";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KartaPaliwowa lok = new KartaPaliwowa();
                lok.setId_karta_paliwowa(rs.getInt("id_karta_paliwowa"));
                lok.setId_status_paliwowa(rs.getString("id_status_paliwowa"));
                lok.setId_lokalizacja_paliwowa(rs.getString("id_lokalizacja_paliwowa"));
                lok.setNumer_Karty(rs.getString("numer_karty"));
                lok.setPin_karty(rs.getString("pin_karty"));
                lok.setId_importu(rs.getInt("id_importu"));
                listaKartPaliwowych.add(lok);

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
        return listaKartPaliwowych;
    }

    public static void zmienStatusKartyPaliwowej(String idKarty, Long statusKarty) {

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sqlKartaPaliwowaNowa = "UPDATE karta_paliwowa "
                    + "SET id_status_paliwowa=" + statusKarty + " "
                    + "WHERE id_karta_paliwowa=(select karta_paliwowa.id_karta_paliwowa from karta_paliwowa where karta_paliwowa.numer_karty ilike ('" + idKarty + "'))";
            stmt.executeUpdate(sqlKartaPaliwowaNowa);
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

    public static String zapiszWyedytowanaKartePaliwowa(KartaPaliwowa wyedytowanaKarta) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE karta_paliwowa"
                    + "     SET  "
                    + "     id_status_paliwowa=(select id_karta_paliwowa_statusy from karta_paliwowa_statusy where status_karta_paliwowa_statusy ilike('" + wyedytowanaKarta.getId_status_paliwowa() + "')), "
                    + "     id_lokalizacja_paliwowa=(select id_lokalizacja from lokalizacja where nazwa_lokalizacja ilike('" + wyedytowanaKarta.getId_lokalizacja_paliwowa() + "')), "
                    + "     numer_karty='" + wyedytowanaKarta.getNumer_Karty() + "', "
                    + "     pin_karty='" + wyedytowanaKarta.getPin_karty() + "' "
                    + "     WHERE "
                    + "     id_karta_paliwowa=" + wyedytowanaKarta.getId_karta_paliwowa();
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

    public static void usunKartePaliwowa(Long idKarty) {
        Connection c = null;
        String sql;

        Statement stmt = null;
        System.out.print("weszklo do tworzenia zapytania");
        sql = "DELETE FROM karta_paliwowa where id_karta_paliwowa=" + idKarty;

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

    public static String dodajKartePaliwowa(KartaPaliwowa kartaPaliwowa) {
        Connection c = null;
        String sql;
        Statement stmt = null;
        sql = "INSERT INTO karta_paliwowa(\n"
                + "            id_karta_paliwowa, id_status_paliwowa, id_lokalizacja_paliwowa, \n"
                + "            numer_karty, pin_karty)"
                + "    VALUES ((select max(id_karta_paliwowa)+1 from karta_paliwowa), "
                + "(select id_karta_paliwowa_statusy from karta_paliwowa_statusy where status_karta_paliwowa_statusy ilike('" + kartaPaliwowa.getId_status_paliwowa() + "')), "
                + "(select id_lokalizacja from lokalizacja where nazwa_lokalizacja ilike('" + kartaPaliwowa.getId_lokalizacja_paliwowa() + "')), "
                + "'" + kartaPaliwowa.getNumer_Karty() + "', "
                + "'" + kartaPaliwowa.getPin_karty() + "');";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:7886/", "postgres", "ponczus21");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            System.out.println("dodawanie karty paliwowej "+sql);
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
