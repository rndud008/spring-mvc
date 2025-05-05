package hello.hellobasic.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class StringToUrlConverter implements Converter<String,Url> {

    @Override
    public Url convert(String source) {
        if (!StringUtils.hasText(source)){
            throw new IllegalStateException("Input string is empty");
        }

        String[] parts = source.split("://");
        String protocol = parts[0];
        String domainPort = parts[1];

        String[] parts2 = domainPort.split(":");
        String domain = parts2[0];
        Integer port = Integer.parseInt(parts2[1]);

        return new Url(protocol,domain,port);
    }
}
