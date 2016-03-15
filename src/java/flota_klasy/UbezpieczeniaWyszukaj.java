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
public class UbezpieczeniaWyszukaj {

    public String pokazSzukaneUbezpieczenia() {
        return "ubezpieczeniaWidok";
    }

    public static List getListaUbezpieczen() {
        Connection c = null;

        List<Ubezpieczenie> listaUbezpieczen = new ArrayList<Ubezpieczenie>();
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "Select ubezpieczenie.id_ubezpieczenie as id, \n"
                    + "samochod.nazwa as samochod_nazwa, \n"
                    + "ubezpieczenie.data_rozpoczecia as rozpoczecie_ubezpieczenia,\n"
                    + "ubezpieczenie.data_zakonczenia as zakonczenie_ubezpieczenia,\n"
                    + "ubezpieczenie.data_zawarcia as pierwsza_data,\n"
                    + "ubezpieczenie.ubezpieczyciel as nazwa_ubezpieczyciela,\n"
                    + "ubezpieczenie.skladka as skladka_ubezpieczenia,\n"
                    + "concat(pracownik.imie ,' ', pracownik.nazwisko) as pracownik_zawierajacy,\n"
                    + "ubezpieczenie.notatka as notatka,\n"
                    + "ubezpieczenie.numer_polisy as numer_polisy,\n"
                    + "ubezpieczenie.nazwa_sprzedawcy as nazwa_sprzedawcy,\n"
                    + "ubezpieczenie.kontakt as kontakt\n"
                    + "\n"
                    + "from ubezpieczenie  \n"
                    + "left join samochod on ubezpieczenie.id_samochodu = samochod.id_samochod\n"
                    + "left join pracownik on ubezpieczenie.id_operator_zawierajacy = pracownik.id_pracownik";
                
               
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Ubezpieczenie ubezpieczenie = new Ubezpieczenie();
                ubezpieczenie.setId_ubezpieczenia(rs.getInt("id"));
                ubezpieczenie.setId_samochodu(rs.getString("samochod_nazwa"));
                ubezpieczenie.setData_rozpoczecia(rs.getDate("rozpoczecie_ubezpieczenia"));
                ubezpieczenie.setData_zakonczenia(rs.getDate("zakonczenie_ubezpieczenia"));
                ubezpieczenie.setData_zawarcia(rs.getDate("pierwsza_data"));
                ubezpieczenie.setUbezpieczyciel(rs.getString("nazwa_ubezpieczyciela"));
                ubezpieczenie.setSkladka(rs.getBigDecimal("skladka_ubezpieczenia"));
                ubezpieczenie.setId_operator_zawierajacy(rs.getString("pracownik_zawierajacy"));
                ubezpieczenie.setNotatka(rs.getString("notatka"));
                ubezpieczenie.setNumer_polisy(rs.getString("numer_polisy"));
                ubezpieczenie.setNazwa_sprzedawcy(rs.getString("nazwa_sprzedawcy"));
                ubezpieczenie.setKontakt(rs.getString("kontakt"));
                
                listaUbezpieczen.add(ubezpieczenie);            

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return listaUbezpieczen;
    }
}
