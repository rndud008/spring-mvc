package hello.hellobasic;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Item {

    @NotEmpty(message = "상품명은 필수입니다")
    private String itemName;

    @Min(1)
    @Max(120)
    private int price;
}
