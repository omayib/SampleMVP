package com.hepicar.samplemvp.login

import android.app.Application
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import com.hepicar.samplemvp.R
import com.hepicar.samplemvp.appilcation.LibraryApplication
import com.hepicar.samplemvp.dashboard.DashboardActivity
import com.hepicar.samplemvp.model.UserAdmin

class LoginActivity : AppCompatActivity(), LoginView {

    var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLogin = findViewById<Button>(R.id.buttonLogin)

        presenter = LoginPresenter(this)

        btnLogin.setOnClickListener(View.OnClickListener {
            presenter!!.login("123","password")
        })
    }
    override fun showLoading() {
        println("show loading...")
    }

    override fun hideLoading() {
        println("show loading...")
    }

    override fun loginSucceed(userAdmin: UserAdmin) {
        println("login succeed: "+userAdmin.toString())
        var app: LibraryApplication = this.application as LibraryApplication
        app.startLibrary(userAdmin)
        startActivity(Intent(this,DashboardActivity::class.java))
    }

    override fun loginFailed(message: String) {
        println("login failed "+message)
    }

}
