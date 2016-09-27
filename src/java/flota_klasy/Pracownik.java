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
public class Pracownik implements Cloneable{
    private long id_pracownik;
    private String login;
    private String haslo;
    private String imie;
    private String nazwisko;
    private String id_stanowisko;
    private String id_dzial;
    private String id_lokalizacja;
    private String mail;
    private String tel_stac;
    private String tel_kom;
    private String id_samochod;
    private int id_import;
    private String id_uprawnienia;
    private String imieNazwisko;
    
    public Pracownik(){
        
    }

    public Pracownik(long id_pracownik, String login, String haslo, String imie, String nazwisko, String id_stanowisko, String id_dzial, String id_lokalizacja, String mail, String tel_stac, String tel_kom, String id_samochod, int id_import, String id_uprawnienia) {
        this.id_pracownik = id_pracownik;
        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id_stanowisko = id_stanowisko;
        this.id_dzial = id_dzial;
        this.id_lokalizacja = id_lokalizacja;
        this.mail = mail;
        this.tel_stac = tel_stac;
        this.tel_kom = tel_kom;
        this.id_samochod = id_samochod;
        this.id_import = id_import;
        this.id_uprawnienia = id_uprawnienia;
        this.imieNazwisko = imieNazwisko;
    }

    public long getId_pracownik() {
        return id_pracownik;
    }

    public void setId_pracownik(long id_pracownik) {
        this.id_pracownik = id_pracownik;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getId_stanowisko() {
        return id_stanowisko;
    }

    public void setId_st(String id_stanowisko) {
        this.id_stanowisko = id_stanowisko;
    }

    public String getId_dzial() {
        return id_dzial;
    }

    public void setId_dzial(String id_dzial) {
        this.id_dzial = id_dzial;
    }

    public String getId_lokalizacja() {
        return id_lokalizacja;
    }

    public void setId_lokalizacja(String id_lokalizacja) {
        this.id_lokalizacja = id_lokalizacja;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel_stac() {
        return tel_stac;
    }

    public void setTel_stac(String tel_stac) {
        this.tel_stac = tel_stac;
    }

    public String getTel_kom() {
        return tel_kom;
    }

    public void setTel_kom(String tel_kom) {
        this.tel_kom = tel_kom;
    }

    public String getId_samochod() {
        return id_samochod;
    }

    public void setId_samochod(String id_samochod) {
        this.id_samochod = id_samochod;
    }

    public int getId_import() {
        return id_import;
    }

    public void setId_import(int id_import) {
        this.id_import = id_import;
    }

    public String getId_uprawnienia() {
        return id_uprawnienia;
    }

    public void setId_uprawnienia(String id_uprawnienia) {
        this.id_uprawnienia = id_uprawnienia;
    }

    public String getImieNazwisko() {
        return imieNazwisko;
    }

    public void setImieNazwisko(String imieNazwisko) {
        this.imieNazwisko = imieNazwisko;
    }
    @Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
    
}
