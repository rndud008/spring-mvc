package hello.hellobasic.annotation;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {

    @CustomCurrencyFormat(pattern = "#,###.##", decimalPlaces = 2)
    private BigDecimal price;

    @CustomCurrencyFormat(pattern = "#,###.###", decimalPlaces = 3)
    private BigDecimal discount;
}