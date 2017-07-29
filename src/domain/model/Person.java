/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author Alsvid
 */
public class Person {
    
    private String firstname;
    private String lastname;
    private String userid;
    private String password;
    public ROLE role;
    public STATUS status;
    
    public Person() {
        
    }
    
    public Person(String firstname, String lastname, String userid, String password, ROLE role, STATUS status) {
        this.role = role;
        this.status = status;
        setFirstname(firstname);
        setLastname(lastname);
        setUserid(userid);
        setPassword(password);
    }
    
    public ROLE getRole() {
        return this.role;
    }
    
    public void setRole(ROLE role) {
        this.role = role;
    }
    
    public void setStatus(STATUS status) {
        this.status = status;
    }
    
    public void setStatusString(String status) {
        switch (status.toLowerCase()) {
            case "online":
                setStatus(STATUS.ONLINE);
                break;
            case "offline":
                setStatus(STATUS.OFFLINE);
                break;
            case "away":
                setStatus(STATUS.AWAY);
                break;
            default:
                throw new IllegalArgumentException("Wrong status, please choose between offline, online or away");
        }
    }
    
    public void setRoleString(String role) {
        switch(role.toLowerCase()) {
            case "client":
                setRole(ROLE.CLIENT);
                break;
            case "administrator":
                setRole(ROLE.ADMINISTRATOR);
                break;
            default:
                throw new IllegalArgumentException("Wrong role, please type administrator or client");
        }
    }
    
    public String getRoleString() {
        if (this.role == ROLE.ADMINISTRATOR) {
            return "administrator";
        }
        else {
            return "client";
        }
    }
    
   public String getStatusString() {
    if (this.status == STATUS.OFFLINE) {
        return "offline";
    }
    else if (this.status == STATUS.ONLINE) {
        return "online";
    }
    else {
        return "away";
    }
}
    
    public enum ROLE{
        CLIENT,ADMINISTRATOR
    }
    
    public enum STATUS{
        ONLINE,OFFLINE,AWAY
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    public void setPassword(String password) {
        this.password = password;
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
    
    public String getPassword() {
        return this.password;
    }
    
    public String hashPassword(String password) throws NoSuchAlgorithmException {
        String generatedpw = null;
        try {
            byte[] salt = getSalt();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < bytes.length; ++i) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedpw = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedpw;
    }
    
    private byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}
