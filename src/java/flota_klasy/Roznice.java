/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michal
 */
public class Roznice {
    private String nazwaPola;
    private Object wartoscWzor;
    private Object wartoscKopia;

    public String getNazwaPola() {
        return nazwaPola;
    }

    public void setNazwaPola(String nazwaPola) {
        this.nazwaPola = nazwaPola;
    }

    public Object getWartoscWzor() {
        return wartoscWzor;
    }

    public void setWartoscWzor(Object wartoscWzor) {
        this.wartoscWzor = wartoscWzor;
    }

    public Object getWartoscKopia() {
        return wartoscKopia;
    }

    public void setWartoscKopia(Object wartoscKopia) {
        this.wartoscKopia = wartoscKopia;
    }
    
    public static List<Roznice> stworzListeRoznic (List<Object> wzor, List<Object> kopia, List<Integer> rozniceItem, List<String> pola){
        
        List<Roznice> listaRoznic = new ArrayList<Roznice>();
        for (Integer item : rozniceItem) {
            Roznice zestawRoznic = new Roznice();
            zestawRoznic.setNazwaPola(pola.get(item));
            zestawRoznic.setWartoscWzor(wzor.get(item));
            zestawRoznic.setWartoscKopia(kopia.get(item));
            listaRoznic.add(zestawRoznic);
    }
        return listaRoznic;
    }
}
