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
public class PracownikWyszukaj {

    public static List getListWyszukanychPracownikow(Pracownik pracownikDoWyszukania) {
        Connection c = null;

        List<Pracownik> listaPracownikow = new ArrayList<Pracownik>();
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "Select  id_pracownik as id, login as login, haslo as haslo, imie as imie, nazwisko as nazwisko,\n"
                    + "	stanowisko.nazwa_stanowisko as stanowisko, dzial.nazwa_dzial as dzial,\n"
                    + "	lokalizacja.nazwa_lokalizacja as lokalizacja, mail as maila,\n"
                    + "	tel_stac as tel_stac, tel_kom as tel_kom, pracownik.id_import as import,\n"
                    + "	uprawnienia.nazwa as uprawnienia\n"
                    + "\n"
                    + "	from pracownik\n"
                    + "	\n"
                    + "	join stanowisko on stanowisko.id_stanowisko = pracownik.id_stanowisko\n"
                    + "	join dzial on dzial.id_dzial = pracownik.id_dzial\n"
                    + "	join lokalizacja on lokalizacja.id_lokalizacja = pracownik.id_lokalizacja\n"
                    + "	join uprawnienia on uprawnienia.id_uprawnienia = pracownik.id_uprawnienia\n"
                    + "	where id_pracownik is not null ";

            if (!pracownikDoWyszukania.getNazwisko().isEmpty()){
                sql = sql + "and pracownik.nazwisko ilike ('"+pracownikDoWyszukania.getNazwisko()+"')";
            }
            if (!pracownikDoWyszukania.getId_dzial().isEmpty()){
                sql = sql + " and  dzial.nazwa_dzial ilike ('"+pracownikDoWyszukania.getId_dzial()+"')";
            }
            if (!pracownikDoWyszukania.getId_lokalizacja().isEmpty()){
                sql = sql + " and  lokalizacja.nazwa_lokalizacja ilike('"+pracownikDoWyszukania.getId_lokalizacja()+"')";
            }
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Pracownik pracownik = new Pracownik();
                pracownik.setId_pracownik(rs.getInt("id"));
                pracownik.setLogin(rs.getString("login"));
                pracownik.setHaslo(rs.getString("haslo"));
                pracownik.setImie(rs.getString("imie"));
                pracownik.setNazwisko(rs.getString("nazwisko"));
                pracownik.setId_stanowisko(rs.getString("stanowisko"));
                pracownik.setId_dzial(rs.getString("dzial"));
                pracownik.setId_lokalizacja(rs.getString("lokalizacja"));
                pracownik.setTel_stac(rs.getString("tel_stac"));
                pracownik.setTel_kom(rs.getString("tel_kom"));
                pracownik.setId_import(rs.getInt("import"));
                pracownik.setId_uprawnienia(rs.getString("uprawnienia")); 
                listaPracownikow.add(pracownik);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return listaPracownikow;
    }

    public static List getListaPracownikow() {
        Connection c = null;

        List<Pracownik> listaPracownikow = new ArrayList<Pracownik>();
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "Select  id_pracownik as id, login as login, haslo as haslo, imie as imie, nazwisko as nazwisko,\n"
                    + "	stanowisko.nazwa_stanowisko as stanowisko, dzial.nazwa_dzial as dzial,\n"
                    + "	lokalizacja.nazwa_lokalizacja as lokalizacja, mail as maila,\n"
                    + "	tel_stac as tel_stac, tel_kom as tel_kom, pracownik.id_import as import,\n"
                    + "	uprawnienia.nazwa as uprawnienia\n"
                    + "\n"
                    + "	from pracownik\n"
                    + "	\n"
                    + "	join stanowisko on stanowisko.id_stanowisko = pracownik.id_stanowisko\n"
                    + "	join dzial on dzial.id_dzial = pracownik.id_dzial\n"
                    + "	join lokalizacja on lokalizacja.id_lokalizacja = pracownik.id_lokalizacja\n"
                    + "	join uprawnienia on uprawnienia.id_uprawnienia = pracownik.id_uprawnienia;\n"
                    + "	";

            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                
                Pracownik pracownik = new Pracownik();
                pracownik.setId_pracownik(rs.getInt("id"));
                pracownik.setLogin(rs.getString("login"));
                pracownik.setHaslo(rs.getString("haslo"));
                pracownik.setImie(rs.getString("imie"));
                pracownik.setNazwisko(rs.getString("nazwisko"));
                pracownik.setId_stanowisko(rs.getString("stanowisko"));
                pracownik.setId_dzial(rs.getString("dzial"));
                pracownik.setId_lokalizacja(rs.getString("lokalizacja"));
                pracownik.setTel_stac(rs.getString("tel_stac"));
                pracownik.setTel_kom(rs.getString("tel_kom"));
                pracownik.setId_import(rs.getInt("import"));
                pracownik.setId_uprawnienia(rs.getString("uprawnienia")); 
                listaPracownikow.add(pracownik);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return listaPracownikow;
    }
}
