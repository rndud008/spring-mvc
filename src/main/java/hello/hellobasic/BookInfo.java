package hello.hellobasic;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookInfo {

    @JsonProperty("title")
    private String title;

    @JsonProperty("author_name")
    private List<String> authorNames;

    @JsonProperty("first_publish_year")
    private int firstPublishYear;

    @JsonProperty("language")
    private List<String> languages;
}
