package aco.config.autoconfig;

import aco.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@MyAutoConfiguration
public class PropertyPlaceholderConfig {

    // BeanFactoryPostProcessor >> 시간이 지나며 이걸 확장해서 만들어진게 PropertySourcesPlaceholderConfigurer
    // Been 정보를 모은 다음 후처리기(어떤 프로세서가 진행되는 중간과정에 후킹해 들어가 부가작업)
    // 스프링컨테이너의 확장 포인터
    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
