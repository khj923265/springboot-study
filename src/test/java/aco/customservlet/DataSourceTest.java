package aco.customservlet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// 스프링 컨텍스트를 이용한 스프링컨테이너 테스트가 가능
@ExtendWith(SpringExtension.class)
// 모든 빈 구성정보를 끌어오는 시작점이라 빈들 전부 불러와서 사용 가능
@ContextConfiguration(classes = HelloSpringBootApplication.class)
@TestPropertySource("classpath:/application.properties")
public class DataSourceTest {
    @Autowired
    DataSource dataSource;

    @Test
    void connect() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.close();
    }
}
