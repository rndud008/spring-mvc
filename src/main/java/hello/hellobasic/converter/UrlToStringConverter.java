package hello.hellobasic.converter;

import org.springframework.core.convert.converter.Converter;

public class UrlToStringConverter implements Converter<Url, String> {
    @Override
    public String convert(Url source) {
        if (source == null) {
            throw new IllegalArgumentException("Url cannot be null");
        }
        return source.getProtocol() + "://" + source.getDomain() + ":" + source.getPort();
    }
}
