package com.hexad.pairingsession.set

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import java.util.stream.IntStream

/**
 * Created by Hexad GmbH on 16/03/2017.
 */
class SetSpec extends Specification{

    @Subject def Set

    def "be able to create new set instance"(){
        when: "create new instance with default constructor"
            def set = new Set()
        then: "an instance is created"
            set != null
    }

    def "new set must be empty"(){
        when: "create new instance"
            def set = new Set()
        then: "the new instance must be empty"
            set.isEmpty()
    }

    def "new set must have size 0 initially"(){
        when: "create new instance"
            def set = new Set()
        then: "the new instance must have size 0"
            set.size() == 0
    }

    def "after adding one element size is 1"(){
        given: "newly created instance"
            def set = new Set()
        when: "adding one element"
            set.add("one")
        then: "the set size must be 1"
            set.size() == 1
    }


    @Unroll("input: #n")
    def "after adding n elements size is n"(){
        given: "new set"
            set = new Set()
        when: "adding n elements"
            for(count in 1..n) set.add("item " + count)
        then: "the set size must be n"
            set.size() == n
        where:
            n << IntStream.range(1,99)
    }

    def "set contains the added element"(){
        given: "newly created instance"
            def set = new Set()
        when: "adding one element"
            set.add("one")
        then: "the set size must contains one"
            set.contains("one")
    }

    def "set doesn't contains any element when new"(){
        given: "newly created instance"
            def set = new Set()
        expect: "it doesn't contains something"
            !set.contains("two")
    }

    def "set doesn't contain element two if element two hasn't been added"(){
        given: "newly created instance"
            def set = new Set()
        when: "added element one"
            set.add("one")
        then: "it doesn't contain the element two"
            !set.contains("two")
    }

    def "set remembers all added elements, and not just the last one"(){
        given: "newly created instance"
            def set = new Set()
        when: "added elements one and two"
            set.add("one")
            set.add("two")
        then: "it contains the element one"
            set.contains("one")
    }

    def "when calling remove the element is removed from the set"(){
        given: "newly created instance"
            def set = new Set()
        when: "added the element one and remove it"
            set.add("one")
            set.remove("one")
        then: "the set must be empty"
            set.isEmpty()
    }

    def "null elements can be added to the set"(){
        given: "newly created instance"
            def set = new Set()
        when: "added a null element"
            set.add(null)
        then: "the add operation doesn't fail"
            true
    }

    def "the set can contain null elements"(){
        given: "newly created instance"
            def set = new Set()
        when: "added a null element"
            set.add(null)
        then: "the contains operation doesn't fail"
            set.contains(null)
    }

    def "the remove operation accepts null elements"(){
        given: "newly created instance containing a null element"
            def set = new Set()
            set.add(null)
        when: "removing a null element"
            set.remove(null)
        then: "the remove operation doesn't fail"
            set.isEmpty()
    }

    def "the add method doesn't add duplicated elements"(){
        given: "newly created instance"
            def set = new Set()
        when: "adding the element one twice"
            set.add("one")
            set.add("one")
        then: "the set only contains the one element once"
            set.contains("one")
            set.size == 1
    }

    def "contains method finds only elements we already added before"(){
        given: "newly created instance with the elements one and two"
            def set = new Set()
            set.add("one")
            set.add("two")
        when: "we check if the set contains an element we haven't added"
            def result = set.contains(null)
        then: "the result is false"
            result == false
    }

    def "the remove method has to work with elements already present in the set"(){
        given: "a newly created instance with the elements one, two and three, and having removed the element three"
            def set = new Set()
            set.add("one")
            set.add("two")
            set.add("three")
            set.remove("three")
        when: "the remove method is called to remove again the element three"
            set.remove("three")
        then: "the remove method doesn't change the set"
            set.size() == 2
            set.contains("one")
            set.contains("two")
            !set.contains("three")
    }

    def "set capacity grows beyond the initial size"(){
        given: "a set filled to its maximum capacity"
            def set = new Set(1)
            set.add("one")
        when: "adding new elements"
            set.add("two")
        then: "the capacity of the set grows automatically"
            set.size() == 2
    }

    def "after the clear method is called the set must be empty"(){
        given: "a set containing two elements"
            def set = new Set()
            set.add("one")
            set.add("two")
        when: "the clear method is executed"
            set.clear()
        then: "the set must be empty"
            set.isEmpty()
    }

}
