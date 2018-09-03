package com.hepicar.samplemvp.login

import com.hepicar.samplemvp.modul.Credential
import com.hepicar.samplemvp.modul.CredentialCallback
import com.hepicar.samplemvp.model.UserAdmin

interface LoginView{
    fun showLoading()
    fun hideLoading()
    fun loginSucceed(userAdmin:UserAdmin)
    fun loginFailed(message:String)
}

class LoginPresenter constructor(view: LoginView){
    val view:LoginView = view

    fun login(npm:String,password:String){
        view.showLoading()
        Credential.login("123.123.123","password",object : CredentialCallback {
            override fun onSucceed(accessToken: String) {
                val userAdmin = UserAdmin("joko","url.com/pic.png",accessToken)
                view.hideLoading()
                view.loginSucceed(userAdmin)
            }

            override fun onFailed(reason: String) {
                view.hideLoading()
                view.loginFailed(reason)
            }

        })
    }
}
