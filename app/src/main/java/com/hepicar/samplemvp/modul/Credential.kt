package com.hepicar.samplemvp.modul
interface CredentialCallback{
    fun onSucceed(accessToken:String)
    fun onFailed(reason:String)
}
object Credential{
    fun login(npm:String,password:String, callback: CredentialCallback){
        if(npm.equals("123.123.123")&&password.equals("password")){
            callback.onSucceed("xyztoken")
        }else{
            callback.onFailed("salah password")
        }
    }
}