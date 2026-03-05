package com.mistri.labyrinthGame.model;

import com.mistri.labyrinthGame.model.abilita.Abilita;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class Personaggio {

    protected String nome;
    protected String emoji;
    protected Stats stats;

    protected int livello    = 1;
    protected int esperienza = 0;

    protected List<Abilita> abilita = new ArrayList<>();

    /**
     * Callback opzionale: viene chiamato quando il player guadagna un level-up
     * con il numero di punti bonus da distribuire.
     * Il Game lo imposta per gestire l'input via Lanterna (niente Scanner).
     */
    private Consumer<Integer> onLevelUp = null;

    public Personaggio(String nome, String emoji, Stats stats) {
        this.nome  = nome;
        this.emoji = emoji;
        this.stats = stats;
    }

    // ── EXP / Level ──────────────────────────────────────────────────────────

    public void guadagnaExp(int exp) {
        esperienza += exp;
        while (esperienza >= expPerLivello()) {
            esperienza -= expPerLivello();
            levelUp();
        }
    }

    private int expPerLivello() {
        return livello * 100;
    }

    private void levelUp() {
        livello++;
        System.out.println("LEVEL UP! Livello " + livello);

        crescitaClasse();           // bonus automatico della classe

        if (onLevelUp != null) {
            onLevelUp.accept(2);    // 2 punti bonus manuali → gestiti da Game via Lanterna
        }
    }

    /**
     * Il Game chiama questo per ricevere i punti bonus da distribuire
     * e li gestisce con input Lanterna, senza Scanner.
     */
    public void setOnLevelUp(Consumer<Integer> callback) {
        this.onLevelUp = callback;
    }

    // ── Abilità ──────────────────────────────────────────────────────────────

    public void aggiungiAbilita(Abilita a) {
        abilita.add(a);
    }

    public List<Abilita> getAbilita() {
        return abilita;
    }

    // ── Getters ──────────────────────────────────────────────────────────────

    public String getNome()    { return nome; }
    public String getEmoji()   { return emoji; }
    public int    getLivello() { return livello; }
    public Stats  getStats()   { return stats; }

    // ── Overridable ──────────────────────────────────────────────────────────

    /** Ogni classe definisce la propria crescita automatica a ogni level-up */
    protected abstract void crescitaClasse();
}
