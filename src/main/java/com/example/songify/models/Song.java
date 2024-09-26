package com.example.songify.models;

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

    private String songLength;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", songLength='" + songLength + '\'' +
                ", artist=" + artist +
                '}';
    }
}