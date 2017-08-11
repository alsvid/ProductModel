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
public class ConversationRepositoryInMemory {
    
    private ArrayList<Conversation> conversationlist = new ArrayList<>();
    
    public ConversationRepositoryInMemory() {
        
    }
    
    public void addMessageNew(Person person1, Person person2, Message message) {
        createConversation(person1, person2);
        getConversation(person1, person2).addMessage(message);
    }
    
    public void addMessage(Conversation convo, Message message) {
        convo.addMessage(message);
    }
    
    public Conversation createConversation(Person person1, Person person2) {
        Conversation convo = getConversation(person1, person2);
        if (convo == null) {
            convo = new Conversation(person1, person2);
            this.conversationlist.add(convo);
        }
        return convo;
    }
  
    
    public Conversation getConversation(Person p1, Person p2) {
        Conversation out = null;
        for (Conversation convo : conversationlist) {
            if (convo.getPerson1().equals(p1) && convo.getPerson2().equals(p2)) {
		out = convo;
            }
            if (convo.getPerson1().equals(p2) && convo.getPerson2().equals(p1)) {
		out = convo;
            }
	}
	return out;
    }

    
    public void addConversation(Conversation convo) {
        if (convo == null) throw new DbException("Conversation cannot be null when added to list");
        this.conversationlist.add(convo);
    }
    
    public void addMessageToConversationInList(Conversation convo,Message message) {
        for (Conversation c : conversationlist) {
            if (c.equals(convo)) {
                c.addMessage(message);
            }
        }
    }
    
    public void addMessageToConversation(Conversation convo, Message message) {
		convo.addMessage(message);
    }
    
    public ArrayList<Conversation> getConversationlist() {
        return this.conversationlist;
    }
}
