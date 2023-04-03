package aco.config.autoconfig;

import aco.config.ConditionalMyOnClass;
import aco.config.EnableMyConfigurationProperties;
import aco.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {

    // 원래 @Value 의 placeHolder 의 치환은 스프링컨테이너의 기본 동작 방식이 아님
    // 스프링컨테이너를 확장해서 기능을 추가해줘야함 => PropertySourcesPlaceholderConfigurer
    //@Value("${contextPath:}")
    //String contextPath;

    //@Value("${port:8080}")
    //int port;

    // 외부 설정을 이용한 자동 구성방식 구현
    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean // 메서드레벨에서 해당 빈이 등록이 되어있으면 무시하고 등록되지않으면 아래 빈을 등록시킴
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        serverFactory.setContextPath(properties.getContextPath());
        serverFactory.setPort(properties.getPort());
        return serverFactory;
    }
}
