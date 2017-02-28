package library;

import library.model.Book;
import library.model.CD;
import library.model.DVD;

import java.util.ArrayList;


interface ILibrary {

    ArrayList<Book> putBooks(ArrayList<Book> books);

    ArrayList<DVD> putDvds(ArrayList<DVD> dvds);

    ArrayList<CD> putCDs(ArrayList<CD> cds);

    boolean isOpen(int hour);
}