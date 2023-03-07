package aco.config;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
/**
 * spring 에 자동 등록된 Been 뿐만 아니라 직접 원하는 Been 을 등록해야 할 수도 있기 때문에
 *  @Configuration 의 동작 방식을 알고 넘어가야함
 */
@Configuration(proxyBeanMethods = false) // proxyBeanMethods 이 뭐가 다른지는 뒤에 설명 할 예정
public @interface MyAutoConfiguration {
}
