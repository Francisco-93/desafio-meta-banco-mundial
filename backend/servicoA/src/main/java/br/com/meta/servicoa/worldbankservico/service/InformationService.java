package br.com.meta.servicoa.worldbankservico.service;

import br.com.meta.servicoa.worldbankservico.domain.Information;
import br.com.meta.servicoa.worldbankservico.service.DTO.InformationDTO;
import br.com.meta.servicoa.worldbankservico.service.exceptions.PageNotFoundException;
import com.google.gson.Gson;
import org.apache.logging.log4j.util.Strings;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class InformationService {

    public List<InformationDTO> getInformationById(String id, Integer page) throws URISyntaxException, IOException {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8081/servicoB/information/"+id+"/"+page, String.class);

        List<Information> listObj = jsonToObject(responseEntity.getBody());

        if(Objects.isNull(responseEntity) || responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            throw new PageNotFoundException("Desculpe, essa página nao pode ser carregada");
        }

        List<InformationDTO> listDto = new ArrayList<>();
        for(Information obj : listObj){
            listDto.add(toDTO(obj));
        }

        return listDto;

    }

    private List<Information> jsonToObject(String json){
        List<Information> informations = new ArrayList<>();
        try{
            JSONArray array = new JSONArray(json);
            for(int i=0 ; i<array.length() ; i++){
                String informationString = array.getJSONObject(i).toString();
                Gson gson = new Gson();
                Information information = gson.fromJson(informationString, Information.class);
                informations.add(information);
            }
        } catch (Exception e){
            throw new PageNotFoundException("Desculpe, essa página nao pode ser carregada");
        }

        return informations;
    }

    private InformationDTO toDTO (Information obj){
        InformationDTO dto = new InformationDTO(obj);
        return dto;
    }

}
