package com.mistri.labyrinthGame.main;

import com.mistri.labyrinthGame.engine.*;
import com.mistri.labyrinthGame.model.Personaggio;

import java.util.Scanner;

public class Main {

    static String[] emoji = {"☻","♟","♞","♝","♛","♜","♚","⛑︎","㋡","ت"};

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Classe: mago, guerriero, ninja, paladino, assassino");
        String classe = sc.nextLine();

        for(int i=0;i<emoji.length;i++)
            System.out.println(i+" - "+emoji[i]);

        int scelta = sc.nextInt();

        Personaggio p =
                CharacterCreation.crea(classe,nome,emoji[scelta]);

        distribuisciBonus(p);

        Game game = new Game();
        game.start(p);
    }

    static void distribuisciBonus(Personaggio p){

        Scanner sc = new Scanner(System.in);
        int punti=10;

        while(punti>0){
            System.out.println("Punti rimasti: "+punti);
            System.out.println("1 Forza 2 Vita 3 Mana 4 Int 5 Stamina");
            int scelta=sc.nextInt();

            switch(scelta){
                case 1: p.getStats().aumentaForza(1); break;
                case 2: p.getStats().aumentaVita(1); break;
                case 3: p.getStats().aumentaMana(1); break;
                case 4: p.getStats().aumentaIntelligenza(1); break;
                case 5: p.getStats().aumentaStamina(1); break;
            }
            punti--;
        }
    }
}
