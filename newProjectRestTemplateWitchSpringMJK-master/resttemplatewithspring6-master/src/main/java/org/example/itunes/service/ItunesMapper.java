package org.example.itunes.service;

//import com.example.restemplate.itunes.proxy.ItunesResponse;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.example.itunes.proxy.ItunesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;

@Component
@Log4j2
public class ItunesMapper {
    // tu jest kod ktr odpowiada za to by wziąć string którym jest Json i z tego Jsona przemapować go na obiekt Javovy
    private final ObjectMapper objectMapper;
    @Autowired
    public ItunesMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    ItunesResponse mapJsonToItunesResponse(String json){
        try {
            return objectMapper.readValue(json, ItunesResponse.class);
        } catch (JsonProcessingException e) {
            log.error("ItunesMapper could not map Json");
            //emptyList = taka metoda która tworzy nam pustą listę jak cos.
            return new ItunesResponse(0, emptyList());
        }
    }
}
