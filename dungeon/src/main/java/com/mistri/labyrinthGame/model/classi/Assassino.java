package com.mistri.labyrinthGame.model.classi;

import com.mistri.labyrinthGame.model.*;
import com.mistri.labyrinthGame.model.abilita.Agile;
import com.mistri.labyrinthGame.model.abilita.Attaccante;

public class Assassino extends Personaggio implements Attaccante, Agile {

    public Assassino(String nome, String emoji){
        super(nome, emoji, new Stats(18, 7, 5, 10, 20));
    }

    public void attacca(Personaggio b){
        int danno = (stats.getForza()+stats.getStamina())/3;
        b.getStats().setVita(b.getStats().getVita()-danno);
        System.out.println("Colpo critico! "+danno);
    }

    public void schiva(){
        System.out.println("Sparisce nell'ombra!");
    }

    public void mostraAbilita(){
        System.out.println("Critico + Schivata");
    }

    @Override
    protected void crescitaClasse(){
        stats.aumentaStamina(3);
        stats.aumentaForza(2);
    }
}
