package aco.customservlet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    @DisplayName("hello service 성공 테스트")
    @Test
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();

        String res = simpleHelloService.sayHello("springboot");

        Assertions.assertThat(res).isEqualTo("Hello springboot");
    }
}
