package com.jasper.antra.advtraining.songcache;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SongCacheImpl implements SongCache{
    private Map<String,Integer> songList;

    public SongCacheImpl() {
        this.songList = new HashMap<>();
    }

    @Override
    public void recordSongPlays(String songId, int numPlays) {
        songList.put(songId,songList.getOrDefault(songId,0)+numPlays);
    }

    @Override
    public int getPlaysForSong(String songId) {
        return (songList.get(songId) == null) ? -1 : songList.get(songId);
    }

    @Override
    public List<String> getTopNSongsPlayed(int n) {
        List<String> result = new ArrayList<>();

        if(n == 0 || songList == null || songList.isEmpty()) return result;
        if(songList.size() < n){
            throw new IllegalArgumentException("Map size is lower than input n!");
        }
        PriorityQueue<String> heap = new PriorityQueue<>((a,b)->(songList.get(a)-songList.get(b))
        );

        for(String s:songList.keySet()){
            heap.add(s);
            if(heap.size() > n){
                heap.remove();
            }
        }

        for(String s: heap){
            result.add(s);
        }
        List<String> desc = new ArrayList<>();
        int size = result.size();
        for(int i =0; i < size;i++){
            desc.add(result.remove(result.size()-1));
        }

        return desc;
//        return result;
    }

    public void printSong(){
        System.out.println(songList);
    }
}
