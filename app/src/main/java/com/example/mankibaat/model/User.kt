package com.example.mankibaat.model

import io.realm.RealmObject


open class User : RealmObject{
 var name: String = ""
  var email: String = ""
    var phone: String = ""
   var pass: String = ""
    var gender :String = ""
    var uid : String =""

    constructor(name: String, gender: String, email: String, phone: String, pass: String,uid : String) {
        this.name = name
        this.email = email
        this.gender = gender
        this.phone = phone
        this.pass = pass
        this.uid = uid
    }
    constructor()
}