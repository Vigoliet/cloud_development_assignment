package com.example.songify.controllers;

import com.example.songify.models.Album;
import com.example.songify.models.Song;
import com.example.songify.repositories.AlbumRepository;
import com.example.songify.repositories.SongRepository;
import com.example.songify.xray.XRayTimed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @XRayTimed
    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        return (List<Song>) songRepository.findAll();
    }

    @XRayTimed
    @PostMapping("/addSong")
    public Song addSong(@RequestBody Song song) {
        return songRepository.save(song);
    }

    @GetMapping("/albums")
    public List<Album> getAlbums() {
        return (List<Album>) albumRepository.findAll();
    }
}