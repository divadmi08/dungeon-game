package com.mistri.labyrinthGame.world;

public class Labirinto {

    private char[][] mappa = {
            {'▓','▓','▓','▓','▓','▓','▓'},
            {'▓',' ',' ',' ','▓',' ','▓'},
            {'▓',' ','▓',' ','▓',' ','▓'},
            {'▓',' ','▓',' ',' ',' ','▓'},
            {'▓','▓','▓','▓','▓','▓','▓'}
    };

    public char[][] getMappa(){
        return mappa;
    }
}