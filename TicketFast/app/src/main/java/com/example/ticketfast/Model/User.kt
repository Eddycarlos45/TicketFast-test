package com.example.ticketfast.Model

public class User {
    var id:Int = 0
    var name:String? = null
    var email:String? = null
    var password:String? = null

    constructor(id: Int, name: String?, email: String?, password: String?) {
        this.id = id
        this.name = name
        this.email = email
        this.password = password
    }
}