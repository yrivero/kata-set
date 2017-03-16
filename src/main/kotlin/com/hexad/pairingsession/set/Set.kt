package com.hexad.pairingsession.set

class Set{

    private var size : Int = 0

    private var elements : Array<Any?> = arrayOfNulls(100)

    fun isEmpty():Boolean{
        return size == 0
    }

    fun size(): Int{
        return size
    }

    fun add(element: Any) : Unit {
        elements[size] = element
        size++
    }

    fun contains(element: Any) : Boolean {
        return elements.contains(element)
    }
}
