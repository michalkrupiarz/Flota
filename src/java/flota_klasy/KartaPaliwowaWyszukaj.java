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
public class KartaPaliwowaWyszukaj {

    public static List getListWyszukanychPaliwowych(KartaPaliwowa paliwowa) {
        Connection c = null;

        List<KartaPaliwowa> listaPaliwowych = new ArrayList<KartaPaliwowa>();
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "SELECT id_karta_paliwowa as id, karta_paliwowa_statusy.status_karta_paliwowa_statusy as status, \n"
                    + "  lokalizacja.nazwa_lokalizacja as lok, \n"
                    + "  numer_karty as numer, pin_karty as pin \n"
                    + "  FROM karta_paliwowa \n"
                    + "left join lokalizacja on karta_paliwowa.id_lokalizacja_paliwowa = lokalizacja.id_lokalizacja \n"
                    + "left join karta_paliwowa_statusy on karta_paliwowa.id_status_paliwowa = karta_paliwowa_statusy.id_karta_paliwowa_statusy "
                    + "where id_karta_paliwowa is not null";

            if (!paliwowa.getId_status_paliwowa().isEmpty()) {
                sql = sql + " karta_paliwowa_statusy.status_karta_paliwowa_statusy ilike ('" + paliwowa.getId_status_paliwowa() + "'))";
            }
            if (!paliwowa.getId_lokalizacja_paliwowa().isEmpty()) {
                sql = sql + " and  lokalizacja.nazwa_lokalizacja ilike ('" + paliwowa.getId_lokalizacja_paliwowa() + "'))";
            }
            if (!paliwowa.getNumer_Karty().isEmpty()) {
                sql = sql + " and karta_paliwowa.numer_karty ilike('" + paliwowa.getNumer_Karty() + "')";
            }
            if (!paliwowa.getPin_karty().isEmpty()) {
                sql = sql + " and karta_paliwowa.pin_karty ilike('" + paliwowa.getPin_karty() + "')";
            }

            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KartaPaliwowa paliwowaZnaleziona = new KartaPaliwowa();
                paliwowaZnaleziona.setId_karta_paliwowa(rs.getInt("id"));
                paliwowaZnaleziona.setId_status_paliwowa(rs.getString("status"));
                paliwowaZnaleziona.setId_lokalizacja_paliwowa(rs.getString("lok"));
                paliwowaZnaleziona.setPin_karty(rs.getString("pin"));
                paliwowaZnaleziona.setNumer_Karty(rs.getString("numer"));

                listaPaliwowych.add(paliwowaZnaleziona);


            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return listaPaliwowych;
    }

    public static List getListaPaliwowych() {
        Connection c = null;

        List<KartaPaliwowa> listaPaliwowych = new ArrayList<KartaPaliwowa>();
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "SELECT id_karta_paliwowa as id, karta_paliwowa_statusy.status_karta_paliwowa_statusy as status, \n"
                    + "  lokalizacja.nazwa_lokalizacja as lok, \n"
                    + "  numer_karty as numer, pin_karty as pin \n"
                    + "  FROM karta_paliwowa \n"
                    + "left join lokalizacja on karta_paliwowa.id_lokalizacja_paliwowa = lokalizacja.id_lokalizacja \n"
                    + "left join karta_paliwowa_statusy on karta_paliwowa.id_status_paliwowa = karta_paliwowa_statusy.id_karta_paliwowa_statusy;";

            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KartaPaliwowa paliwowa = new KartaPaliwowa();
                paliwowa.setId_karta_paliwowa(rs.getInt("id"));
                paliwowa.setId_status_paliwowa(rs.getString("status"));
                paliwowa.setId_lokalizacja_paliwowa(rs.getString("lok"));
                paliwowa.setPin_karty(rs.getString("pin"));
                paliwowa.setNumer_Karty(rs.getString("numer"));

                listaPaliwowych.add(paliwowa);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return listaPaliwowych;
    }
}
