package br.com.meta.desafio.worldbank.controller;

import br.com.meta.desafio.worldbank.WorldBankApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(classes = WorldBankApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WorldBankControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void getInformationByIdShouldReturnOkStatus(){
        String path = UriComponentsBuilder
                .fromUriString("/servicoB/information/{id}/{page}")
                .buildAndExpand("BR", 1)
                .getPath();

        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(getUrl(path, this.port), String.class);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    public void getInformationByIdShouldReturnBadRequestStatus(){
        String path = UriComponentsBuilder
                .fromUriString("/servicoB/information/{id}/{page}")
                .buildAndExpand("ZZ", 1)
                .getPath();

        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(getUrl(path, this.port), String.class);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

    }

    public static String getUrl(String path, int port) {
        return String.format("http://localhost:%s%s", port, path);
    }
}
