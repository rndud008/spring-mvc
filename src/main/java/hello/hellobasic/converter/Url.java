package hello.hellobasic.converter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Url {
    private String protocol;
    private String domain;
    private int port;
    private IpAddress ipAddress;
}
