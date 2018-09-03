package com.hepicar.samplemvp.modul

import com.hepicar.samplemvp.model.Book
import com.hepicar.samplemvp.model.Member
import com.hepicar.samplemvp.model.UserAdmin

class BookLibrary constructor(admin: UserAdmin){
    val authorizedAdmin:UserAdmin = admin
    val bookCollection: ArrayList<Book> = ArrayList()
    val members:ArrayList<Member> = ArrayList()

    fun addCollection(book: Book, stock:Int){
        bookCollection.add(book)
        book.stock = book.stock + stock
    }

    fun createMember(name:String): Member{
        val member = Member(name)
        members.add(member)
        return member
    }

    fun findMember(name: String): Member? {
        for(member in members){
            if (member.name == name){
                return  member
            }
        }
        return null
    }
    fun findBook(title: String): Book? {
        for(book in bookCollection){
            if (book.title== title){
                return  book
            }
        }
        return null
    }
}