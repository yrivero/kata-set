package com.hexad.pairingsession.set

class Set {

    private val ELEMENT_NOT_FOUND = -1

    private val DEFAULT_INITIAL_CAPACITY : Int = 100

    private var size : Int = 0

    private var elements : Array<Any?> = arrayOfNulls(0)

    private var initialCapacity : Int = -1

    constructor(initialCapacity:Int) {
        _init(initialCapacity)
    }

    constructor() {
        _init(DEFAULT_INITIAL_CAPACITY)
    }

    fun _init(initialCapacity: Int) {
        this.initialCapacity = initialCapacity
        resetElementsArray()
    }

    private fun resetElementsArray() {
        elements = arrayOfNulls(initialCapacity)
        size = 0
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

        return (index != ELEMENT_NOT_FOUND)
    }

    fun remove(element: Any?) {
        var index = indexOf(element)

        if(index != ELEMENT_NOT_FOUND){
            elements[index] = elements[size-1]
            size--
        }
    }

    fun clear() {
        resetElementsArray()
    }

    private fun indexOf(element: Any?): Int {
        for (currentIndex: Int in 0..(size - 1)) {
            if (elementsAreEqual(element, elements[currentIndex])) {
                return currentIndex
            }
        }

        return ELEMENT_NOT_FOUND
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
