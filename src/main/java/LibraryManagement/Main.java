/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author altemir
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
      
        Data data = new Data();
        
       ArrayList<Books> myBooks = data.loadBooks();
       ArrayList<Readers> myReaders = data.loadReaders();
       Scanner sc = new Scanner(System.in);
       String value;
       do{
         
           System.out.println("----- Library System ------");
           System.out.println("---------------------------");
           System.out.println("1- Search Book By Author ");
           System.out.println("2- Search Book By Title");
           System.out.println("3- List Book By Author -- in construction");
           System.out.println("4- List Book By Title -- in construction");
           System.out.println("5- Search Reader by Name");
           System.out.println("6- Search Reader by Id");
           System.out.println("7- List Reader By Id");
           System.out.println("8- List Reader By Name -- in construction");
           System.out.println("------- -------");
           System.out.println("Select an menu option");
           try{
               int input = Integer.parseInt(sc.next());
               switch(input){
                   case 1:
                       System.out.println("Type an author name");
                       String author = sc.nextLine();                      
                       System.out.println(data.searchBookByAuthor(myBooks, author));
                       break;
                   case 2:
                       System.out.println("Type a book title");
                       String title = sc.nextLine();                      
                       System.out.println(data.searchBookByTitle(myBooks, title));
                       break;
                   case 3:
                       System.out.println("In construction");
                       break;
                   case 4:
                       System.out.println("In construction");
                       break;
                   case 5: 
                       System.out.println("Type a reader name");
                       String readerName = sc.nextLine();                      
                       System.out.println(data.searchReaderByName(myReaders, readerName));
                       break;
                   case 6:
                       break;
                       
                       
               }
           }catch(NumberFormatException e){
               System.out.println(e);
           }
       }while(true);
  
        
        
 
    }
    
}   
