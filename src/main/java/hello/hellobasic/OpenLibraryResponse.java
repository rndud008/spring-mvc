package hello.hellobasic;

import lombok.Data;

import java.util.List;

@Data
public class OpenLibraryResponse {
    private int numFound;
    private List<BookInfo> docs;
}
