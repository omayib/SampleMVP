package com.hepicar.samplemvp.dashboard

import com.hepicar.samplemvp.modul.BookLibrary
import com.hepicar.samplemvp.model.Book
import com.hepicar.samplemvp.model.Member

interface DashboardView{
    fun onBooksLoaded(availableBooks:ArrayList<Book>)
    fun onFailure(message:String)
    fun showProgress()
    fun hideProgress()
    fun onBookAdded(book: Book)
    fun onMemberCreated(member:Member)
    fun onBorrowingSuceeded()
    fun onBorrowingFailed(message: String)
}

class DashboardPresenter constructor(view: DashboardView, bookLibrary: BookLibrary){
    var bookLibrary = bookLibrary
    var view = view

    fun showAvailableBooks(){
        this.view.showProgress()
        this.view.onBooksLoaded(this.bookLibrary.bookCollection)
        this.view.hideProgress()
    }

    fun addBook(book:Book,stock:Int){
        this.bookLibrary.addCollection(book,stock)
        this.view.onBookAdded(book)
    }

    fun createMember(name:String){
        val member = this.bookLibrary.createMember(name)
        this.view.onMemberCreated(member)
    }

    fun borrowBooks(name:String,title: String){
        var member = this.findMember(name)
        if(member == null){
            this.view.onBorrowingFailed("member not found")
            return
        }
        val book = this.bookLibrary.findBook(title)
        if(book == null){
            this.view.onBorrowingFailed("Buku tida ditemukan")
            return
        }
        member?.borrow(book)
        this.view.onBorrowingSuceeded()
    }

    fun findMember(name:String):Member?{
        val member = this.bookLibrary.findMember(name)
        return member
    }
}