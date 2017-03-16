package com.hexad.pairingsession.set

class Set{

    private var size : Int = 0

    fun isEmpty():Boolean{
        return size == 0
    }

    fun size(): Int{
        return size
    }

    fun add(element: Any) : Unit {
        size++
    }

}
