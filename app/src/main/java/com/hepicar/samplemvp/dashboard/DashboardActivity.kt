package com.hepicar.samplemvp.dashboard

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.hepicar.samplemvp.modul.BookLibrary
import com.hepicar.samplemvp.R
import com.hepicar.samplemvp.appilcation.LibraryApplication
import com.hepicar.samplemvp.model.Book
import com.hepicar.samplemvp.model.Member

class DashboardActivity: AppCompatActivity(), DashboardView {



    var app: LibraryApplication? = null
    lateinit var presenter:DashboardPresenter
    lateinit var bookLibrary: BookLibrary

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)

        val buttonAddBook = findViewById<Button>(R.id.buttonAddBook)
        val buttonShowBook = findViewById<Button>(R.id.buttonShowBook)
        val buttonCreateMember = findViewById<Button>(R.id.buttonCreateMember)
        val buttonBorrowBook= findViewById<Button>(R.id.buttonBorrowBook)

        app = this.application as LibraryApplication?
        bookLibrary = app!!.bookLibrary!!

        presenter = DashboardPresenter(this, bookLibrary!!)

        buttonAddBook.setOnClickListener(View.OnClickListener {
            val bookAndroid = Book("Live Coding Android","Akbarul Huda")
            presenter.addBook(bookAndroid,2)
        })
        buttonShowBook.setOnClickListener(View.OnClickListener {
            presenter.showAvailableBooks()
        })
        buttonCreateMember.setOnClickListener(View.OnClickListener {
            presenter.createMember("Agung")
        })
        buttonBorrowBook.setOnClickListener(View.OnClickListener {
            presenter.borrowBooks("Agung","Live Coding Android")
        })

    }
    override fun onBooksLoaded(availableBooks: ArrayList<Book>) {
        println("on books loaded ${availableBooks.toString()}")
    }

    override fun onFailure(message: String) {
        println("on failure ${message}")

    }

    override fun showProgress() {
        println("show progress")
    }

    override fun hideProgress() {
        println("hide progress")
    }

    override fun onBookAdded(book: Book) {
        println("on book added ${book.toString()} ")
    }
    override fun onMemberCreated(member: Member) {
        println("on member created ${member.toString()}")
    }

    override fun onBorrowingSuceeded() {
        println("on borrowing succeeded")
    }

    override fun onBorrowingFailed(message: String) {
        println("on borrowing faelid ${message}")
    }
}