package hello.hellobasic.converter;

import hello.hellobasic.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConversionServiceTest {
    @Test
    void conversionService(){
        // 등록
        DefaultConversionService defaultConversionService = new DefaultConversionService();
        defaultConversionService.addConverter(new StringToIntegerConverter());
        defaultConversionService.addConverter(new IntegerToStringConverter());
        defaultConversionService.addConverter(new StringToIpPortConvert());
        defaultConversionService.addConverter(new IpPortToStringConverter());

        //  사용
        Assertions.assertThat( defaultConversionService.convert("10",Integer.class)).isEqualTo(10);
        Assertions.assertThat( defaultConversionService.convert(10,String.class)).isEqualTo("10");
        IpPort ipPort = defaultConversionService.convert("127.0.0.1:8080", IpPort.class);
        Assertions.assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1",8080));

        String ipPrtString = defaultConversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        Assertions.assertThat(ipPrtString).isEqualTo("127.0.0.1:8080");
    }
}
