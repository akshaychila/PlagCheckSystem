/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plagchecksystem;

import java.io.Serializable;

/**
 *
 * @author akshaychila
 */
public class Submission implements Serializable{
    private int submissionId;
    private String submissionText;
    private String comments;
    private static int nextId = 3000; 
  
    private User users;
    private Assignment assignments;
    
    public static int getNextId() { return nextId; }
    public static void setNextId(int i) { nextId = i; }
    
    public int getId(){
        return submissionId;
    }
    
    public String getSubmissionText(){
        return submissionText;
    }
    
    public String getComments(){
        return comments;
    }
    
    public Assignment getAssignment(){
        return assignments;
    }
    
    public User getUser(){
        return users;
    }
    
    public void setComment(String s){
        comments = s;
    }
        
   
    public Submission(User user,Assignment assignment, String submissionText){
        users = new User();
        assignments = new Assignment();
        this.users = user;
        submissionId=nextId++;
        this.submissionText=submissionText;
    
        this.assignments = assignment;
        
    }
    public Submission(){ users = new User();
        assignments = new Assignment();
submissionId= nextId++;}
    
}
