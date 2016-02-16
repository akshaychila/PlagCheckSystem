/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plagchecksystem;

import java.awt.Frame;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JFrame;

/**
 *
 * @author akshaychila
 */
public class PlagCheckSystem {
   
    /**
     * @param args the command line arguments
     */
    
    private static LinkedList<User> users;
    private static LinkedList<Course> courses;
    private static LinkedList<Assignment> assignments;
    private static LinkedList<Submission> submissions;
    
    
    public PlagCheckSystem(){
        users = new LinkedList<User>();
        courses = new LinkedList<Course>();
        assignments = new LinkedList<Assignment>();
        submissions = new LinkedList<Submission>();
    }
    
    
    public static LinkedList<User> getUsers() {return users;}
    
    
    public static void setUser(LinkedList<User> userList){
       users = userList;
    }
    
    public static void setCourse(LinkedList<Course> courseList){
       courses = courseList;
    }
    
    public static void setAssignment(LinkedList<Assignment> assList){
       assignments = assList;
    }
    
    public static void setSubmission(LinkedList<Submission> subList){
       submissions = subList;
    }
    
    public static User searchUser(String uname, String pword){
        for (User user : users) {
            if ((user.getUserName().equals(uname)) && (user.getPassword().equals(pword))) {
                return user;
            }
        }
        return null;
       
    }
    
    public static User searchUser(String uname){
        for (User user : users) {
            if (user.getUserName().equals(uname)) {
                return user;
            }
        }
        return null;
       
    }
    
    public static LinkedList<Course> getCourses() {return courses;}
    
    public static Course searchCourse(String cname){
        for (Course course : courses) {
            if (course.getCourseName().equals(cname)) {
                return course;
            }
        }
        return null;
       
    }
    
    public static Assignment searchAssignment(String aname){
        for (Assignment ass : assignments) {
            if (ass.getAssignmentName().equals(aname)) {
                return ass;
            }
        }
        return null;
       
    }
    
    public static Submission searchSubmission(Assignment ass, User user){
        for (Submission sub : submissions) {
            if ((sub.getAssignment().equals(ass))&&(sub.getUser().equals(user))) {
                return sub;
            }
        }
        return null;
       
    }

    public static void addToCourseList(Course course){
        courses.add(course);
    }
    
    public static void addCourse(String cName, String cDur, int cred){
        Course c = new Course(cName, cDur, cred);
        addToCourseList(c);
        LoginGUI.getUser().addToCourseList(c);
    }
    
    
    
    public static void register(User user){
        users.add(user);
    }
    
    public static void addUser(String fname, String lname, String type, int uCode, String uname, String pword){
        User u = new User(fname,lname,type,uCode,uname,pword);
        register(u);
    }
    
    public static LinkedList<Assignment> getAssignment() {return assignments;}
    
    public static void addToAssignmentList(Assignment assignment){
        assignments.add(assignment);
    }
    
    public static void addAssignment(Course c, String assName, String aDur, double tMarks){
        Assignment a = new Assignment(c, assName, aDur, tMarks);
        addToAssignmentList(a);
        c.addToAssignmentList(a);
    }
    
    public static LinkedList<Submission> getSubmissions() {return submissions;}
    
    public static void addToSubmissionList(Submission sub){
        submissions.add(sub);
    }
    
    public static void addSubmission(User u, Assignment ass, String text){
        Submission s = new Submission(u, ass, text);
        addToSubmissionList(s);
        ass.addToSubmissionsList(s);
        u.addToSubmissionList(s);
    }
    
    public static double getSimilarity(Submission s1, Submission s2) {
        String a = s1.getSubmissionText();
        String b = s2.getSubmissionText();
        int d = editDistance(a,b);
        int len = a.length() + b.length();
         
        return (1 - (float)d / len)*100;
    }
 
    public static int editDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        int d[][] = new int[n+1][m+1];
         
        for(int i = 0; i <= n; i++)
            d[i][0] = i;
         
        for(int j = 1; j <= m; j++)
            d[0][j] = j;
             
             
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++) {
                int cost;
                if(s.charAt(i-1) == t.charAt(j-1))
                    cost = 0;
                else
                    cost = 1;
                     
                d[i][j] = Math.min( d[i-1][j]+1,            
                    Math.min(       d[i][j-1]+1,            
                                    d[i-1][j-1]+cost ) );   
        }
         
        return d[n][m];
    }
    
    public static void disposeAll(){
    for(Frame jframe : JFrame.getFrames()){
        jframe.dispose();
        
    }
     LoginGUI log1 = new LoginGUI();
     log1.setVisible(true);
    }
         
    
    public static void main(String[] args) {
        // TODO code application logic here
        PlagCheckSystem ps = new PlagCheckSystem();
        LoginGUI log1 = new LoginGUI();
        log1.setVisible(true);
    }
    
}
