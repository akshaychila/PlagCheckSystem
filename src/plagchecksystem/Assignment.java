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
public class Assignment implements Serializable{
    private int assignmentId;
    private String assignmentName;
    private String aDuration;
    private double totalMarks;
    private static int nextId = 2000;
    private Course course;
    
    private LinkedList<Submission> submissions;
    
    public static int getNextId() { return nextId; }
    public static void setNextId(int i) { nextId = i; }
    
    public int getId(){
        return assignmentId;
    }
    
    public String getAssignmentName(){
        return assignmentName;
    }
    
    public String getADuration(){
        return aDuration;
    }
    
    public double getTotalMarks(){
        return totalMarks;
    }
    
    public LinkedList<Submission> getSubmissions() {return submissions;}
    
    public void addToSubmissionsList(Submission sub){
        submissions.add(sub);
    }    
    
    public Course getCourse(){
        return course;
    }
    
   

    
    
    public Assignment(Course co, String assignmentName, String aDuration, double totalMarks){
        submissions = new LinkedList<Submission>();
        course = co;
        assignmentId=nextId++;
        this.assignmentName=assignmentName;
        this.aDuration=aDuration;
        this.totalMarks= totalMarks;
    }
    public Assignment(){ 
        submissions = new LinkedList<Submission>();
        assignmentId= nextId++;}
    
    
    
}
