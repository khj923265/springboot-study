package aco.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "aco.config.autoconfig.DispatcherServletConfig",
                "aco.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
