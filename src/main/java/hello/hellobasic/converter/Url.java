package hello.hellobasic.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Url {
    public String protocol;
    public String domain;
    public Integer port;
}
