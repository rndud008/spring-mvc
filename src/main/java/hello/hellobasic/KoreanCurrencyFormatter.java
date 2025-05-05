package hello.hellobasic;

import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class KoreanCurrencyFormatter implements Formatter<Number> {

    @Override
    public String print(Number number, Locale locale) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(number);
    }

    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.parse(text);
    }
}