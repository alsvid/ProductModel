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
public class AdminPersonAngular {
    
    private String firstname, lastname, userid, status;
    
    public AdminPersonAngular(String firstname, String lastname, String userid, String status) {
        setFirstname(firstname);
        setLastname(lastname);
        setUserid(userid);
        setStatus(status);
    }

    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }

    private void setUserid(String userid) {
        this.userid = userid;
    }

    private void setStatus(String status) {
        this.status = status;
    }
    
    public String getFirstname() {
        return this.firstname;
    }
    
    public String getLastname() {
        return this.lastname;
    }
    
    public String getUserid() {
        return this.userid;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    
    
}
