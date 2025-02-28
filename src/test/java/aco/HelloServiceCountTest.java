package aco;

import aco.customservlet.HelloRepository;
import aco.customservlet.HelloService;
import aco.customservlet.HellobootTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

@HellobootTest
public class HelloServiceCountTest {
    @Autowired
    HelloService helloService;
    @Autowired
    HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.sayHello("Jooni");
            Assertions.assertThat(helloRepository.countOf("Jooni")).isEqualTo(count);
        });
    }

}
