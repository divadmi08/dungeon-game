package com.mistri.labyrinthGame.model;

import java.util.Scanner;

public abstract class Personaggio {

    protected String nome;
    protected String emoji;
    protected Stats stats;

    protected int livello = 1;
    protected int esperienza = 0;

    public Personaggio(String nome, String emoji, Stats stats){
        this.nome = nome;
        this.emoji = emoji;
        this.stats = stats;
    }

    public void guadagnaExp(int exp){
        esperienza += exp;

        while(esperienza >= expPerLivello()){
            esperienza -= expPerLivello();
            levelUp();
        }
    }

    private int expPerLivello(){
        return livello * 100;
    }

    protected void levelUp(){
        livello++;
        System.out.println("LEVEL UP! Livello "+livello);

        crescitaClasse(); // automatico

        assegnaPuntiManuali(2); // bonus manuale
    }

    private void assegnaPuntiManuali(int punti){

        Scanner sc = new Scanner(System.in);

        while(punti>0){
            System.out.println("Scegli stat da aumentare:");
            System.out.println("1 Forza 2 Vita 3 Mana 4 Int 5 Stamina");
            int scelta = sc.nextInt();

            switch(scelta){
                case 1: stats.aumentaForza(1); break;
                case 2: stats.aumentaVita(1); break;
                case 3: stats.aumentaMana(1); break;
                case 4: stats.aumentaIntelligenza(1); break;
                case 5: stats.aumentaStamina(1); break;
            }
            punti--;
        }
    }

    protected abstract void crescitaClasse();

    public int getLivello(){
        return livello;
    }
    public Stats getStats(){
        return stats;
    }
    public String getEmoji(){
        return emoji;
    }
}
