package org.example.songviever;

import org.springframework.stereotype.Component;

import java.util.List;
public interface SongFetchable {
    List<Song> fetchAllSongs();
}
