package com.lab3.JalaStreaming.services;

import com.lab3.JalaStreaming.models.Song;
import com.lab3.JalaStreaming.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SongService {
    @Autowired
    private
    SongRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> getSongsById(UUID id) {
        return songRepository.findById(id);
    }

    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public Optional<Song> updateSong (UUID id, Song updatedSong) {
        Optional<Song> song = songRepository.findById(id);
        if (song.isPresent()) {
            updatedSong.setId(id);
            return Optional.of(songRepository.save(updatedSong));
        }
        return Optional.empty();
    }

    public void deleteSong(UUID id) {songRepository.deleteById(id);}
    
}

