/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Michal
 */
@ManagedBean
@SessionScoped
public class EdytujSamochod {
    private Samochod wyedytowanySamochod = new Samochod();
    

    
    public Samochod getWyedytowanySamochod(){
        return wyedytowanySamochod;
    }
       
    public String zapiszWyedytowanySamochod(){  
        System.out.println("nowa nazwa samochodu"+wyedytowanySamochod.getNazwa());
        return null;
    }
}
