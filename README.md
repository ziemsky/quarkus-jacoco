# Quarkus with JaCoco demo

Sandbox for experiments with configuration of JaCoCo with Quarkus.

## The setup 

Class [ExampleResource.java](src/main/java/com/ziemsky/lambdahttp/ExampleResource.java) exposes JAX-RS API. It contains two methods: one executed from [unit test](src/test/groovy/com/ziemsky/lambdahttp/ExampleResourceSpec.groovy) (Spock specification), and another executed from `@QuarkusTest`-annotated [test class](integration-test/java/com/ziemsky/lambdahttp/ExampleResourceQuarkusIT.java).

Unit tests are executed by `maven-surefire-plugin`, and `@QuarkusTest`-annotated tests are executed through `maven-failsafe-plugin`.

`@QuarkusTest`-annotated class is located in `integration-test` directory, and `build-helper-maven-plugin` is used to include it compilation of test classes. `gmavenplus-plugin` does the same for `*Spec.groovy` classes. All compiled test class files end up aggregated under [target/test-classes](target/test-classes), where both plugins invoke them from (Surefire invokes `*Spec` classes, and Failsafe invokes `*IT` classes). 

## JaCoCo

...is configured to instrument classes both for 'pure' unit tests (`Spec`s) and `@QuarkusTest-annotated` tests. 

The configuration is done exclusively through Surefire and Failsafe Maven plugins, and does not rely on [Quarkus JaCoCo extension](https://quarkus.io/guides/tests-with-coverage).

## To run
Execute:
```shell
mvn clean verify
```

...then see JaCoCo coverage reports in [target/site/jacoco/index.html](target/site/jacoco/index.html).

Note that both methods in [ExampleResource.java](src/main/java/com/ziemsky/lambdahttp/ExampleResource.java) are reported as covered.