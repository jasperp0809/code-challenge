package com.jasper.antra.advtraining.songcache;

import java.util.List;

public interface SongCache {
    /*
        Record Number of plays for a song
     */
    void recordSongPlays(String songId, int numPlays);

    /*
        Fetch the number of plays for a song
     */
    int getPlaysForSong(String songId);

    /*
        Return the top N songs played, in descending order of number of plays
     */
    List<String> getTopNSongsPlayed(int n);

    void printSong();
}
