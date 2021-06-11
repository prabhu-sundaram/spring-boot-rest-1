package com.prabhu.collectionPkg;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentArrayList {

	public static void main(String[] args) {
 	      System.out.println("---------User-defined class objects in Java ArrayList----------");
          
          //Creating user-defined class objects  
          Student s1=new Student(101,"Sonoo",23);  
          Student s2=new Student(102,"Ravi",21);  
          Student s3=new Student(103,"Hanumat",25);  
          //creating arraylist  
          ArrayList<Student> al2=new ArrayList<Student>();  
          al2.add(s1);//adding Student class object  
          al2.add(s2);  
          al2.add(s3);  
          //Getting Iterator  
          Iterator itr4=al2.iterator();  
          //traversing elements of ArrayList object  
          while(itr4.hasNext()){  
            Student st=(Student)itr4.next();  
            System.out.println(st.rollno+" "+st.name+" "+st.age);  
          }        

	}

}
