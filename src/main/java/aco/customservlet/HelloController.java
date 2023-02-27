package aco.customservlet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;

    // 초창기 스프링은 xml 로 빈을 정의하고 생성자에 어떤 빈을 주입할지도 다 정의해 줬어야함
    // 지금은 생성자 인터페이스를 구현한 클래스를 빈에서 찾아서 주입해줌
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();
        return helloService.sayHello(name);
    }
}
