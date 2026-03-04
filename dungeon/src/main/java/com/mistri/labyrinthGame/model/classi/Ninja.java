package com.mistri.labyrinthGame.model.classi;

import com.mistri.labyrinthGame.model.*;
import com.mistri.labyrinthGame.model.abilita.Agile;
import com.mistri.labyrinthGame.model.abilita.Attaccante;

public class Ninja extends Personaggio implements Attaccante, Agile {

    public Ninja(String nome, String emoji){
        super(nome, emoji, new Stats(10,8,5,15,20));
    }

    public void attacca(Personaggio b){
        int danno = stats.getStamina()/2;
        b.getStats().setVita(b.getStats().getVita()-danno);
        System.out.println(nome+" attacco furtivo! Danno: "+danno);
    }

    public void schiva(){
        System.out.println(nome+" schiva!");
    }

    public void mostraAbilita(){
        System.out.println("Attacco + Schivata");
    }

    @Override
    protected void crescitaClasse(){
        stats.aumentaStamina(3);
        stats.aumentaIntelligenza(2);
    }
}
