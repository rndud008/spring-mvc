package hello.hellobasic.annotation;


import org.springframework.format.Formatter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CustomCurrencyFormatter implements Formatter<BigDecimal> {

    private final String pattern;
    private final int decimalPlaces;

    public CustomCurrencyFormatter(String pattern, int decimalPlaces) {
        this.pattern = pattern;
        this.decimalPlaces = decimalPlaces;
    }

    @Override
    public String print(BigDecimal number, Locale locale) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.KOREA);
        formatter.setMaximumFractionDigits(this.decimalPlaces);
        return formatter.format(number);
    }

    @Override
    public BigDecimal parse(String text, Locale locale) throws ParseException {
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        Number number = decimalFormat.parse(text);

        return BigDecimal.valueOf(number.doubleValue())
                .setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
    }
}