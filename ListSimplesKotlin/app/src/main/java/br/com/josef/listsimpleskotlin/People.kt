package br.com.josef.listsimpleskotlin

import java.io.Serializable

data class People(var name : String, var age : Int ) :Serializable{
    override fun toString(): String {
        return "$name - $age"
    }
}