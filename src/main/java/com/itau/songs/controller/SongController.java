package com.itau.songs.controller;

import org.springframework.web.bind.annotation.RestController;

import com.itau.songs.model.SongModel;
import com.itau.songs.repository.*;
import com.itau.songs.dtos.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/songs")
public class SongController {

    // injeção de dependências , permite criar essa tabela a partir da estrutura 
    @Autowired
    private SongRepository songRepository;

    @PostMapping("/songs")
    public ResponseEntity<SongModel> saveSong(@RequestBody @Valid SongRecordDTO songRecordDTO) {
        var songModel = new SongModel();
        BeanUtils.copyProperties(songRecordDTO, songModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(songRepository.save(songModel));
    }

    @GetMapping("/api/songs")
    public ResponseEntity<List<SongModel>> getAllSongs() {
        return ResponseEntity.status(HttpStatus.OK).body(songRepository.findAll());
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id){
        Optional<SongModel> song = songRepository.findById(id);

        if(song.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Song was not found - 404");
        }
        return ResponseEntity.status(HttpStatus.OK).body(song.get());
    }

    @PutMapping("/songs/{id}")
    public ResponseEntity<Object> updateSong(@PathVariable(value = "id") UUID id, @RequestBody @Valid SongRecordDTO songRecordDTO) {
        
        Optional<SongModel> song = songRepository.findById(id);
        
        if (song.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Song was not found - 404");
        }

        var songModel = song.get();
        BeanUtils.copyProperties(songRecordDTO, songModel);
        return ResponseEntity.status(HttpStatus.OK).body(songRepository.save(songModel));
    }

    @DeleteMapping("/songs/{id}")
    public ResponseEntity<Object> deleteSong(@PathVariable(value = "id") UUID id) {
        Optional<SongModel> song = songRepository.findById(id);
        
        if (song.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Song was not found - 404");
        }

        songRepository.delete(song.get());
        return ResponseEntity.status(HttpStatus.OK).body("The song was deleted successfully - 200");
    }
    
    
}
