package hello.hellobasic;

import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CustomNumberFormatter implements Formatter<Number> {

    @Override
    public String print(Number number, Locale locale) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        return numberFormat.format(number);
    }

    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        return numberFormat.parse(text);
    }
}