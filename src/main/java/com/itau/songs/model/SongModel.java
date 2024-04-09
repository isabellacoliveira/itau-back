package com.itau.songs.model;

import java.util.UUID;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@Data
@Entity
@Table(name = "SONGS")
public class SongModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String artist;
    private String image;
    private Boolean isSaved;

}

