package com.itau.songs.dtos;

public record SongRecordDTO(
        String title,
        String artist,
        String image,
        Boolean isSaved) {

}
