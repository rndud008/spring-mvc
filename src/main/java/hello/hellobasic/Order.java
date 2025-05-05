package hello.hellobasic;

import lombok.Data;

@Data
public class Order {
    private String item;
    private int quantity;
}