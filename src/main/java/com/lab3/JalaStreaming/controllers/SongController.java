package com.lab3.JalaStreaming.controllers;

import com.lab3.JalaStreaming.models.Song;
import com.lab3.JalaStreaming.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/musicas")
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping
    public ResponseEntity<Song> createSong (@RequestBody Song song) {
        return new ResponseEntity<>(songService.createSong(song), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs(){
        return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongsById(@PathVariable UUID id){
        return  songService.getSongsById(id)
                .map(song -> new ResponseEntity<>(song, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable UUID id, @RequestBody Song updateSong){
        return songService.updateSong(id, updateSong)
                .map(song -> new ResponseEntity<>(song, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable UUID id){
        songService.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
