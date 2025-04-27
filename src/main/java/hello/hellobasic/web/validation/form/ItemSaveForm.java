package hello.hellobasic.web.validation.form;

import hello.hellobasic.domain.item.SaveCheck;
import hello.hellobasic.domain.item.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ItemSaveForm {

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 1_000, max = 1_000_000)
    private Integer price;

    @NotNull
    @Range( max = 9_999)
    private Integer quantity;

}
