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
public class WeryfikacjaDanych {

    public static boolean czyWprowadzono(String nazwaPola) {
        boolean sprawdz;

        if (nazwaPola.isEmpty()) {
            sprawdz = true;
        } else {
            sprawdz = false;
        }

        return sprawdz;
    }

    public static String czyPoprawnaDlugosc(String nazwaPola, int wymaganaDlugosc) {
        String sprawdz;
        if (nazwaPola.length() != wymaganaDlugosc) {
            sprawdz = "nie";
        } else {
            sprawdz = "tak";
        }

        return sprawdz;
    }

    public static String czyUnikalny(String nazwaPola, String nazwaTabeli, String nazwaZmienna) {

        String sprawdz;

        sprawdz = SamochodZapytania.sprawdzUnikalnoscDanych(nazwaPola, nazwaTabeli, nazwaZmienna);

        return sprawdz;
    }

}
