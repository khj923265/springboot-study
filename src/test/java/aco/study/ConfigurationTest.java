package aco.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 학습 테스트
 * 내가 만든 코드만 테스트 하는게 아닌
 * 만들어져 있는 것을 테스트
 */
public class ConfigurationTest {

    @Test
    void configuration() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfiguration.class);
        ac.refresh();

        Been1 been1 = ac.getBean(Been1.class);
        Been2 been2 = ac.getBean(Been2.class);

        Assertions.assertThat(been1.common).isSameAs(been2.common);
    }

    @Test
    void proxyCommonMethod() {
        MyConfigurationProxy myConfigurationProxy = new MyConfigurationProxy();
        Been1 been1 = myConfigurationProxy.been1();
        Been2 been2 = myConfigurationProxy.been2();

        Assertions.assertThat(been1.common).isSameAs(been2.common);
    }

    static class MyConfigurationProxy extends MyConfiguration{
        private Common common;

        @Override
        Common common() {
            if (this.common == null) this.common = super.common();

            return this.common;
        }

    }

    // spring 5.2 버전 부터 추가된 옵션 기능
    // proxyBeanMethods = false 사용시 프록시 사용 X
    // 예전에는 true 인 디폴트값 사용을 권장 했으나 최근에는
    // 다른 Been 안에서 다른 Been 을 사용하는게 아니라면 false 를 사용하는 것도 좋다고 함
    // 다른 Been 을 쓰는게 아닌데 true 디폴트값 사용시 굳이 프록시 비용이 발생함
    @Configuration
    static class MyConfiguration {
        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Been1 been1() {
            return new Been1(common());
        }
        @Bean
        Been2 been2() {
            return new Been2(common());
        }
    }
    static class Been1 {
        private final Common common;

        Been1(Common common) {
            this.common = common;
        }
    }

    static class Been2 {
        private final Common common;

        Been2(Common common) {
            this.common = common;
        }
    }

    static class Common {

    }

}
