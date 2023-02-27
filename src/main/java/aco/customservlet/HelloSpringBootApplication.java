package aco.customservlet;

import aco.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;


// 여기까지가 간단하게 구현한거고
// 다음부터는 Auto Configuration 구조로 확장해나가는 작업을 진행할 예정
@MySpringBootApplication
public class HelloSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}
}
