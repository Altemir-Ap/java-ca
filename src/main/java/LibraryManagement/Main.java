/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;

import java.io.FileNotFoundException;
import java.util.ArrayList;

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
      
        
       System.out.println(data.searchBookByTitle(myBooks, "Game Of Thrones"));
        
    }
    
}
