package com.itau.songs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.songs.model.SongModel;

// JPA repository 
// nome da tabela, chave primária 
public interface SongRepository extends JpaRepository<SongModel, UUID> {
    
}
