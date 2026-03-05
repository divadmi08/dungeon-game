package com.mistri.labyrinthGame.model;

public class Nemico {

    private String nome;
    private String emoji;
    private int vitaMax;
    private int vitaCorrente;
    private int forza;
    private int expDato;

    public Nemico(String nome, String emoji, int vita, int forza, int expDato) {
        this.nome = nome;
        this.emoji = emoji;
        this.vitaMax = vita;
        this.vitaCorrente = vita;
        this.forza = forza;
        this.expDato = expDato;
    }

    public String getNome()     { return nome; }
    public String getEmoji()    { return emoji; }
    public int getVita()        { return vitaCorrente; }
    public int getVitaMax()     { return vitaMax; }
    public int getForza()       { return forza; }
    public int getExpDato()     { return expDato; }

    public void subisciDanno(int danno) {
        vitaCorrente = Math.max(0, vitaCorrente - danno);
    }

    public boolean isVivo() {
        return vitaCorrente > 0;
    }

    /** Descrizione breve per il log di combattimento */
    public String statusBar() {
        return nome + " " + emoji + "  HP: " + vitaCorrente + "/" + vitaMax;
    }
}
