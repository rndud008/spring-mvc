package hello.hellobasic.formatter;

import hello.hellobasic.converter.IpPortToStringConverter;
import hello.hellobasic.converter.StringToIpPortConvert;
import hello.hellobasic.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService(){
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        // 컨버터 등록
        conversionService.addConverter(new StringToIpPortConvert());
        conversionService.addConverter(new IpPortToStringConverter());
        // 포맷터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        // 컨버터 사용
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        Assertions.assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1",8080));
        
        // 포멧터 사용
        Assertions.assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
        Assertions.assertThat(conversionService.convert("1,000", Integer.class)).isEqualTo(1000L);




    }
}
