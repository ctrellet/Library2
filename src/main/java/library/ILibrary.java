package library;

import library.model.Book;
import library.model.CD;
import library.model.DVD;

import java.util.ArrayList;
import java.util.List;


interface ILibrary {

    List<Book> putBooks(List<Book> books);

    List<DVD> putDvds(List<DVD> dvds);

    List<CD> putCDs(List<CD> cds);

    boolean isOpen(int hour);
}