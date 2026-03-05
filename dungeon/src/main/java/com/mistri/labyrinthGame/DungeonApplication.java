package com.mistri.labyrinthGame;

import com.mistri.labyrinthGame.main.Main;

/**
 * Entry point per Maven/Spring Boot launcher.
 * Spring non viene usato nel gioco — deleghiamo subito a Main.
 * Se in futuro vuoi un backend REST, reinserisci SpringApplication.run().
 */
public class DungeonApplication {

    public static void main(String[] args) throws Exception {
        Main.main(args);
    }
}
