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
public class Comment {
    private String content;
    private String writer;
    private int commentid;
    
    public Comment() {
        
    }
    
    public Comment(String content, String writer, int commentid) {
        setContent(content);
        setWriter(writer);
        setCommentid(commentid);
    }
    
    public String getWriter() {
        return this.writer;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public int getCommentid() {
        return this.commentid;
    }
    
    private void setWriter(String writer) {
        this.writer = writer;
    }
    
    private void setContent(String content) {
        this.content = content;
    }
    
    private void setCommentid(int commentid) {
        this.commentid = commentid;
    }
    
    @Override
    public String toString() {
        return "[" + this.writer + "," + this.content + "," + this.commentid + "]";
    }
}
