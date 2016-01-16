/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author M
 */
@ManagedBean
@SessionScoped
public class WyszukajSamochod {

    public String pokazSzukaneSamochody() {
        return "index";

    }

    public static List getListaSamochodowWyszukanych(
            Samochod przekazanySamochod
            ) {

        Connection c = null;
        String sql;
        List<Samochod> listaSamochodow = new ArrayList<Samochod>();
        Statement stmt = null;
        
        sql = "select samochod.id_samochod as id, samochod.nazwa as nazwa, samochod.marka as marka, samochod.model as model,\n"
                + "samochod.oznaczenie_producenta as oznaczenie_producenta, samochod.paliwo as paliwo, samochod.nr_rej as nr_rej,\n"
                + "samochod.nr_vin as nr_vin, samochod_status.nazwa_samochod_status as status, opony_status.nazwa_opony_status as opony_status,\n"
                + "lokalizacja.nazwa_lokalizacja as lok, lokalizacja_stala.nazwa_lokalizacja as lok_stala, rodzaj_pojazdu.nazwa as rodzaj_pojazdu,\n"
                + "karta_parkingowa.numer_karta_parkingowa as karta_parkingowa, karta_paliwowa.numer_karty as karta_paliwowa, samochod.przebieg_calkowity as przebieg_calkowity,\n"
                + "concat(pracownik.imie ,' ', pracownik.nazwisko) as pracownik, ubezpieczenie.numer_polisy as ubezpieczenie,\n"
                + "samochod.poj_silnika as poj_silnika, samochod.rok_produkcji as rok_produkcji, samochod.data_przyjecia as data_przyjecia, samochod.data_pierwszej_rejestracji as data_pierwszej_rejestracji,\n"
                + "gps.gps_numer as id_gps, samochod.kilometry as kilometry, samochod.kolor as kolor, samochod.wersja as wersja,\n"
                + "typ_samochod.nazwa as id_typ_samochod, samochod.vat as vat, grupa_limit.nazwa as id_grupa_limit, samochod.nr_umowy_leasingu as nr_umowy_leasingu,\n"
                + "samochod.nr_umowy_serwis as nr_umowy_serwis, samochod.mpk as mpk, samochod.prv_umowa as prv_umowa, samochod.umowa_z_dnia as umowa_z_dnia, \n"
                + "samochod.miejsce_parkingowe as miejsce_parkingowe, samochod.rozmiar_opon as rozmiar_opon\n"
                + "from samochod \n"
                + "full join opony_status on samochod.id_opony_status = opony_status.id_opony_status\n"
                + "full join samochod_status on  samochod.id_status = samochod_status.id_samochod_status\n"
                + "full join lokalizacja  on samochod.id_lokalizacja = lokalizacja.id_lokalizacja\n"
                + "full join lokalizacja as lokalizacja_stala on samochod.id_lokalizacja_stala = lokalizacja_stala.id_lokalizacja\n"
                + "full join rodzaj_pojazdu on samochod.id_rodzaj_pojazdu = rodzaj_pojazdu.id_rodzaj_pojazdu\n"
                + "full join karta_parkingowa on samochod.id_karta_parkingowa = karta_parkingowa.id_karta_parkingowa\n"
                + "full join karta_paliwowa on samochod.id_karta_paliwowa = karta_paliwowa.id_karta_paliwowa\n"
                + "full join pracownik on samochod.id_samochod = pracownik.id_samochod\n"
                + "full join ubezpieczenie on samochod.id_samochod = ubezpieczenie.id_samochodu\n"
                + "full join gps on samochod.id_gps = gps.id_gps\n"
                + "full join typ_samochod on samochod.id_typ_samochod = typ_samochod.id_typ_samochod\n"
                + "full join grupa_limit on samochod.id_grupa_limit = grupa_limit.id_grupa_limit\n"
                
                
                + "where samochod.id_samochod is not null\n";

        if (!przekazanySamochod.getModel().isEmpty()) {
            sql = sql + " and samochod.model ilike('" + przekazanySamochod.getModel() + "')\n";
        }

        if (!przekazanySamochod.getId_status().isEmpty()) {
            sql = sql + " and samochod.model ilike('" + przekazanySamochod.getId_status()+ "')\n";
        }

        if (!przekazanySamochod.getPracownik_uzywajacy().isEmpty()) {
            sql = sql + " and concat(pracownik.imie ,' ', pracownik.nazwisko) ilike ('" + przekazanySamochod.getPracownik_uzywajacy() + "')\n";
        }

        if (!przekazanySamochod.getNr_rej().isEmpty()) {
            sql = sql + " and samochod.nr_rej ilike('" + przekazanySamochod.getNr_rej() + "')\n";
        }

        if (!przekazanySamochod.getIdlokalizacja().isEmpty()) {
            sql = sql + " and lokalizacja.nazwa_lokalizacja ilike ('" + przekazanySamochod.getIdlokalizacja() + "')\n";
        }

        if (!przekazanySamochod.getNazwa().isEmpty()) {
            sql = sql + " and samochod.nazwa ilike('" + przekazanySamochod.getNazwa() + "')\n";
        }

        if (!przekazanySamochod.getId_opony_satus().isEmpty()) {
            sql = sql + " and opony_status.nazwa_opony_status ilike('" + przekazanySamochod.getId_opony_satus() + "')\n";
        }

        if (!przekazanySamochod.getOznaczenie_producenta().isEmpty()) {
            sql = sql + " and samochod.oznaczenie_producenta ilike('" + przekazanySamochod.getOznaczenie_producenta() + "')\n";
        }

        if (!przekazanySamochod.getNr_vin().isEmpty()) {
            sql = sql + " and samochod.nr_vin ilike('" + przekazanySamochod.getNr_vin() + "')\n";
        }

        if (!przekazanySamochod.getMarka().isEmpty()) {
            sql = sql + " and samochod.marka ilike('" + przekazanySamochod.getMarka() + "')\n";
        }
        if (!przekazanySamochod.getPaliwo().isEmpty()) {
            sql = sql + " and samochod.paliwo ilike('" + przekazanySamochod.getPaliwo() + "')\n";
        }
        if (!przekazanySamochod.getId_lokalizacja_stala().isEmpty()) {
            sql = sql + " and lokalizacja.nazwa_lokalizacja ilike('" +przekazanySamochod.getId_lokalizacja_stala() + "')\n";
        }
        if (!przekazanySamochod.getId_rodzaj_pojazdu().isEmpty()) {
            sql = sql + " and rodzaj_pojazdu.nazwa ilike('" + przekazanySamochod.getId_rodzaj_pojazdu() + "')\n";
        }
        if (!przekazanySamochod.getId_karta_parkingowa().isEmpty()) {
            sql = sql + " and karta_parkingowa.numer_karta_parkingowa ilike('" + przekazanySamochod.getId_karta_parkingowa() + "')\n";
        }
        if (!przekazanySamochod.getId_karta_paliwowa().isEmpty()) {
            sql = sql + " and karta_paliwowa.numer_karty ilike('" + przekazanySamochod.getId_karta_paliwowa() + "')\n";
        }
        if (przekazanySamochod.getPrzebieg_calkowity().matches("[0-9]+")) {
            sql = sql + " and samochod.przebieg_calkowity =('" + Double.parseDouble(przekazanySamochod.getPrzebieg_calkowity()) + "')\n";
        } //dla tabeli kilometry
        if (!przekazanySamochod.getId_ubezpieczenia().isEmpty()) {
            sql = sql + " and ubezpieczenie.numer_polisy ilike('" + przekazanySamochod.getId_ubezpieczenia() + "')\n";
        }
        if (!przekazanySamochod.getPoj_silnika().isEmpty() ) {
            sql = sql + " and samochod.poj_silnika ilike('" + przekazanySamochod.getPoj_silnika() + "')\n";
        }

        if (przekazanySamochod.getRok_produkcji().matches("[0-9]+")) {
            sql = sql + " and samochod.rok_produkcji = ('" + Integer.parseInt(przekazanySamochod.getRok_produkcji()) + "')\n";
        }

        if (przekazanySamochod.getData_przyjecia().matches("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]")) {
            sql = sql + " and samochod.data_przyjecia = ('" + przekazanySamochod.getData_przyjecia() + "')\n";
        }
        if (przekazanySamochod.getData_pierwszej_rejestracji().matches("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]")) {
            sql = sql + " and samochod.data_przyjecia = ('" + przekazanySamochod.getData_pierwszej_rejestracji() + "')\n";
        }
        if (!przekazanySamochod.getId_gps().isEmpty()) {
            sql = sql + "and gps.gps_numer ilike ('" + przekazanySamochod.getId_gps() + "')\n";
        }

        if (przekazanySamochod.getKilometry().matches("[0-9]+")) {
            sql = sql + "and samochod.kilometry =('" + Double.parseDouble(przekazanySamochod.getKilometry()) + "')\n";
        }
        if (!przekazanySamochod.getKolor().isEmpty()) {
            sql = sql + "and samochod.kolor ilike('" + przekazanySamochod.getKolor()  + "')\n";
        }
        if (!przekazanySamochod.getWersja().isEmpty()) {
            sql = sql + "and samochod.wersja ilike ('" + przekazanySamochod.getWersja() + "')\n";
        }
        if (!przekazanySamochod.getId_typ_samochodu().isEmpty()) {
            sql = sql + "and typ_samochod.nazwa ilike('" + przekazanySamochod.getId_typ_samochodu() + "')\n";
        }

        if (!przekazanySamochod.getVat().isEmpty()) {
            sql = sql + "and samochod.vat ilike('" + przekazanySamochod.getVat() + "')\n";
        }
        if (!przekazanySamochod.getId_grupa_limit().isEmpty()) {
            sql = sql + "and grupa_limit.nazwa ilike('" + przekazanySamochod.getId_grupa_limit() + "')\n";
        }
        if (!przekazanySamochod.getNr_umowy_leasingu().isEmpty()) {
            sql = sql + "and samochod.nr_umowy_leasingu ilike ('" + przekazanySamochod.getNr_umowy_leasingu() + "')\n";
        }
        if (!przekazanySamochod.getNr_umowy_serwis().isEmpty()) {
            sql = sql + "and samochod.nr_umowy_serwis ilike ('" + przekazanySamochod.getNr_umowy_serwis() + "')\n";
        }

        if (!przekazanySamochod.getMpk().isEmpty()) {
            sql = sql + "and samochod.mpk ilike('" + przekazanySamochod.getMpk() + "')\n";
        }
        if (!przekazanySamochod.getPrv_umowa().isEmpty()) {
            sql = sql + "and samochod.prv_umowa ilike ('" + przekazanySamochod.getPrv_umowa() + "')\n";
        }

        if (przekazanySamochod.getUmowa_z_dnia().matches("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]")) {
            sql = sql + "and samochod.umowa_z_dnia =('" + przekazanySamochod.getUmowa_z_dnia() + "')\n";
        }
        if (!przekazanySamochod.getMiejsce_parkingowe().isEmpty()) {
            sql = sql + "and samochod.miejsce_parkingowe ilike ('" + przekazanySamochod.getMiejsce_parkingowe() + "')\n";
        }

        if (przekazanySamochod.getRozmiar_opon().matches("[0-9]+")) {
            sql = sql + "and samochod.rozmiar_opon =('" + Double.parseDouble(przekazanySamochod.getRozmiar_opon()) + "')\n";
        }

        

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Samochod samochod = new Samochod();
                samochod.setId_samochod(rs.getInt("id"));
                samochod.setLokalizacja(rs.getString("lok"));
                samochod.setModel(rs.getString("model"));
                samochod.setNr_rej(rs.getString("nr_rej"));
                samochod.setId_status(rs.getString("status"));
                samochod.setPracownik_uzywajacy(rs.getString("pracownik"));
                samochod.setNazwa(rs.getString("nazwa"));
                samochod.setId_opony_satus(rs.getString("opony_status"));
                samochod.setOznaczenie_producenta(rs.getString("oznaczenie_producenta"));
                samochod.setNr_vin(rs.getString("nr_vin"));
                samochod.setMarka(rs.getString("marka"));
                samochod.setPaliwo(rs.getString("paliwo"));
                samochod.setId_lokalizacja_stala(rs.getString("lok_stala"));
                samochod.setId_rodzaj_pojazdu(rs.getString("rodzaj_pojazdu"));
                samochod.setId_karta_parkingowa(rs.getString("karta_parkingowa"));
                samochod.setId_karta_paliwowa(rs.getString("karta_paliwowa"));
                samochod.setPrzebieg_calkowity(rs.getString("przebieg_calkowity"));
                samochod.setId_ubezpieczenia(rs.getString("ubezpieczenie"));

                samochod.setRok_produkcji(rs.getString("rok_produkcji"));
                samochod.setData_przyjecia(rs.getString("data_przyjecia"));
                samochod.setData_pierwszej_rejestracji(rs.getString("data_pierwszej_rejestracji"));
                samochod.setId_gps(rs.getString("id_gps"));
                samochod.setKilometry(rs.getString("kilometry"));
                samochod.setKolor(rs.getString("kolor"));
                samochod.setWersja(rs.getString("wersja"));
                samochod.setId_typ_samochodu(rs.getString("id_typ_samochod"));
                samochod.setVat(rs.getString("vat"));
                samochod.setId_grupa_limit(rs.getString("id_grupa_limit"));
                samochod.setNr_umowy_leasingu(rs.getString("nr_umowy_leasingu"));
                samochod.setNr_umowy_serwis(rs.getString("nr_umowy_serwis"));

                samochod.setMpk(rs.getString("mpk"));
                samochod.setPrv_umowa(rs.getString("prv_umowa"));
                samochod.setUmowa_z_dnia(rs.getString("umowa_z_dnia"));
                samochod.setMiejsce_parkingowe(rs.getString("miejsce_parkingowe"));
                samochod.setRozmiar_opon(rs.getString("rozmiar_opon"));

                listaSamochodow.add(samochod);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return listaSamochodow;
    }

    public static List getListaSamochodowNowa() {
        Connection c = null;

        List<Samochod> listaSamochodow = new ArrayList<Samochod>();
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:7886/",
                            "postgres", "ponczus21");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "select samochod.id_samochod as id, samochod.nazwa as nazwa, samochod.marka as marka, samochod.model as model,\n"
                + "samochod.oznaczenie_producenta as oznaczenie_producenta, samochod.paliwo as paliwo, samochod.nr_rej as nr_rej,\n"
                + "samochod.nr_vin as nr_vin, samochod_status.nazwa_samochod_status as status, opony_status.nazwa_opony_status as opony_status,\n"
                + "lokalizacja.nazwa_lokalizacja as lok, lokalizacja_stala.nazwa_lokalizacja as lok_stala, rodzaj_pojazdu.nazwa as rodzaj_pojazdu,\n"
                + "karta_parkingowa.numer_karta_parkingowa as karta_parkingowa, karta_paliwowa.numer_karty as karta_paliwowa, samochod.przebieg_calkowity as przebieg_calkowity,\n"
                + "concat(pracownik.imie ,' ', pracownik.nazwisko) as pracownik, ubezpieczenie.numer_polisy as ubezpieczenie,\n"
                + "samochod.poj_silnika as poj_silnika, samochod.rok_produkcji as rok_produkcji, samochod.data_przyjecia as data_przyjecia, samochod.data_pierwszej_rejestracji as data_pierwszej_rejestracji,\n"
                + "gps.gps_numer as id_gps, samochod.kilometry as kilometry, samochod.kolor as kolor, samochod.wersja as wersja,\n"
                + "typ_samochod.nazwa as id_typ_samochod, samochod.vat as vat, grupa_limit.nazwa as id_grupa_limit, samochod.nr_umowy_leasingu as nr_umowy_leasingu,\n"
                + "samochod.nr_umowy_serwis as nr_umowy_serwis, samochod.mpk as mpk, samochod.prv_umowa as prv_umowa, samochod.umowa_z_dnia as umowa_z_dnia, \n"
                + "samochod.miejsce_parkingowe as miejsce_parkingowe, samochod.rozmiar_opon as rozmiar_opon\n"
                + "from samochod \n"
                + "full join opony_status on samochod.id_opony_status = opony_status.id_opony_status\n"
                + "full join samochod_status on  samochod.id_status = samochod_status.id_samochod_status\n"
                + "full join lokalizacja  on samochod.id_lokalizacja = lokalizacja.id_lokalizacja\n"
                + "full join lokalizacja as lokalizacja_stala on samochod.id_lokalizacja_stala = lokalizacja_stala.id_lokalizacja\n"
                + "full join rodzaj_pojazdu on samochod.id_rodzaj_pojazdu = rodzaj_pojazdu.id_rodzaj_pojazdu\n"
                + "full join karta_parkingowa on samochod.id_karta_parkingowa = karta_parkingowa.id_karta_parkingowa\n"
                + "full join karta_paliwowa on samochod.id_karta_paliwowa = karta_paliwowa.id_karta_paliwowa\n"
                + "full join pracownik on samochod.id_samochod = pracownik.id_samochod\n"
                + "full join ubezpieczenie on samochod.id_samochod = ubezpieczenie.id_samochodu\n"
                + "full join gps on samochod.id_gps = gps.id_gps\n"
                + "full join typ_samochod on samochod.id_typ_samochod = typ_samochod.id_typ_samochod\n"
                + "full join grupa_limit on samochod.id_grupa_limit = grupa_limit.id_grupa_limit\n"
                
                
                + "where samochod.id_samochod is not null\n";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

               Samochod samochod = new Samochod();
                samochod.setId_samochod(rs.getInt("id"));
                samochod.setLokalizacja(rs.getString("lok"));
                samochod.setModel(rs.getString("model"));
                samochod.setNr_rej(rs.getString("nr_rej"));
                samochod.setId_status(rs.getString("status"));
                samochod.setPracownik_uzywajacy(rs.getString("pracownik"));
                samochod.setNazwa(rs.getString("nazwa"));
                samochod.setId_opony_satus(rs.getString("opony_status"));
                samochod.setOznaczenie_producenta(rs.getString("oznaczenie_producenta"));
                samochod.setNr_vin(rs.getString("nr_vin"));
                samochod.setMarka(rs.getString("marka"));
                samochod.setPaliwo(rs.getString("paliwo"));
                samochod.setId_lokalizacja_stala(rs.getString("lok_stala"));
                samochod.setId_rodzaj_pojazdu(rs.getString("rodzaj_pojazdu"));
                samochod.setId_karta_parkingowa(rs.getString("karta_parkingowa"));
                samochod.setId_karta_paliwowa(rs.getString("karta_paliwowa"));
                samochod.setPrzebieg_calkowity(rs.getString("przebieg_calkowity"));
                samochod.setId_ubezpieczenia(rs.getString("ubezpieczenie"));

                samochod.setRok_produkcji(rs.getString("rok_produkcji"));
                samochod.setData_przyjecia(rs.getString("data_przyjecia"));
                samochod.setData_pierwszej_rejestracji(rs.getString("data_pierwszej_rejestracji"));
                samochod.setId_gps(rs.getString("id_gps"));
                samochod.setKilometry(rs.getString("kilometry"));
                samochod.setKolor(rs.getString("kolor"));
                samochod.setWersja(rs.getString("wersja"));
                samochod.setId_typ_samochodu(rs.getString("id_typ_samochod"));
                samochod.setVat(rs.getString("vat"));
                samochod.setId_grupa_limit(rs.getString("id_grupa_limit"));
                samochod.setNr_umowy_leasingu(rs.getString("nr_umowy_leasingu"));
                samochod.setNr_umowy_serwis(rs.getString("nr_umowy_serwis"));

                samochod.setMpk(rs.getString("mpk"));
                samochod.setPrv_umowa(rs.getString("prv_umowa"));
                samochod.setUmowa_z_dnia(rs.getString("umowa_z_dnia"));
                samochod.setMiejsce_parkingowe(rs.getString("miejsce_parkingowe"));
                samochod.setRozmiar_opon(rs.getString("rozmiar_opon"));
                listaSamochodow.add(samochod);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return listaSamochodow;
    }
}
