package com.example.ticketfast.Model

class Ticket {

    constructor(idTicket:Int,name:String?,date:String?,local:String?){
        this.name = name
        this.date = date
        this.local = local
        this.idTicket = idTicket
    }

    constructor(){}

    var name:String? = null
    var date:String? = null
    var local:String? = null
    var idTicket:Int = 0

}
