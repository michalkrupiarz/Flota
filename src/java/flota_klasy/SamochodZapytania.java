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
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
/**
 *
 * @author M
 */
@ManagedBean
@SessionScoped
public class SamochodZapytania {
    
    long id;
    List<Lokalizacja> listaLokalizacji;
    List<Samochod> listaSamochodow;
    DataModel listaSamochodowNowa;
    Samochod samochod;
    Lokalizacja lok;
    
    private Samochod aktualnySamochod;
    private String modelSamochodu="%";
    private String statusSamochodu="%";
    private String nrrejSamochodu="%";
    private String lokalizacjaSamochodu="%";
    private String pracownikSamochodu="%";
    private String nazwaSamochodu="%";
    private String vinSamochodu = "%";
    private String oznaczenieproducentaSamochodu = "%";
    private String markaSamochodu = "%";
    private String oponystatusSamochodu="%";
    
    private String paliwoSamochodu="%";
    private String lokalizacjaStalaSamochodu = "%";
    
    private String rodzajSamochodu = "%";
    private String kartaParkingowa = "%";
    private String kartaPaliwowa = "%";
    private String przebiegSamochodu = "%"; //dla tabeli kilometry
    private String ubezpieczenieSamochodu = "%";
    
        ;
    /**  
     * 
     * Creates a new instance of SamochodZapytania
     */
    public SamochodZapytania() {
    }
    
    
     
 
    //piszemyt wlasnie
    
    //pirzesmzy wlasnie
    

    
    
    
    
 
}
