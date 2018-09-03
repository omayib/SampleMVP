package com.hepicar.samplemvp.model

class Book(var title:String,var author:String){
    var stock:Int = 0
        get() = field
        set(value) {
            field += value
        }

    override fun toString(): String {
        return "Book(title='$title', author='$author', stock='$stock')"
    }



    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        return title.hashCode()
    }


}