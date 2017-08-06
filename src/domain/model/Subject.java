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
public class Subject {
    private String subject;
    private int subjectid;
    private ArrayList<Comment> commentlist = new ArrayList<>();
    
    public Subject() {
        
    }
    
    public Subject(String subject, int subjectid) {
        setSubject(subject);
        setSubjectid(subjectid);
    }

    private void setSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) throw new DomainException("Subject cannot be null or empty");
        this.subject = subject;
    }

    private void setSubjectid(int subjectid) {
        if (subjectid < 0) throw new DomainException("Subjectid cannot be smaller than 0");
        this.subjectid = subjectid;
    }
    
    public String getSubject() {
        return this.subject;
    }
    
    public int getSubjectid() {
        return this.subjectid;
    }
    
    public ArrayList<Comment> getCommentlist() {
        return this.commentlist;
    }
    
    private void setCommentlist(ArrayList<Comment> commentlist) {
        this.commentlist = commentlist;
    }
    
    public void addCommentToList(String writer, String content, int commentid) {
        Comment comment = new Comment(writer,content,commentid);
        commentlist.add(comment);
        System.out.println("Comment " + comment.toString() + " has been added");
    }
    
    public void addCommentObjectToList(Comment comment) {
        if (comment == null) throw new DomainException("When adding to list, comment cannot be null");
        this.commentlist.add(comment);
    }
    
}
