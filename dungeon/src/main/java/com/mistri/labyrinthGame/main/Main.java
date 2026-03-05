package com.mistri.labyrinthGame.main;

import com.mistri.labyrinthGame.engine.CharacterCreation;
import com.mistri.labyrinthGame.engine.Game;
import com.mistri.labyrinthGame.model.Personaggio;

import java.util.Scanner;

/**
 * Punto d'ingresso del gioco.
 *
 * NOTA: Spring Boot non viene usato qui — DungeonApplication viene mantenuta
 * solo perché richiesta da Spring, ma il gioco parte da questo Main direttamente.
 * Per avviare: java -cp target/... com.mistri.labyrinthGame.main.Main
 */
public class Main {

    static final String[] EMOJI = {"☻","♟","♞","♝","♛","♜","♚","⛑","㋡","ت"};

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("╔══════════════════════════╗");
        System.out.println("║   LABYRINTH DUNGEON RPG  ║");
        System.out.println("╚══════════════════════════╝");

        System.out.print("Nome personaggio: ");
        String nome = sc.nextLine().trim();

        System.out.println("Classe: mago | guerriero | ninja | paladino | assassino");
        System.out.print("> ");
        String classe = sc.nextLine().trim();

        System.out.println("Scegli emoji:");
        for (int i = 0; i < EMOJI.length; i++) {
            System.out.println("  " + i + " - " + EMOJI[i]);
        }
        System.out.print("> ");
        int sceltaEmoji = leggiInt(sc, 0, EMOJI.length - 1);

        Personaggio player = CharacterCreation.crea(classe, nome, EMOJI[sceltaEmoji]);

        if (player == null) {
            System.out.println("Classe non valida. Uscita.");
            return;
        }

        // ── Distribuzione punti iniziali (ancora con Scanner, prima di Lanterna) ──
        distribuisciBonus(sc, player, 10);

        System.out.println("\nPremi INVIO per avviare il gioco...");
        sc.nextLine();

        // ── Da qui in poi tutto via Lanterna, niente più Scanner ──
        Game game = new Game();
        game.start(player);
    }

    static void distribuisciBonus(Scanner sc, Personaggio p, int punti) {
        System.out.println("\n── Distribuisci " + punti + " punti bonus ──");
        while (punti > 0) {
            System.out.println("Punti rimasti: " + punti);
            System.out.println("1) Forza  2) Vita  3) Mana  4) Int  5) Stamina");
            System.out.print("> ");
            int s = leggiInt(sc, 1, 5);
            switch (s) {
                case 1 -> p.getStats().aumentaForza(1);
                case 2 -> p.getStats().aumentaVita(1);
                case 3 -> p.getStats().aumentaMana(1);
                case 4 -> p.getStats().aumentaIntelligenza(1);
                case 5 -> p.getStats().aumentaStamina(1);
            }
            punti--;
        }
    }

    /** Legge un intero nel range [min, max], ricicla se input non valido */
    static int leggiInt(Scanner sc, int min, int max) {
        while (true) {
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v >= min && v <= max) return v;
            } catch (NumberFormatException ignored) {}
            System.out.print("Inserisci un numero tra " + min + " e " + max + ": ");
        }
    }
}
