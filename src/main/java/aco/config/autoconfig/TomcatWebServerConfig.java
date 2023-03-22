package aco.config.autoconfig;

import aco.config.ConditionalMyOnClass;
import aco.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Value("${contextPath}")
    String contextPath;

    @Value("${port:8080}")
    int port;

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean // 메서드레벨에서 해당 빈이 등록이 되어있으면 무시하고 등록되지않으면 아래 빈을 등록시킴
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        serverFactory.setContextPath(properties.getContextPath());
        serverFactory.setPort(properties.getPort());
        return serverFactory;
    }
}
