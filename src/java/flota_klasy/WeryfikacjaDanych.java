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
    
   
    
    public static boolean sprawdzNrRej(String nrrej){
    
        boolean sprawdz;
        
        if (nrrej.length()==7) 
        
        {
            sprawdz = true;
        }else
        {
            sprawdz = false;
        }
        return sprawdz;
    }
    
    public static boolean sprawdzNazwe(String nazwa){
        boolean sprawdz;
        
        if(nazwa.isEmpty()) {
            sprawdz = false;
        }   else
        {
            sprawdz=true;
        }
        return sprawdz;
            
    }
    
    public static boolean sprawdzMarke (String marka){
        boolean sprawdz;
        if(marka.isEmpty()){
            sprawdz=false;
        }else{
            sprawdz=true;
        }
        return sprawdz;
    }
    
    public static boolean sprawdzModel (String model){
        boolean sprawdz;
        if(model.isEmpty()) {
            sprawdz=false;
        }else{
            sprawdz=true;
        }
        return sprawdz;
    }
    
    public static boolean oznProd (String oP){
        boolean sprawdz;
        if(oP.isEmpty()){
            sprawdz=false;
        }else{
            sprawdz=true;
        }
        return sprawdz;
    }
    
        public static boolean Paliwo (String paliwo){
        boolean sprawdz;
        if(paliwo.equals("Diesel") || paliwo.equals("Benzyna")){
            sprawdz=true;
        }else{
            sprawdz=false;
        }
        return sprawdz;
    }
    
     public static boolean Vin(String vin){
    
        boolean sprawdz;
        
        if (vin.length()==17) 
        
        {
            sprawdz = true;
        }else
        {
            sprawdz = false;
        }
        return sprawdz;
    }
     
    
}

