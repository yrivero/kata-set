package com.hexad.pairingsession.set

import spock.lang.Specification
import spock.lang.Subject

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

}
