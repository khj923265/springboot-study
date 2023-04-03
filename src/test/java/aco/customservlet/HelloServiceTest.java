package aco.customservlet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    @DisplayName("hello service 성공 테스트")
    @Test
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService(helloRepositoryStub);

        String ret = simpleHelloService.sayHello("springboot");

        Assertions.assertThat(ret).isEqualTo("Hello springboot");
    }

    private static HelloRepository helloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {
        }
    };

    @DisplayName("hello Decorator 성공 테스트")
    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayHello("springboot");

        Assertions.assertThat(ret).isEqualTo("*springboot*");
    }
}
