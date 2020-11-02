/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author altemir
 */
public class Data { 
    public ArrayList<Books> loadBooks() throws FileNotFoundException {
        
        FileInputStream file = new FileInputStream("books.txt");
	String strline = "";
        ArrayList<Books> books = new ArrayList<Books>();
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
			strline = br.readLine();
			while (strline != null) {
				String[] parts = strline.split(",");
				books.add(new Books(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3])));
				
				strline = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
                }
        return books;
        }
    
    public ArrayList<Readers> loadReaders() throws FileNotFoundException{
         
        FileInputStream file = new FileInputStream("readers.txt");
	String strline = "";
        ArrayList<Readers> readers = new ArrayList<Readers>();
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
			strline = br.readLine();
			while (strline != null) {
				String[] parts = strline.split(",");
				readers.add(new Readers(Integer.parseInt(parts[0]), parts[1], parts[2]));
				
				strline = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
                }
        return readers;
        
    }
    
    public boolean searchBookByTitle(ArrayList <Books> book, String info){
        boolean found = false;
        for(Books b: book){
           if(b.getTitle().equalsIgnoreCase(info)){
               System.out.println(b);
              found = true;
           }  
        }
        if(found== false){
            System.out.println("Book not found");
        }
        
        return found;
       
    }
    public boolean searchByAuthor(ArrayList <Books> book, String info){
        boolean found = false;
        for(Books b: book){
           if(b.getAuthor().equalsIgnoreCase(info)){
               System.out.println(b);
              found = true;
           }  
        }
        if(found== false){
            System.out.println("Author not found");
        }
        
        return found;
       
    }
    
    
   
}
