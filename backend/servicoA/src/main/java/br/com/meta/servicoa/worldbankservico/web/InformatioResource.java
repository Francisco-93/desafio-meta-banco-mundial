package br.com.meta.servicoa.worldbankservico.web;

import br.com.meta.servicoa.worldbankservico.service.DTO.InformationDTO;
import br.com.meta.servicoa.worldbankservico.service.InformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/resource")
@Api(tags = "/resource", value = "API que se comunica com o serviço B onde é buscada as informações " +
        "sobre o índice de pobreza mundial para determinado país ")
public class InformatioResource {

    @Autowired
    private InformationService informationService;

    @ApiOperation(value = "Endpoint para retornar informações formatadas " +
            "sobre o índice de pobreza de determinado país")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping(value = "/{id}/{page}")
    public List<InformationDTO> findById(@PathVariable String id, @PathVariable Integer page) throws IOException, URISyntaxException {
        return informationService.getInformationById(id, page);
    }

}
