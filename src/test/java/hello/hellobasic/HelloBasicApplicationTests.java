package hello.hellobasic;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.io.InputStream;


@SpringBootTest
class HelloBasicApplicationTests {

    private final String REQUEST_BODY = """
                {
                    "title": "Spring Boot REST",
                    "body": "RestClient로 JSONPlaceholder API 테스트",
                    "userId": 1
                    "ddd": ddd
                }
                """;
    private RestClient restClient;

    @BeforeEach
    void setUp() {
        restClient = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
    }

    @Test
    void exception() throws Exception {
        try {
            String body = restClient.get()
                    .uri("/customer")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(String.class);
        }catch(RestClientException e) {
            System.out.println("e = " + e);
        }

    }

    @Test
    void onStatus() throws Exception {
        try {
            restClient.post()
                    .uri("/customer")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (request, response)->{
                        throw new UserNotFoundException("클라이언트 오류 발생: " + response.getStatusCode());
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, (request, response)-> {
                        throw new IllegalArgumentException("서버 오류 발생: " + response.getStatusCode());
                    })
                    .toBodilessEntity();

        }catch(RestClientException e) {
            System.out.println("e = " + e);
        }catch(Exception e) {
            System.out.println("e = " + e);
        }
    }

    @Test
    void onStatusMapping() throws Exception {
        try {
            ResponseEntity<Void> bodilessEntity = restClient.post()
                    .uri("/posts")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(REQUEST_BODY)
                    .retrieve()
                    .onStatus(code -> code.value() == 500, (request, response) -> {
                        throw new UserNotFoundException("클라이언트 오류 발생: " + response.getStatusCode());
                    })
                    .toBodilessEntity();
            System.out.println("bodilessEntity = " + bodilessEntity);

        }catch(RestClientException e) {
            System.out.println("e = " + e);
        }catch(Exception e) {
            System.out.println("e = " + e);
        }
    }

    @Test
    void exchange() throws Exception {
        try {
            restClient.post()
                    .uri("/posts")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(REQUEST_BODY)
                    .exchange((request, response) -> {
                        HttpStatusCode statusCode = response.getStatusCode();
                        if(statusCode.is4xxClientError()){}
                        if(statusCode.is5xxServerError()){}
                        if(statusCode.is3xxRedirection()){}
                        if (statusCode.is1xxInformational()){}
                        if(statusCode.is2xxSuccessful()){try(InputStream body = response.getBody()){
                            return new String(body.readAllBytes());
                        }}
                        return  null;
                    });

        }catch(RestClientException e) {
            System.out.println("e = " + e);
        }catch(Exception e) {
            System.out.println("e = " + e);
        }
    }

}
