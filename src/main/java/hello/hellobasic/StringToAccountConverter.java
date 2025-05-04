package hello.hellobasic;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

public class StringToAccountConverter implements Converter<String, User> {
    @Override
    public User convert(String source) {
        // "id,email" 형식의 문자열을 파싱
        String[] data = source.split(":");
        if (data.length != 2) {
            throw new IllegalArgumentException("Invalid format. Expected format: username,email");
        }

        String username = data[0].trim();
        String email = data[1].trim();

        return new User(username, email);
    }
}
