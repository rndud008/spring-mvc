package hello.hellobasic;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.Locale;

@SpringBootTest
class HelloBasicApplicationTests {

    @Test
    void contextLoads() throws ParseException {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addFormatter(new KoreanCurrencyFormatter());

        String currency = "₩1,000";
        Number parsedCurrency = conversionService.convert(currency, Number.class);
        Assertions.assertThat(parsedCurrency).isEqualTo(1000L);

        String printedCurrency = conversionService.convert(1000L, String.class);
        Assertions.assertThat(printedCurrency).isEqualTo("₩1,000");

    }

    @Test
    void currencyFormatting2() throws ParseException {

        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        CustomFormatterRegistrar registrar = new CustomFormatterRegistrar();
        registrar.registerFormatters(conversionService);

        String currency = "₩1,000";
        Number parsedCurrency = conversionService.convert(currency, Number.class);
        Assertions.assertThat(parsedCurrency).isEqualTo(1000L);

        String printedCurrency = conversionService.convert(1000L, String.class);
        Assertions.assertThat(printedCurrency).isEqualTo("₩1,000");

    }





}
