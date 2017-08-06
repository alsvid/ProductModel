/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

import domain.model.Person;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 *
 * @author Alsvid
 */
public class PersonRepositoryInMemory {
    
    private ArrayList<Person> personlist = new ArrayList<>();
    
    public PersonRepositoryInMemory() {
        Person admin = new Person("Brecht", "Theys", "brechttheys", "admin", Person.ROLE.ADMINISTRATOR, "ONLINE");
        Person helpdesk1 = new Person("Danny", "Bridges", "Helpdesk-Danny", "helpdesk", Person.ROLE.HELPDESK, "ONLINE");
        Person helpdesk2 = new Person("Chris", "Quinn", "Helpdesk-Chris", "helpdesk", Person.ROLE.HELPDESK, "OFFLINE");
        Person helpdesk3 = new Person("Samuel", "Brimble", "Helpdesk-Sam", "helpdesk", Person.ROLE.HELPDESK, "BRB");
        Person helpdesk4 = new Person("Redgy", "Noth", "Helpdesk-Redgy", "helpdesk", Person.ROLE.HELPDESK, "ONLINE");
        
        personlist.add(admin);
        personlist.add(helpdesk1);
        personlist.add(helpdesk2);
        personlist.add(helpdesk3);
        personlist.add(helpdesk4);
    }
    
    public ArrayList<Person> getPersonlist() {
        return this.personlist;
    }
    
    public Person findPersonWithName(String name) {
        Person out = null;
        String[] array = name.split((" "));
        for (Person p : personlist) {
            if (p.getFirstname().toLowerCase() == array[0].toLowerCase() && p.getLastname().toLowerCase() == array[1].toLowerCase()) {
                out = p;
            }
        }
        return out;
    }
    
    public Person findPersonWithUserid(String userid) {
        Person out = null;
        for (Person p : personlist) {
            if (p.getUserid().equals(userid)) {
                out = p;
            }
        }
        return out;
    }
    
    public Person findPersonWithUseridAndPassword(String userid, String password) {
        Person out = null;
        for (Person p : personlist) {
            if (p.getUserid().equals(userid) && p.getPassword().equals(password)) {
                out = p;
            }
        }
        return out;
    }
    
    public void removePersonWithUserid(String userid) {
        Person toRemove = findPersonWithUserid(userid);
        personlist.remove(toRemove);
    }
    
    public void addPerson(Person p) {
        if (p == null) throw new DbException("Person can not be null");
        personlist.add(p);
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
    
    public ArrayList<Person> getAllHelpdeskMembers() {
        ArrayList<Person> out = new ArrayList<>();
        for (Person p : personlist) {
            if (p.getRoleString().equals("helpdesk")) {
                out.add(p);
            }
        }
        return out;
    }
    
}   
    
