package com.example.songify.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String releaseDate;

    @OneToMany(mappedBy = "album")
    @JsonIgnoreProperties("album") // This is mandatory, so the json isn't recursive
    private List<Song> songs;


}