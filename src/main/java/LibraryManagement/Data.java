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

        try ( BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
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

    public ArrayList<Readers> loadReaders() throws FileNotFoundException {

        FileInputStream file = new FileInputStream("readers.txt");
        String strline = "";
        ArrayList<Readers> readers = new ArrayList<Readers>();

        try ( BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
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

    public boolean searchBookByTitle(ArrayList<Books> book, String title) {
        boolean found = false;
        for (Books b : book) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println(b);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Book not found");
        }

        return found;

    }

    public boolean searchBookByAuthor(ArrayList<Books> book, String author) {
        boolean found = false;
        for (Books b : book) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Author not found");
        }

        return found;

    }

    public boolean searchReaderByName(ArrayList<Readers> reader, String name) {
        boolean found = false;
        for (Readers r : reader) {
            if (r.getName().equalsIgnoreCase(name)) {
                System.out.println(r);
                return found = true;
            }
        }
        if (found == false) {
            System.out.println("Reader not found");
            return found;
        }
        return found;
    }

    
    
    public boolean searchReaderById(ArrayList<Readers> reader, int id) {
        boolean found = false;
        for (Readers r : reader) {
            if (r.getId() == id) {
                System.out.println(r);
                return found = true;
            }
        }
        if (found == false) {
            System.out.println("Reader not found");
            return found;
        }
        return found;
    }

    public ArrayList<Books> sortBooksByTitle(ArrayList<Books> books) {

        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() - 1; j++) {
                if (books.get(j).getTitle().compareTo(books.get(j +1).getTitle()) > 0) {
                    Books temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
        return books;
    }

    public ArrayList<Books> sortBooksById(ArrayList<Books> books) {
        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() - 1; j++) {
                if (books.get(j).getId() > books.get(j + 1).getId()) {
                    Books temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
        return books;
    }

    public ArrayList<Readers> sortReadersById(ArrayList<Readers> readers) {
        for (int i = 0; i < readers.size(); i++) {
            for (int j = 0; j < readers.size() - 1; j++) {
                if (readers.get(j).getId() > readers.get(j + 1).getId()) {
                    Readers temp = readers.get(j);
                    readers.set(j, readers.get(j + 1));
                    readers.set(j + 1, temp);
                }
            }
        }
        return readers;
    }

}
