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
public class Message {
    
    private String content;
    private String writer;
    
    public Message(String writer, String content) {
        
    }
    
    public String getContent() {
        return this.content;
    }
    
    private void setContent(String content) {
        this.content = content;
    }
    
    public String getWriter() {
        return this.writer;
    }
    
    private void setWriter(String writer) {
        this.writer = writer;
    }
    
    @Override
    public String toString() {
        return "Message toString: FROM: " + this.getWriter() + " MESSAGE; " + this.getContent();
    }
}
