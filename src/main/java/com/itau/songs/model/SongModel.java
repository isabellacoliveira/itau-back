package com.itau.songs.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// dizer que a classe é a entidade 
@Entity
public class SongModel {
    // iformar chave primaria do banco 
    @Id
    // gerar automatico o valor do ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String artist;

    @Column(nullable = false)
    private String image;

    private Boolean isSaved;

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id; 
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title; 
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist; 
    }

    public String getImage(){
        return image;
    }

    public void setId(String image){
        this.image = image; 
    }

    public Boolean getIsSaved(){
        return isSaved;
    }

    public void setId(Boolean isSaved){
        this.isSaved = isSaved; 
    }
}
