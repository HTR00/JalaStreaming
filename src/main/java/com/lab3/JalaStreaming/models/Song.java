package com.lab3.JalaStreaming.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Song")
@NoArgsConstructor
public class Song {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    @Column (nullable = false)
    private String artist;

    @Column (nullable = false)
    private  String songName;

    @Column (nullable = false)
    private Double songDuration;

    @Column (nullable = true)
    private LocalDateTime insertDate;

    @Column (nullable = false)
    private Date launchDate;

    @Column (nullable = false)
    private String genre;

    public Song(String artist, String songName, Double songDuration, String genre, Date launchDate) {
        this.artist = artist;
        this.songName = songName;
        this.songDuration = songDuration;
        this.insertDate = LocalDateTime.now();
        this. genre = genre;
        this.launchDate = launchDate;
    }

    public Song (UUID id) {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public String getSongName() {
        return songName;
    }

    public Double getSongDuration() {
        return songDuration;
    }

    public String getGenre() { return genre;}

    public LocalDateTime getInsertDate() {
        return LocalDateTime.now();
    }

    public Date getLaunchDate() {
        return launchDate;
    }
}