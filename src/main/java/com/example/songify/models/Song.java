package com.example.songify.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String songName;

    private String artist;

    private String songLength;

    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    @JsonIgnoreProperties("songs") // This is mandatory, so the json isn't recursive
    private Album album;


    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", artist='" + artist + '\'' +
                ", songLength='" + songLength + '\'' +
                ", album=" + album +
                '}';
    }
}