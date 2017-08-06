/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

import domain.model.Comment;
import domain.model.Subject;
import java.util.ArrayList;

/**
 *
 * @author Alsvid
 */
public class SubjectRepositoryInMemory {
    
    private ArrayList<Subject> subjectlist = new ArrayList<>();
    
    public SubjectRepositoryInMemory() {
       subjectlist.add(new Subject("The recent release of AMD's Vega line", 1));
       subjectlist.add(new Subject("Will threadripper be the new kingpin architecture?",2));
       subjectlist.add(new Subject("Why do you think Matrix went bankrupt?",3));
    }
    
    public void addSubject(Subject s) {
        if (s == null) throw new DbException("Subject cannot be null when adding it to the list");
        subjectlist.add(s);
    }
    
    public void removeSubjectWithId(int id) {
        Subject out = null;
        if (id < 0) throw new DbException("Id cannot be smaller than 0");
        for (Subject sub : subjectlist) {
            if (sub.getSubjectid() == id) {
                subjectlist.remove(sub);
            }
        }
    }
    
    public void removeSubject(Subject sub) {
        if (sub == null) {
            throw new DbException("Subject cannot be null");
        }
        subjectlist.remove(sub);
    }
    
    public Subject getSubjectWithId(int id) {
        Subject out = null;
        if (id < 0) throw new DbException("Id cannot be smaller than 0");
        for (Subject sub : subjectlist) {
            if (sub.getSubjectid() == id) {
                out = sub;
            }
        }
        return out;
    }
    
    public ArrayList<Subject> getSubjectlist() {
        return this.subjectlist;
    }
    
    public ArrayList<Comment> getSubjectComments() {
        ArrayList<Comment> out = new ArrayList<>();
        for (Subject sub : subjectlist) {
            out.addAll(sub.getCommentlist());
        }
        System.out.println("Received: " + out.toString());
        return out;
    }
}
