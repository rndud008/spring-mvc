package hello.hellobasic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // JSON 의 불필요한 필드 무시
public class OpenLibraryResponse {

    private int numFound;
    private List<BookInfo> docs;
}