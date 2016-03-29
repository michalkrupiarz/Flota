/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

/**
 *
 * @author Michal
 */
public class KartaPaliwowaStatusy {
    private Long id;
    private String status;
    private Long id_import;
    
    public KartaPaliwowaStatusy(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId_import() {
        return id_import;
    }

    public void setId_import(Long id_import) {
        this.id_import = id_import;
    }
}
