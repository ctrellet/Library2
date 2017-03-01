package library;

import library.model.Book;
import library.model.CD;
import library.model.DVD;
import library.model.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<Book> result = library.putBooks(books);
        //assert
        assertEquals(2, result.size());
    }

    @Test
    public void putCds_with_two_cds() {
        //set
        Library library = new Library();
        CD cd = new CD("cd", 120);
        CD cd1 = new CD("cd1", 120);
        List<CD> cds = new ArrayList<>();
        cds.add(cd);
        cds.add(cd1);
        //test
        List<CD> result = library.putCDs(cds);
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
        List<DVD> result = library.putDvds(dvds);
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
        List<DVD> result = library.putDvds(dvds);
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
        List<DVD> result = library.putDvds(newDvds);
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
        List<DVD> result = library.putDvds(dvds);
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

    @Test
    public void isOpen_at_1pm_with_localTime_attribut() {
        //set
        Library library = new Library(1);
        //test
        boolean result = library.isOpen();
        //assert
        assertTrue(result);
    }

    @Test
    public void isOpen_at_10pm_with_localTime_attribut() {
        //set
        Library library = new Library(10);
        //test
        boolean result = library.isOpen();
        //assert
        assertFalse(result);
    }

    @Test
    public void putBook_with_two_books_when_library_closed() {
        //set
        Library library = new Library(10);
        Book book1 = new Book("book1", 100);
        Book book2 = new Book("book2", 150);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        //test
        List<Book> result = library.putBooks(books);
        //assert
        assertEquals(2, result.size());
    }

    @Test
    public void putCds_with_two_cds_when_library_closed() {
        //set
        Library library = new Library(10);
        CD cd = new CD("cd", 120);
        CD cd1 = new CD("cd1", 120);
        List<CD> cds = new ArrayList<>();
        cds.add(cd);
        cds.add(cd1);
        //test
        List<CD> result = library.putCDs(cds);
        //assert
        assertEquals(2, result.size());
    }

    @Test
    public void putDvds_with_two_dvds_when_library_closed() {
        //set
        Library library = new Library(10);
        DVD dvd = new DVD("dvd", 120, Movie.ACTION, true);
        DVD dvd1 = new DVD("dvd1", 100, Movie.HORROR, false);
        ArrayList<DVD> dvds = new ArrayList<>();
        dvds.add(dvd);
        dvds.add(dvd1);
        //test
        List<DVD> result = library.putDvds(dvds);
        //assert
        assertEquals(2, result.size());
    }

    @Test
    public void putDVDs_with_four_dvds_when_library_closed() {
        //set
        Library library = new Library(10);
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
        List<DVD> result = library.putDvds(dvds);
        //assert
        assertEquals(4, result.size());
    }

    @Test
    public void putBook_test_shippingDay() {
        //set
        Library library = new Library();
        Book book1 = new Book("book1", 100);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        //test
        List<Book> result = library.putBooks(books);
        Book resultBook = result.get(0);
        //assert
        assertEquals(1, resultBook.getShippingDay());
    }

    @Test
    public void putCd_test_shippingDay() {
        //set
        Library library = new Library();
        CD cd = new CD("cd", 120);
        List<CD> cds = new ArrayList<>();
        cds.add(cd);
        //test
        List<CD> result = library.putCDs(cds);
        CD resultCD = result.get(0);
        //assert
        assertEquals(3, resultCD.getShippingDay());
    }

    @Test
    public void putDvd_test_shippingDay_with_HORROR() {
        //set
        Library library = new Library();
        DVD dvd = new DVD("dvd", 120, Movie.HORROR, false);
        ArrayList<DVD> dvds = new ArrayList<>();
        dvds.add(dvd);
        //test
        List<DVD> result = library.putDvds(dvds);
        DVD resultDVD = result.get(0);
        //assert
        assertEquals(1, resultDVD.getShippingDay());
    }

    @Test
    public void putDvd_test_shippingDay_with_3D() {
        //set
        Library library = new Library();
        DVD dvd = new DVD("dvd", 120, Movie.ACTION, true);
        ArrayList<DVD> dvds = new ArrayList<>();
        dvds.add(dvd);
        //test
        List<DVD> result = library.putDvds(dvds);
        DVD resultDVD = result.get(0);
        //assert
        assertEquals(3, resultDVD.getShippingDay());
    }

    @Test
    public void putDvd_test_shippingDay_other() {
        //set
        Library library = new Library();
        DVD dvd = new DVD("dvd", 120, Movie.MUSICAL, false);
        ArrayList<DVD> dvds = new ArrayList<>();
        dvds.add(dvd);
        //test
        List<DVD> result = library.putDvds(dvds);
        DVD resultDVD = result.get(0);
        //assert
        assertEquals(2, resultDVD.getShippingDay());
    }


}