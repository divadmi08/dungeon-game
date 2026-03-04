package com.mistri.labyrinthGame.engine;

import com.mistri.labyrinthGame.model.Personaggio;
import com.mistri.labyrinthGame.model.classi.*;

public class CharacterCreation {

    public static Personaggio crea(String tipo, String nome, String emoji){
        switch(tipo.toLowerCase()){
            case "mago": return new Mago(nome,emoji);
            case "guerriero": return new Guerriero(nome,emoji);
            case "ninja": return new Ninja(nome,emoji);
            case "paladino": return new Paladino(nome,emoji);
            case "assassino": return new Assassino(nome,emoji);
            default: return null;
        }
    }
}
