package aco.customservlet;

import aco.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;


// 여기까지가 간단하게 구현한거고
// 다음부터는 Auto Configuration 구조로 확장해나가는 작업을 진행할 예정
@MySpringBootApplication
public class HelloSpringBootApplication {
	private final JdbcTemplate jdbcTemplate;

	public HelloSpringBootApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// 설정이 모두 완료된 이후 실행
	@PostConstruct
	void init() {
		jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}
}
