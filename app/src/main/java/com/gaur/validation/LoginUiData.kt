package com.gaur.validation

import kotlin.reflect.KProperty

class LoginUiData {

     var name: String?  by NameDelegation()

     var email: String? = null
        set(value) {
            if (value != null && value.length > 6 && value.contains("@")) {
                field = value
            }
        }

     var password: String? = null
        set(value) {
            if (value != null && value.length > 4) {
                field = value
            }
        }

    constructor(name: String, email: String, password: String) {
        this.name = name
        this.email = email
        this.password = password
    }

    val isvalid:Boolean
    get() = this.name!=null && this.password !=null && this.email !=null



}


class NameDelegation(){
    private var tempString:String?=null

    operator fun setValue(thisRef : LoginUiData, property:KProperty<*>,value:String?){
        if (value != null && value.isNotEmpty() && value.length > 6) {
            tempString = value
        }
    }

    operator fun getValue(thisRef:LoginUiData,property: KProperty<*>):String?{
        return this.tempString
    }



}













