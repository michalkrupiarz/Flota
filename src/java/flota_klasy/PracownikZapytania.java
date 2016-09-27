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
public class PracownikZapytania {

    public List<Pracownik> getListaPracownik() {
        Connection c = null;
        List<Pracownik> listPracownikow = new ArrayList<Pracownik>();
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "Select * from pracownik";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Pracownik lok = new Pracownik();
                lok.setId_pracownik(rs.getInt("id_pracownik"));
                lok.setLogin(rs.getString("login"));
                lok.setHaslo(rs.getString("haslo"));
                lok.setImie(rs.getString("imie"));
                lok.setNazwisko(rs.getString("nazwisko"));
                lok.setId_st(rs.getString("id_stanowisko"));
                lok.setId_dzial(rs.getString("id_dzial"));
                lok.setId_lokalizacja(rs.getString("id_lokalizacja"));
                lok.setMail(rs.getString("mail"));
                lok.setTel_stac(rs.getString("tel_stac"));
                lok.setTel_kom(rs.getString("tel_kom"));
                lok.setId_import(rs.getInt("id_import"));
                lok.setId_uprawnienia(rs.getString("id_uprawnienia"));
                lok.setImieNazwisko(lok.getImie() + " " + lok.getNazwisko());
                listPracownikow.add(lok);

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

        return listPracownikow;
    }

    public static void zapiszPracownik(Pracownik pracownik) {
        Connection c = null;
        String sql;

        Statement stmt = null;
        System.out.print("weszklo do tworzenia zapytania");
        sql = "UPDATE pracownik\n"
                + "SET    "
                + "       login='"+pracownik.getLogin()+"', "
                + "       haslo='"+pracownik.getHaslo()+"', "
                + "       imie='"+pracownik.getImie()+"', "
                + "       nazwisko='"+pracownik.getNazwisko()+"', "
                + "       id_stanowisko=(select stanowisko.id_stanowisko from stanowisko where stanowisko.nazwa_stanowisko ilike('"+pracownik.getId_stanowisko()+"')), \n"
                + "       id_dzial=(select dzial.id_dzial from dzial where dzial.nazwa_dzial ilike('"+pracownik.getId_dzial()+"')), "
                + "       id_lokalizacja=(select lokalizacja.id_lokalizacja from lokalizacja where lokalizacja.nazwa_lokalizacja ilike('"+pracownik.getId_lokalizacja()+"')), "
                + "       mail='"+pracownik.getMail()+"', "
                + "       tel_stac='"+pracownik.getTel_stac()+"', "
                + "       tel_kom='"+pracownik.getTel_kom()+"', \n"
                + "       id_import='"+pracownik.getId_import()+"', "
                + "       id_uprawnienia= (select uprawnienia.id_uprawnienia from uprawnienia where uprawnienia.nazwa ilike('"+pracownik.getId_uprawnienia()+"')) \n"
                + " WHERE id_pracownik = "+pracownik.getId_pracownik();

        System.out.println("XXX " + sql);

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

    public static void usunPracownik(Long idPracownika) {
        Connection c = null;
        String sql;

        Statement stmt = null;
        System.out.print("weszklo do tworzenia zapytania");
        sql = "DELETE FROM pracownik where id_pracownik=" + idPracownika;

        System.out.println("XXX " + sql);

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
    public static void dodajPracownika (Pracownik pracownik){
        Connection c = null;
        String sql;

        Statement stmt = null;
        System.out.print("weszklo do tworzenia zapytania");
        sql = "INSERT INTO pracownik(\n" +
"            id_pracownik, login, haslo, imie, nazwisko, id_stanowisko, id_dzial, \n" +
"            id_lokalizacja, mail, tel_stac, tel_kom, id_import, id_uprawnienia)"
                + "VALUES    "
                + "         (select max(id_pracownik)+1 from pracownik), "
                +           pracownik.getLogin()+"', "
                +           pracownik.getHaslo()+"', "
                +           pracownik.getImie()+"', "
                +           pracownik.getNazwisko()+"', "
                + "         (select stanowisko.id_stanowisko from stanowisko where stanowisko.nazwa_stanowisko ilike('"+pracownik.getId_stanowisko()+"')), \n"
                + "         (select dzial.id_dzial from dzial where dzial.nazwa_dzial ilike('"+pracownik.getId_dzial()+"')), "
                + "         (select lokalizacja.id_lokalizacja from lokalizacja where lokalizacja.nazwa_lokalizacja ilike('"+pracownik.getId_lokalizacja()+"')), "
                +           pracownik.getMail()+"', "
                +           pracownik.getTel_stac()+"', "
                +           pracownik.getTel_kom()+"', \n"
                +           pracownik.getId_import()+"', "
                + "         (select uprawnienia.id_uprawnienia from uprawnienia where uprawnienia.nazwa ilike('"+pracownik.getId_uprawnienia()+"')) \n";
               

        System.out.println("XXX " + sql);

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
}
