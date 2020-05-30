package com.example.ecommerceappkotlin

class EProducts {
    var id: Int
    var name: String
    var price: Int
    var productPic: Int  //from the resource the picture is identified by integer values
    constructor(id:Int,name:String,price:Int,productPic:Int){
        this.id=id
        this.name=name
        this.price=price
        this.productPic=productPic
    }
}