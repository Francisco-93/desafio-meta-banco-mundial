package br.com.meta.desafio.worldbank.web;

import br.com.meta.desafio.worldbank.domain.Information;
import br.com.meta.desafio.worldbank.service.InformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/information")
@Api(tags = "/information", value = "API para consultar informações sobre índice de pobreza no mundo")
public class InformationController {

    @Autowired
    InformationService informationService;

    @ApiOperation(value = "Endpoint para retornar informações sobre o índice de pobreza de determinado país")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/{id}/{page}")
    public ResponseEntity<List<Information>> getInformationByCountry(@PathVariable String id, @PathVariable Integer page) throws IOException, URISyntaxException {
        List<Information> informations = informationService.getInformationById(id, page);
        return ResponseEntity.ok().body(informations);
    }
}
