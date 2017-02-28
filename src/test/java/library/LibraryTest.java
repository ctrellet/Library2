package library;

import library.model.Book;
import library.model.CD;
import library.model.DVD;
import library.model.Movie;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class LibraryTest {

    @Test
    public void putBook_with_two_books() {
        //set
        Library library = new Library();
        Book book1 = new Book("book1", 100);
        Book book2 = new Book("book2", 150);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        //test
        ArrayList<Book> result = library.putBooks(books);
        //assert
        assertEquals(2, result.size());
    }

    @Test
    public void putCds_with_two_cds() {
        //set
        Library library = new Library();
        CD cd = new CD("cd", 120);
        CD cd1 = new CD("cd1", 120);
        ArrayList<CD> cds = new ArrayList<>();
        cds.add(cd);
        cds.add(cd1);
        //test
        ArrayList<CD> result = library.putCDs(cds);
        //assert
        assertEquals(2, result.size());
    }

    @Test
    public void putDvds_with_two_dvds() {
        //set
        Library library = new Library();
        DVD dvd = new DVD("dvd", 120, Movie.ACTION, true);
        DVD dvd1 = new DVD("dvd1", 100, Movie.HORROR, false);
        ArrayList<DVD> dvds = new ArrayList<>();
        dvds.add(dvd);
        dvds.add(dvd1);
        //test
        ArrayList<DVD> result = library.putDvds(dvds);
        //assert
        assertEquals(2, result.size());
    }

    @Test
    public void putDVDs_with_four_dvds() {
        //set
        Library library = new Library();
        DVD dvd = new DVD("dvd", 120, Movie.ACTION, true);
        DVD dvd1 = new DVD("dvd1", 121, Movie.FUN, true);
        DVD dvd2 = new DVD("dvd2", 122, Movie.MUSICAL, false);
        DVD dvd3 = new DVD("dvd3", 123, Movie.HORROR, false);
        ArrayList<DVD> dvds = new ArrayList<>();
        dvds.add(dvd);
        dvds.add(dvd1);
        dvds.add(dvd2);
        dvds.add(dvd3);
        //test
        ArrayList<DVD> result = library.putDvds(dvds);
        //assert
        assertEquals(0, result.size());
    }

    @Test
    public void putDvds_with_one_dvd_already_on_library_and_one_double_dvd_input() {
        //set
        Library library = new Library();
        DVD dvd = new DVD("dvd", 120, Movie.ACTION, true);
        ArrayList<DVD> dvds = new ArrayList<>();
        dvds.add(dvd);
        library.putDvds(dvds);

        DVD dvd2 = new DVD("dvd2", 122, Movie.MUSICAL, false);
        ArrayList<DVD> newDvds = new ArrayList<>();
        newDvds.add(dvd2);
        newDvds.add(dvd);
        //test
        ArrayList<DVD> result = library.putDvds(newDvds);
        //assert
        assertEquals(1, result.size());
        DVD dvdActual = result.get(0);
        assertEquals("dvd", dvdActual.getTitle());
    }

    @Test
    public void putDvds_with_two_dvds_and_same_content() {
        //set
        Library library = new Library();
        DVD dvd = new DVD("dvd", 120, Movie.ACTION, true);
        DVD dvd1 = new DVD("dvd", 120, Movie.ACTION, true);
        ArrayList<DVD> dvds = new ArrayList<>();
        dvds.add(dvd);
        dvds.add(dvd1);
        //test
        ArrayList<DVD> result = library.putDvds(dvds);
        //assert
        assertEquals(0, result.size());
    }

    @Test
    public void isOpen_at_1pm() {
        //set
        Library library = new Library();
        //test
        boolean result = library.isOpen(1);
        //assert
        assertTrue(result);
    }

    @Test
    public void isOpen_at_10pm() {
        //set
        Library library = new Library();
        //test
        boolean result = library.isOpen(10);
        //assert
        assertFalse(result);
    }

}