package com.hexad.pairingsession.set

class Set {

    private var size : Int = 0

    private var elements : Array<Any?> = arrayOfNulls(0)

    private val initialCapacity : Int = 100

    constructor(initialCapacity:Int) {
        _init(initialCapacity)
    }

    constructor() {
        _init(initialCapacity)
    }

    fun _init(initialCapacity: Int) {
        elements = arrayOfNulls(initialCapacity)
    }


    fun isEmpty():Boolean{
        return size == 0
    }

    fun size(): Int{
        return size
    }

    fun add(element: Any?) : Unit {
        if (!contains(element)) {
            if(size == elements.size){
                resizeArray()
            }
            elements[size] = element
            size++
        }
    }

    private fun resizeArray() {
        elements = elements.copyOf(elements.size + initialCapacity)
    }

    fun contains(element: Any?) : Boolean {
        var index = indexOf(element)

        return (index != -1)
    }

    fun remove(element: Any?) {
        var index = indexOf(element)

        if(index != -1){
            elements[index] = elements[size-1]
            size--
        }
    }

    fun clear() {

    }

    private fun indexOf(element: Any?): Int {
        for (currentIndex: Int in 0..(size - 1)) {
            if (elementsAreEqual(element, elements[currentIndex])) {
                return currentIndex
            }
        }

        return -1
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
