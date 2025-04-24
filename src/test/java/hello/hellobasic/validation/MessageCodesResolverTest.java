package hello.hellobasic.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

public class MessageCodesResolverTest {

    MessageCodesResolver resolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodeResolverObject(){
        String[] messageCodes = resolver.resolveMessageCodes("required", "item");

        Assertions.assertThat(messageCodes).containsExactly("required.item","required");

    }

    @Test
    void messageCodesResolverField(){
        String[] messageCodes = resolver.resolveMessageCodes("required", "item", "itemName", String.class);


        Assertions.assertThat(messageCodes).containsExactly(
                "required.item.itemName"
                ,"required.itemName"
                ,"required.java.lang.String"
                ,"required"
        );
    }
}
