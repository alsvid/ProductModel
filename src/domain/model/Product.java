/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.model;

/**
 *
 * @author Alsvid
 */
public class Product {
    private int aantal;
    private int id;
    private String productnaam;
    private String status;

    public Product() {
        
    }
    
    public Product(String productnaam, int aantal, int id, String status) {
        setProductnaam(productnaam);
        setAantal(aantal);
        setId(id);
        setStatus(status);
    }
    
    public void setProductnaam(String productnaam) {
        if (productnaam == null || productnaam.trim().isEmpty()) throw new DomainException("Productnaam mag niet null of leeg zijn");        this.productnaam = productnaam;
    }
    
    public void setAantal(int aantal) {
        if (aantal < 0) throw new DomainException("Aantal in stock kan niet kleiner dan 0 zijn");
        this.aantal = aantal;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) throw new DomainException("Status mag niet null of leeg zijn");
        this.status = status;
    }   
    
    public String getProductnaam() {
        return this.productnaam;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public int getAantal() {
        return this.aantal;
    }

    public void setId(int id) {
        if (id < 1) throw new DomainException("ID mag niet kleiner dan 1 zijn");
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
}
