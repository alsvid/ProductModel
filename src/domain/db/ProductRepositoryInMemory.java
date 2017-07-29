/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;
import domain.model.*;
import java.util.ArrayList;
/**
 *
 * @author Alsvid
 */
public class ProductRepositoryInMemory {
    
    private ArrayList<Product> productenlijst;
    
    public ProductRepositoryInMemory() {
        productenlijst = new ArrayList<Product>();
        Product test = new Product("AMD R9 390X", 100, 1, "Voldoende");
        productenlijst.add(test);
    }
    
    public ArrayList<Product> getProductenlijst() {
        return this.productenlijst;
    }
    
    public void addProduct(Product p) {
        if (p == null) throw new DbException("Toevoegen van product - product mag niet null zijn");
        productenlijst.add(p);
    }
    
    public Product findProductWithId(int id) {
        Product out = null;
        for (Product p : productenlijst) {
            if (p.getId() == id) {
                out = p;
            }
        }
        return out;
    }
    
    public Product findProductWithName(String name) {
        Product out = null;
        for (Product p : productenlijst) {
            if (p.getProductnaam().toLowerCase().equals(name.toLowerCase())) {
                out = p;
            }
        }
        return out;
    }
    
    public void removeProductWithId(int id) {
        for (Product p : productenlijst) {
            if (p.getId() == id) {
                productenlijst.remove(p);
            }
        }
    }
    
    public void removeProduct(Product p) {
        if (p == null) throw new DbException("Product cannot be null");
        productenlijst.remove(p);
    }
    
    public void removeProductWithName(String name) {
        for (Product p : productenlijst) {
            if (p.getProductnaam().toLowerCase().equals(name)) {
                productenlijst.remove(p);
            }
        }
    }
    
    public boolean checkAvailabilityIdWithName(int id, String productnaam) {
        boolean out = true;
        for (Product p : productenlijst) {
            if (p.getId() == id && p.getProductnaam().equals(productnaam)) {
                out = false;
            }
        }
        return out;
    }
    
    public boolean checkAvailabilityId(int id) {
        boolean out = true;
        if (!(findProductWithId(id) != null)) out = false;
        return out;
    }
            
}
