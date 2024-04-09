package com.itau.songs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.itau.songs.config.CorsConfig;

@SpringBootApplication
@Import(CorsConfig.class)
public class SongsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongsApplication.class, args);
	}

}
