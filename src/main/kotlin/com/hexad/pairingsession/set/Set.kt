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

    fun add(element: Any?) : Unit {
        elements[size] = element
        size++
    }

    fun contains(element: Any?) : Boolean {
        return elements.contains(element)
    }

    fun remove(element: Any?) {
        var index = elements.indexOf(element)

        if(index != -1){
            elements[index] = elements[size-1]
            size--
        }
    }

    private fun elementsAreEqual(element1: Any?, element2: Any?): Boolean {
        return  (element1 == null && element2 == null)
                ||
                (
                        element1 != null
                        && element2 != null
                        && element2 == element1
                )
    }


}
