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

    public static List getListaWyszukanychUbezpieczen(Ubezpieczenie szukaneUbezpieczenie) {
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
                    + "left join pracownik on ubezpieczenie.id_operator_zawierajacy = pracownik.id_pracownik\n"
                    + " where ubezpieczenie.id_ubezpieczenie is not null";

            if (!szukaneUbezpieczenie.getId_samochodu().isEmpty()) {
                sql = sql + " and samochod.nazwa ilike('" + szukaneUbezpieczenie.getId_samochodu() + "')";
            }
            if (!szukaneUbezpieczenie.getData_rozpoczecia().isEmpty()) {
                sql = sql + " and ubezpieczenie.data_rozpoczecia ilike('" + szukaneUbezpieczenie.getData_rozpoczecia() + "')";
            }
            if (!szukaneUbezpieczenie.getData_zakonczenia().isEmpty()) {
                sql = sql + " and ubezpieczenie.data_zakonczenia ilike('" + szukaneUbezpieczenie.getData_zakonczenia() + "')";
            }
            if (!szukaneUbezpieczenie.getData_zawarcia().isEmpty()) {
                sql = sql + " and ubezpieczenie.data_zawarcia ilike('" + szukaneUbezpieczenie.getData_zawarcia() + "')";
            }
            if (!szukaneUbezpieczenie.getSkladka().matches("[0-9]+")){
                sql = sql + " and ubezpieczenie.skladka =('"+szukaneUbezpieczenie.getSkladka()+"')";
            }
            if (!szukaneUbezpieczenie.getUbezpieczyciel().isEmpty()){
                sql = sql +"and ubezpieczenie.ubezpieczyciel ilike=('"+szukaneUbezpieczenie.getUbezpieczyciel()+"')";
            }
            if(!szukaneUbezpieczenie.getId_operator_zawierajacy().isEmpty()){
                sql = sql+" and concat(pracownik.imie ,' ', pracownik.nazwisko) ilike ('" + szukaneUbezpieczenie.getId_operator_zawierajacy() + "')";
            }
            if(!szukaneUbezpieczenie.getNotatka().isEmpty()){
                sql = sql+" and ubezpieczenie.notatka ilike('"+szukaneUbezpieczenie.getNotatka()+"')";
            }
            if(!szukaneUbezpieczenie.getNumer_polisy().isEmpty()){
                sql=sql+" and ubezpieczenie.numer_polisy('"+szukaneUbezpieczenie.getNumer_polisy()+"')";
            }
            if(!szukaneUbezpieczenie.getNazwa_sprzedawcy().isEmpty()){
                sql = sql+" and ubezpieczenie.nazwa_sprzecawcy ilike('"+szukaneUbezpieczenie.getNazwa_sprzedawcy()+"')";
            }
            if(!szukaneUbezpieczenie.getKontakt().isEmpty()){
                sql=sql+" and ubezpieczenie.kontakt('"+szukaneUbezpieczenie.getKontakt()+"')";
            }
                    System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Ubezpieczenie ubezpieczenie = new Ubezpieczenie();
                ubezpieczenie.setId_ubezpieczenia(rs.getInt("id"));
                ubezpieczenie.setId_samochodu(rs.getString("samochod_nazwa"));
                ubezpieczenie.setData_rozpoczecia(rs.getString("rozpoczecie_ubezpieczenia"));
                ubezpieczenie.setData_zakonczenia(rs.getString("zakonczenie_ubezpieczenia"));
                ubezpieczenie.setData_zawarcia(rs.getString("pierwsza_data"));
                ubezpieczenie.setUbezpieczyciel(rs.getString("nazwa_ubezpieczyciela"));
                ubezpieczenie.setSkladka(rs.getString("skladka_ubezpieczenia"));
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
                ubezpieczenie.setData_rozpoczecia(rs.getString("rozpoczecie_ubezpieczenia"));
                ubezpieczenie.setData_zakonczenia(rs.getString("zakonczenie_ubezpieczenia"));
                ubezpieczenie.setData_zawarcia(rs.getString("pierwsza_data"));
                ubezpieczenie.setUbezpieczyciel(rs.getString("nazwa_ubezpieczyciela"));
                ubezpieczenie.setSkladka(rs.getString("skladka_ubezpieczenia"));
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
