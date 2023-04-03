package aco.history;

import aco.config.MyAutoConfiguration;
import aco.config.autoconfig.ServerProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    // ServerProperties 스프링부트 객체 뜯어보기
    //TODO
    // 프로퍼티 값들을 별도 클래스로 분리
    // Binder, ServerProperties 뜯어보기
    // 프리픽스 어떻게 설정할 수 있는지, 빈을 어떻게 쉽게 등록할 수 있는지 알아보기
    @Bean
    ServerProperties serverProperties(Environment environment) {
        // Binder 해당 클래스 setter 네임에 맞춰서 자동 바인딩 해줌
        return Binder.get(environment).bind("", ServerProperties.class).get();
    }
}
