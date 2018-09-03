package com.hepicar.samplemvp;

import com.hepicar.samplemvp.model.Book;
import com.hepicar.samplemvp.model.Member;
import com.hepicar.samplemvp.model.UserAdmin;
import com.hepicar.samplemvp.modul.BookLibrary;
import com.hepicar.samplemvp.modul.Credential;
import com.hepicar.samplemvp.modul.CredentialCallback;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void login_is_succeed(){
        /*
        Credential.login("123.123.123","password", callback)
        */
        Credential.INSTANCE.login("123.123.123", "password", new CredentialCallback() {
            @Override
            public void onSucceed(@NotNull String accessToken) {
                assertEquals(accessToken,"xyztoken");
            }

            @Override
            public void onFailed(@NotNull String reason) {
                assertEquals("salah password",reason);
            }
        });
    }

    @Test
    public void add_book_into_collection(){
        /*
        var harryPotter = Book("Harry Potter","J.K. Rawling")
        var liveCodingAndroid = Book("Live coding Android","Akbarul")

        var bookLibrary = BookLibrary()
        bookLibrary.addCollection(harryPotter,2)
        bookLibrary.addCollection(liveCodingAndroid,3)

        var availableBooks = bookLibrary.listAvailableBook(harryPotter)
        assertTrue(availableBooks.contains(harryPotter))
         */
        Book harryPotter = new Book("Harry Potter","J.K. Rawling");
        Book liveCodingAndroid = new Book("Live Coding Android","Akbarul");
        UserAdmin admin = new UserAdmin("abc","url","xyztoken");
        BookLibrary bookLibrary = new BookLibrary(admin);
        bookLibrary.addCollection(harryPotter,2);
        bookLibrary.addCollection(liveCodingAndroid,3);

        ArrayList<Book> availableBooks = bookLibrary.getBookCollection();
        System.out.println(availableBooks.toString());
        assertTrue(availableBooks.contains(harryPotter));

    }

    @Test
    public void create_member(){
        /*
        var bookLibrary = BookLibrary()
        Member agung = bookLibrary.createMember("Agung")

        assertEquals("agung",agung.name)
         */

        UserAdmin admin = new UserAdmin("abc","url","xyztoken");
        BookLibrary bookLibrary = new BookLibrary(admin);

        Member cahyo = bookLibrary.createMember("Cahyo");

        ArrayList<Member> members = bookLibrary.getMembers();
        System.out.println(members.toString());
        assertTrue(members.contains(cahyo));
    }

    @Test
    public void member_borrowing_book(){
        /*
        var bookLibrary = BookLibrary()
        var liveCodingAndroid = Book("Live coding Android","Akbarul")

        Member agung = bookLibrary.createMember("Agung")
        agung.borrow(liveCodingAndroid)
        var agungBooks = agung.listBorrowedBook
        assertTrue(agungBooks.contains(liveCodingAndroid))

         */
        Book harryPotter = new Book("Harry Potter","J.K. Rawling");

        UserAdmin admin = new UserAdmin("abc","url","xyztoken");
        BookLibrary bookLibrary = new BookLibrary(admin);

        bookLibrary.addCollection(harryPotter,2);

        Member cahyo = bookLibrary.createMember("Cahyo");

        cahyo.borrow(harryPotter);
        assertTrue(cahyo.getBorrowedBooks().contains(harryPotter));
    }
}