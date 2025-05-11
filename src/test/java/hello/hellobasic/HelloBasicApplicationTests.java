package hello.hellobasic;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.io.InputStream;


@SpringBootTest
class HelloBasicApplicationTests {

    @Test
    void create() throws Exception {

        String url = "https://openlibrary.org/search.json?q=springboot";

        RestClient restClient = RestClient.create();
        OpenLibraryResponse response = restClient.get()
                .uri(url)
                .retrieve()
                .body(OpenLibraryResponse.class);

        this.print(response);

    }

    @Test
    void bulider() throws Exception {

        // 의존성 추가 필요.
        // implementation 'org.apache.httpcomponents.client5:httpclient5'

        RestClient restClient = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                .baseUrl("https://openlibrary.org/")
                .build();


//        String url = "search.json?q=springboot";
//        OpenLibraryResponse response = restClient.get()
//                .uri(url)
//                .retrieve()
//                .body(OpenLibraryResponse.class);


        String keyword = "springboot";
        String queryUrl = "/search.json?q={keyword}";
        OpenLibraryResponse response = restClient.get()
                .uri(queryUrl, keyword)
                .retrieve()
                .body(OpenLibraryResponse.class);

        this.print(response);

    }

    @Test
    void headers() throws Exception {

        RestClient restClient = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                .baseUrl("https://openlibrary.org/")
                .build();

        String url = "search.json?q=springboot";
        ResponseEntity<OpenLibraryResponse> response1 = restClient.get()
                .uri(url)
                .header("Custom-Header1", "Custom-Value1")
                .header("Custom-Header2", "Custom-Value2")
                .retrieve()
                .toEntity(OpenLibraryResponse.class);

        ResponseEntity<OpenLibraryResponse> response2 = restClient.get()
                .uri(url)
                .headers(httpHeaders -> {
                    httpHeaders.add("Custom-Header1", "Custom-Value1");
                    httpHeaders.add("Custom-Header2", "Custom-Value2");
                    httpHeaders.set("Custom-Header3", "Custom-Value3");
                })
                .retrieve()
                .toEntity(OpenLibraryResponse.class);

        HttpHeaders headers = response1.getHeaders();
        headers.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }

    @Test
    void body() throws Exception {

        RestClient restClient = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        // POST
        String requestBody = """
                {
                    "title": "Spring Boot REST",
                    "body": "RestClient로 JSONPlaceholder API 테스트",
                    "userId": 1
                }
                """;

        ResponseEntity<String> entity = restClient.post()
                .uri("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestBody)
                .retrieve()
                .toEntity(String.class);

        System.out.println("응답코드: " + entity.getStatusCode());
        System.out.println("응답본문: " + entity.getBody());


    }

    @Test
    void exchange() throws Exception {

        RestClient restClient = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        // POST
        String requestBody = """
                {
                    "title": "Spring Boot REST",
                    "body": "RestClient로 JSONPlaceholder API 테스트",
                    "userId": 1
                }
                """;

        PostResponse postResponse = restClient.post()
                .uri("/posts")
                .header("Custom-Header1", "Custom-Value1")
                .header("Custom-Header2", "Custom-Value2")
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestBody)
                .exchange((request, response) -> {
                    HttpStatusCode statusCode = response.getStatusCode();
                    if (statusCode.is4xxClientError() || statusCode.is4xxClientError()) {
                        throw new RuntimeException("오류 상태 코드: " + statusCode.value());
                    }
                    try (InputStream bodyStream = response.getBody()) {
                        if (bodyStream == null) {
                            return null;
                        }
                        return objectMapper.readValue(bodyStream, PostResponse.class);
                    }
                });

        System.out.println("================================");
        System.out.println("postResponse = " + postResponse);
        System.out.println("================================");


    }


    private void print(OpenLibraryResponse response) {
        if(response != null) {
            System.out.println("검색된 책의 개수: " + response.getNumFound());
            for (BookInfo book : response.getDocs()) {
                System.out.println("제목: " + book.getTitle());
                System.out.println("저자: " + book.getAuthorNames());
                System.out.println("출판 연도 : " + book.getFirstPublishYear());
                System.out.println("언어 : " + book.getLanguages());
            }
        }else{
            System.out.println("API 응답이 없습니다.");
        }
    }

}
