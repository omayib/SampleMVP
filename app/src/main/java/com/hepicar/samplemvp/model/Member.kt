package com.hepicar.samplemvp.model

class Member(var name:String){
    private var borrowedBooks:ArrayList<Book> = ArrayList()

    fun borrow(book: Book){
        borrowedBooks.add(book)
    }

    fun getBorrowedBooks():ArrayList<Book>{
        return this.borrowedBooks
    }

    override fun toString(): String {
        return "Member(name='$name', borrowedBooks=$borrowedBooks)"
    }


}