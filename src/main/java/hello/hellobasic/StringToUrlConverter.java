package hello.hellobasic;

import org.springframework.core.convert.converter.Converter;

public class StringToUrlConverter implements Converter<String, Url> {
    @Override
    public Url convert(String source) {
        if (source == null || source.trim().isEmpty()) {
            throw new IllegalArgumentException("URL string cannot be null or empty");
        }
        String[] parts = source.split("://");
        String protocol = parts[0];
        String domainPort = parts[1];

        String[] parts2 = domainPort.split(":");
        String domain = parts2[0];
        int port = Integer.parseInt(parts2[1]);
        return new Url(protocol, domain, port);
    }
}