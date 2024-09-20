// src/main/java/com/example/songify/SongifyApplication.java
package com.example.songify;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class SongifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongifyApplication.class, args);
	}
}