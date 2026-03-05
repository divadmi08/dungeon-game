package com.mistri.labyrinthGame.model.abilita;

/**
 * Rappresenta un'abilità usabile in combattimento.
 * tipo: "fisico" | "magia" | "difesa" | "schivata"
 */
public class Abilita {

    public enum Tipo { FISICO, MAGIA, DIFESA, SCHIVATA }

    private final String nome;
    private final Tipo tipo;
    private final int potenza;
    private final int costoMana;
    private final String descrizione;

    public Abilita(String nome, Tipo tipo, int potenza, int costoMana, String descrizione) {
        this.nome        = nome;
        this.tipo        = tipo;
        this.potenza     = potenza;
        this.costoMana   = costoMana;
        this.descrizione = descrizione;
    }

    public String getNome()       { return nome; }
    public Tipo getTipo()         { return tipo; }
    public int getPotenza()       { return potenza; }
    public int getCostoMana()     { return costoMana; }
    public String getDescrizione(){ return descrizione; }

    @Override
    public String toString() {
        return String.format("[%s] %s  (pot:%d  mana:%d) - %s",
                tipo, nome, potenza, costoMana, descrizione);
    }
}
