package com.hexad.pairingsession.set

class Set{

    private var size : Int = 0

    fun isEmpty():Boolean{
        return true
    }

    fun size(): Int{
        return size
    }

    fun add(element: Any) : Unit {
        size++
    }

}
