package com.hepicar.samplemvp.appilcation

import android.app.Application
import com.hepicar.samplemvp.modul.BookLibrary
import com.hepicar.samplemvp.model.UserAdmin

class LibraryApplication: Application() {
    var bookLibrary: BookLibrary? = null

    fun startLibrary(userAdmin: UserAdmin){
        bookLibrary = BookLibrary(userAdmin)
    }



}