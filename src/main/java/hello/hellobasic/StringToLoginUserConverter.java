package hello.hellobasic;

import org.springframework.core.convert.converter.Converter;

public class StringToLoginUserConverter implements Converter<String, LoginUser> {
    @Override
    public LoginUser convert(String source) {

        String[] data = source.split("&");
        if (data.length != 3) {
            throw new IllegalArgumentException("Invalid format. Expected format: username,email");
        }

        long id = Long.parseLong(data[0].trim());
        String username = data[1].trim();
        String email = data[2].trim();

        return new LoginUser(id, username, email);
    }
}
