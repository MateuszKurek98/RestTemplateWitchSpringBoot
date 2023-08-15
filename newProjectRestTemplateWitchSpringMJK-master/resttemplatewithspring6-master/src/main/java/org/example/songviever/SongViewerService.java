package org.example.songviever;

import org.example.itunes.proxy.ItunesResult;
import org.example.itunes.service.ItunesService;
import org.example.sampleshawnmendes.service.ShawnMendesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SongViewerService {
//    private final List<SongFetchable> songFetchable;
//
//    public SongViewerService(List<SongFetchable> songFetchable) {
//        this.songFetchable = songFetchable;
//    }
    private final SongFetchable songFetchable;

    @Autowired
    SongViewerService(@Qualifier("itunesService") SongFetchable songFetchable){
        this.songFetchable = songFetchable;
    }

    public List<Song> viewAllSongs(){
//        List<Song> itunesResults = itunesService.fetchAllSongs();
//        List<Song> songs = shawnMendesService.fetchAllSongs();

        List<Song> songsToView = new ArrayList<>();
//        songFetchable.forEach(
//                songService -> songsToView.addAll(songService.fetchAllSongs())
//        );
        songsToView.addAll(songFetchable.fetchAllSongs());
        return songsToView;
    }
}
