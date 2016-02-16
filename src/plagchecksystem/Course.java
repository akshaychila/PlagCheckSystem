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
public class Course implements Serializable{
    private int courseId;
    private String courseName;
    private String cDuration;
    private int credits;
    private static int nextId = 1000; 
    
    
    private LinkedList<User> users;
    private LinkedList<Assignment> assignments;
    
    public static int getNextId() { return nextId; }
    public static void setNextId(int i) { nextId = i; }
    
    public int getId(){
        return courseId;
    }
    
    public String getCourseName(){
        return courseName;
    }
    
    public String getCDuration(){
        return cDuration;
    }
    
    public int getCredits(){
        return credits;
    }
     public void addToAssignmentList(Assignment ass){
         assignments.add(ass);
     }
    
    
    public void addToUserList(User user){
        users.add(user);
    }
    
    public LinkedList<Assignment> getAssignment(){
        return assignments;
    }
    
    public LinkedList<User> getUser(){
        return users;
    }
    
    
    
    public Course(String courseName, String cDuration, int credits){
        
        users = new LinkedList<User>();
        assignments = new LinkedList<Assignment>();
        courseId=nextId++;
        this.courseName=courseName;
        this.cDuration=cDuration;
        this.credits= credits;
    }
    public Course(){ 
        assignments = new LinkedList<Assignment>();
        users = new LinkedList<User>();
        courseId= nextId++;}
    
    
    
}
