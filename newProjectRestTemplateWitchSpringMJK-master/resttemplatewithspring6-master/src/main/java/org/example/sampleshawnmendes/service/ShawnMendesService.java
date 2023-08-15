package org.example.sampleshawnmendes.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.example.sampleshawnmendes.proxy.SampleServerShawnMendesResponse;
import org.example.sampleshawnmendes.proxy.SampleShawnMendesServerProxy;
import org.example.songviever.Song;
import org.example.songviever.SongFetchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
@Log4j2
        //ta klasa po użyciu adnotacji @Service wie, że jest klasą konfoguracyjną (BEANEM) poźniej wstrzykujemy to za pomocą
                                //adnotacji @Autowired
public class ShawnMendesService implements SongFetchable {

    private final SampleShawnMendesServerProxy sampleShawnMendesServerClient;
    private final ShawnMendesServiceMapper shawnMendesServiceMapper;
//    @Autowired nie trzeba od pewnje wersji springa bo sproing sam juz to wstrzykuje
    public ShawnMendesService(SampleShawnMendesServerProxy sampleShawnMendesServerClient, ShawnMendesServiceMapper shawnMendesServiceMapper) {
        this.sampleShawnMendesServerClient = sampleShawnMendesServerClient;
        this.shawnMendesServiceMapper = shawnMendesServiceMapper;
    }
    //tworzymy metodę ktr będzie miała za zadanie pobierać nam piosenki shawna mendesa
    @Override
    public List<Song> fetchAllSongs(){
        String songs = fetchAllShawnMendesSongsFromLocalhost();
        return List.of(new Song(songs));
    }
    private String fetchAllShawnMendesSongsFromLocalhost(){
        String jsonSongs = sampleShawnMendesServerClient.makeGetRequest();
        if(jsonSongs == null){
            log.error("json Songs was null");
            return "";
        }
        SampleServerShawnMendesResponse sampleServerShawnMendesResponse = shawnMendesServiceMapper.mapJsonToSampleShawnMendesResponse(jsonSongs);
        log.info("ShawnMendesService fetched: " + sampleServerShawnMendesResponse);
        return sampleServerShawnMendesResponse.message();
    }
}