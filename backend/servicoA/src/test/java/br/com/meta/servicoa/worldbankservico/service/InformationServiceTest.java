package br.com.meta.servicoa.worldbankservico.service;

import br.com.meta.servicoa.worldbankservico.service.DTO.InformationDTO;
import br.com.meta.servicoa.worldbankservico.service.exceptions.PageNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
        List<InformationDTO> list = service.getInformationById("BR",1);
        Assert.noNullElements(list, "Result null");
    }

}
