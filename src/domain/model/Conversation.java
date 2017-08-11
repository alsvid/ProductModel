/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.model;

import java.util.ArrayList;

/**
 *
 * @author Alsvid
 */
public class Conversation {
    
    private Person person1;
    private Person person2;
    private ArrayList<Message> messagelist = new ArrayList<>();
    
    public Conversation(Person person1, Person person2) {
        setPerson1(person1);
        setPerson2(person2);
    }
    
    public Person getPerson1() {
        return this.person1;
    }
    
    private void setPerson1(Person person1) {
        this.person1 = person1;
    }
    
    public Person getPerson2() {
        return this.person2;
    }

    private void setPerson2(Person person2) {
        this.person2 = person2;
    }
    
    public ArrayList<Message> getMessagelist() {
        return this.messagelist;
    }
    
    public void setMessages(ArrayList<Message> messagelist) {
        this.messagelist = messagelist;
    }
    
    public void addMessage(Message message) {
        this.messagelist.add(message);
    }
    
    @Override
    public String toString() {
        return "Conversation between " + person1.getUserid() + " and " + person2.getUserid();
    }
    
    
}
