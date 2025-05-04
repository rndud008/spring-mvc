package hello.hellobasic.custom;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebMappingLogger {

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    @PostConstruct
    public void logMappingDetails() {
        Map<RequestMappingInfo, HandlerMethod> mappingMap = requestMappingHandlerMapping.getHandlerMethods();

        mappingMap.forEach((key, value) -> {
            log.info("Mapped URL path {} onto {}", key.getDirectPaths(), value);
        });
    }
}