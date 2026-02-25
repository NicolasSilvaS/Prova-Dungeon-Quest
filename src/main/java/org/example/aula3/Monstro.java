package org.example.aula3;

public class Monstro {
    private String nome;
    private String emoji;
    private int vida;
    private int ataque;
    private int defesa;
    private int xpRecompensa;
    private Item drop;

    public Monstro(String nome, String emoji, int vida, int ataque, int defesa, int xpRecompensa, Item drop) {
        this.nome = nome;
        this.emoji = emoji;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.xpRecompensa = xpRecompensa;
        this.drop = drop;
    }

    public String getNome() { return emoji + " " + nome; }
    public int getVida() { return vida;}
    public int getXpRecompensa() {return  xpRecompensa; }
    public Item getDrop() {return drop;}

    public int atacar() {
        int variacao = (int)(Math.random() * 8);
        return ataque + variacao;
    }

    public void receberDano(int dano) {
        int danoReal = dano - defesa;
        if(danoReal < 1) danoReal = 1;

        vida -= danoReal;
        if(vida < 0) vida = 0;

        System.out.println(" 🗡️" + nome + " recebeu " + danoReal + " de dano! "
                + "[❤️ " + vida +  "]");

    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void exibirStatus() {
        System.out.println(emoji + " " + nome);
        System.out.println(" ❤️ | Vida: " + vida);
        System.out.println(" ⚔️ | Ataque: " + ataque);
        System.out.println(" 🛡️ | Defesa: " + defesa);
    }
}
