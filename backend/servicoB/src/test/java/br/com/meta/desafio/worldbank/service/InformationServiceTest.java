package br.com.meta.desafio.worldbank.service;

import br.com.meta.desafio.worldbank.domain.Information;
import br.com.meta.desafio.worldbank.service.exceptions.PageNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@SpringBootTest
public class InformationServiceTest {

    @Autowired
    private InformationService service;

    @Test
    public void getInformationByIdShouldReturnNotNull() throws IOException, URISyntaxException {
        List<Information> list = service.getInformationById("BR",1);
        Assert.noNullElements(list, "Result null");
    }

    @Test
    public void getInformationByIdShouldReturnAnException() throws IOException, URISyntaxException {
        Assertions.assertThrows(PageNotFoundException.class, () -> {
            List<Information> list = service.getInformationById("ZZ",1);
        });
    }
}
