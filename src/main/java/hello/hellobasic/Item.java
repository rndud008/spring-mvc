package hello.hellobasic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Long code;
    private String name;
    private int price;

    public void disCount(int amount) {
        this.price = this.price - amount;
    }

}
