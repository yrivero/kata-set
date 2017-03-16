package com.hexad.pairingsession.set

import spock.lang.Specification
import spock.lang.Subject

/**
 * Created by Hexad GmbH on 16/03/2017.
 */
class SetSpec extends Specification{

    @Subject def Set

    def "be able to create new set instance"(){
        given: "nothing"
        when: "create new instance with default constructor"
            def set = new Set()
        then: "an instance is created"
            set != null
    }
}
