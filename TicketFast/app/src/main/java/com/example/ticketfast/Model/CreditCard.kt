package com.example.ticketfast.Model

class CreditCard {
    var name:String? = null
    var month:String? = null
    var year:String? = null
    var cvv:String? = null
    var parcels:Int = 0
    var error:String? = null
    var token:String? = null

    constructor(name: String?, month: String?, year: String?, cvv: String?, parcels: Int, error: String?, token: String?) {
        this.name = name
        this.month = month
        this.year = year
        this.cvv = cvv
        this.parcels = parcels
        this.error = error
        this.token = token
    }
    constructor(){}
}