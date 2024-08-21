package com.example.songify.controllers;

import com.example.songify.models.Song;
import com.example.songify.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SongController {

    @Autowired
    private SongRepository songRepository;


    @GetMapping("/songs")
    public List<Song> getAllSongs(){
        return (List<Song>) songRepository.findAll();
    }

    @PostMapping("/addSong")
    public Song addSong(@RequestBody Song song) {
        return songRepository.save(song);
    }

}
