package com.ziemsky.lambdahttp

import spock.lang.Specification

class ExampleResourceSpec extends Specification {

    def "Returns response"() {
        given:
            def resource = new ExampleResource()

        when:
            def response = resource.helloUnitTest()

        then:
            response == "Hello unit test."

    }
}
