/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Michal
 */
@ManagedBean
@SessionScoped
public class EdytujSamochod {
    Samochod edytowanySamochod = new Samochod();
    public String zapiszWyedytowanySamochod(){
        
        System.out.println(edytowanySamochod.getNazwa());
        return"index";
    }
}
