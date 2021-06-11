package com.prabhu.collectionPkg;

import java.util.ArrayDeque;
import java.util.Deque;

public class BookArrayDeque {

	public static void main(String[] args) {
		   Deque<Book> set=new ArrayDeque<Book>();    
		    //Creating Books    
		    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);    
		    Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
		    Book b3=new Book(103,"Operating System","Galvin","Wiley",6);    
		    //Adding Books to Deque   
		    set.add(b1);    
		    set.add(b2);    
		    set.add(b3);    
		    //Traversing ArrayDeque  
		    for(Book b:set){    
		    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);    
		    }    

	}

}
