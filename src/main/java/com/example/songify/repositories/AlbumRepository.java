package com.example.songify.repositories;


import com.example.songify.models.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {
}
