package br.com.meta.desafio.worldbank.service;

import br.com.meta.desafio.worldbank.domain.Information;
import br.com.meta.desafio.worldbank.service.exceptions.PageNotFoundException;
import com.google.gson.Gson;
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

    public List<Information> getInformationById(String id, Integer page) throws URISyntaxException, IOException {
        if(Character.isDigit(id.charAt(0))){
            throw new PageNotFoundException("Desculpe, essa página nao pode ser carregada");
        }

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://api.worldbank.org/v2/country/"+id+"/indicator/SI.POV.DDAY?format=json&page="+page, String.class);

        List<Information> informations = jsonToObject(responseEntity.getBody());
        if(Objects.isNull(responseEntity) || responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            throw new PageNotFoundException("Desculpe, essa página nao pode ser carregada");
        }

        return jsonToObject(responseEntity.getBody());
    }

    private List<Information> jsonToObject(String json){
        List<Information> informations = new ArrayList<>();
        try{
            JSONArray array = new JSONArray(json);
            int arrayLength = array.getJSONArray(1).length();
            JSONArray internArray = array.getJSONArray(1);
            for(int i=0 ; i<arrayLength ; i++){
                String informationString = internArray.getJSONObject(i).toString();
                Gson gson = new Gson();
                Information information = gson.fromJson(informationString, Information.class);
                informations.add(information);
            }
        } catch (Exception e){
            throw new PageNotFoundException("Desculpe, essa página nao pode ser carregada");
        }

        return informations;
    }

}
