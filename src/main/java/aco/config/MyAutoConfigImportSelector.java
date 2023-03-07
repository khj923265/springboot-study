package aco.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        /**
         * ImportCandidates.laod() 가 불러오는 경로
         * META-INF/spring/full-qualified-annotation-name
         * 실제로 스프링부트의 @AutoConfiguration 메타어노테이션을 달고있는 기본 autoconfiguration 들이 아래 경로에 들어가 있음
         * META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
         * 위에 경로에 144개의 autoconfiguration 이 있고 그외에도 총 300개 가까이 되는 것들이 있는데
         * 사용하지 않는 설정들은 어떻게 되는지 알아보게됨
         */
        List<String> autoConfigs = new ArrayList<>();

        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigs::add);
        return autoConfigs.toArray(new String[0]);
    }
}
