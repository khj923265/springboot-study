package aco.customservlet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    @DisplayName("hello service 성공 테스트")
    @Test
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();

        String ret = simpleHelloService.sayHello("springboot");

        Assertions.assertThat(ret).isEqualTo("Hello springboot");
    }

    @DisplayName("hello Decorator 성공 테스트")
    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayHello("springboot");

        Assertions.assertThat(ret).isEqualTo("*springboot*");
    }
}
