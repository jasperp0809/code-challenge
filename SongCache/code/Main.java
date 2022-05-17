package com.jasper.antra.advtraining;

import com.jasper.antra.advtraining.songcache.SongCache;
import com.jasper.antra.advtraining.songcache.SongCacheImpl;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SongCache song = new SongCacheImpl();
        song.recordSongPlays("ID-1",3);
        song.recordSongPlays("ID-1", 1);
        song.recordSongPlays("ID-2", 2);
        song.recordSongPlays("ID-3", 5);

        System.out.printf(song.getPlaysForSong("ID-2") + " times\n");
        System.out.println(song.getTopNSongsPlayed(2));
        song.printSong();
    }
}
