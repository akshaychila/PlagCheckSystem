/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plagchecksystem;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author akshaychila
 */
public class User implements Serializable{
    private int userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String type;
    private int userCode;
    private static int nextId = 1; 
    private LinkedList<Course> courses;
    private LinkedList<Submission> submissions;
    
    public String getUserName(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public int getUserID(){
        return userId;
    }
    public String getFirstName(){
        return firstName;
    }
    
    public String getType(){
        return type;
    }
    
    public static int getNextId() { return nextId; }
    public static void setNextId(int i) { nextId = i; }
    
    public void addToCourseList(Course c){
        courses.add(c);
        
    }
    
    public void addToSubmissionList(Submission s){
        submissions.add(s);
        
    }
    
    public LinkedList<Course> getCourse(){
        return courses;
    }
    public LinkedList<Submission> getSubmission(){
        return submissions;
    }
    
    public User(){
        userId = nextId++; 
        courses= new LinkedList<Course>();
    }
    
    public User(String firstName, String lastName, String type, int userCode, String username, String password){
        courses= new LinkedList<Course>();
        submissions= new LinkedList<Submission>();
        userId = nextId++;
        this.username=username;
        this.password=password;
        this.firstName= firstName;
        this.lastName = lastName;
        this.type= type;
        this.userCode = userCode;
        
    }
    
    
    
    
    
}
