package com.prabhu.collectionPkg;

import java.util.LinkedHashMap;
import java.util.Map;

import com.prabhu.beans.Book;

public class BookLinkedHashMap {

	public static void main(String[] args) {
		  //Creating map of Books    
	    Map<Integer,Book> map=new LinkedHashMap<Integer,Book>();    
	    //Creating Books    
	    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);    
	    Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
	    Book b3=new Book(103,"Operating System","Galvin","Wiley",6);    
	    //Adding Books to map   
	    map.put(2,b2);  
	    map.put(1,b1);  
	    map.put(3,b3);  
	      
	    //Traversing map  
	    for(Map.Entry<Integer, Book> entry:map.entrySet()){    
	        int key=entry.getKey();  
	        Book b=entry.getValue();  
	        System.out.println(key+" Details:");  
	        System.out.println(b.getId()+" "+b.getName()+" "+b.getAuthor()+" "+b.getPublisher()+" "+b.getQuantity());
	    }    

	}

}
