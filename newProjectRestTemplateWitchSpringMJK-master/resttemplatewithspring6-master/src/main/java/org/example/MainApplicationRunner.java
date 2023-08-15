package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.example.itunes.service.ItunesService;
import org.example.sampleshawnmendes.service.ShawnMendesService;
import org.example.songviever.Song;
import org.example.songviever.SongViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class MainApplicationRunner {
    private final SongViewerService songViewerService;
    @Autowired
    public MainApplicationRunner(SongViewerService songViewerService) {
        this.songViewerService = songViewerService;
    }

    public void run(){
        List<Song> songs = songViewerService.viewAllSongs();
        log.info(songs);
    }
}
