/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

/**
 *
 * @author Alsvid
 */
public class DbException extends RuntimeException {
    
    public DbException() {
        super();
    }
    
    public DbException(String message) {
        super(message);
    }
}
