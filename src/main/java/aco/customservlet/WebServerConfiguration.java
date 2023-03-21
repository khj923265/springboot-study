package aco.customservlet;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class WebServerConfiguration {

    // config 에 있는 설정들은 전부 내가 만들지 않아도 자동으로 spring에 있는 설정들 이지만
    // 해당 설정들을 사용하면서 원하는 설정만 바꿔서 사용하려면 아래 Been 으로 사용자설정에서 등록해준뒤
    // config 에서 @ConditionalOnMissingBean 로 Conditional 을 메서드에서 확인하게 함
    @Bean
    ServletWebServerFactory customWebServerFactory() {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        serverFactory.setPort(9090);
        return serverFactory;
    }
}
