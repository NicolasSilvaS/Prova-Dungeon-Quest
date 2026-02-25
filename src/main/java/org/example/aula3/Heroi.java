package org.example.aula3;

import java.util.ArrayList;

public class Heroi {
    ArrayList<Item> inventario = new ArrayList<>();

    private String nome;
    private int vidaMaxima;
    private int vidaAtual;
    private int ataque;
    private int defesa;
    private int pocoes;
    private int xp;
    private int level;
    private int levelMaximo = 10;

    public Heroi(String nome, int vida, int ataque, int defesa, int level) {
        this.nome = nome;
        this.vidaMaxima = vida;
        this.vidaAtual = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.pocoes = 3;
        this.xp = 0;
        this.level = 1;
    }

    //Getters
    public String getNome() {return nome;}
    public int getVida()    { return  vidaAtual; }
    public int getVidaMax()    { return  vidaMaxima; }
    public int getAtaque()  { return ataque; }
    public int getDefesa()  { return defesa; }
    public int getPocoes()  { return pocoes; }
    public int getXp()      { return xp; }
    public int getLevel() {return level;}
    public int getlevelMaximo() {return levelMaximo;}

    //Setters
     public void setVida(int vidaAtual) {
    this.vidaAtual = vidaAtual;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLevelMaximo(int levelMaximo) {
        this.levelMaximo = levelMaximo;
    }

    public void setvidaMax(int vidaMax) {
        this.vidaMaxima = vidaMax;
    }

    //Metodos 
    public int atacar() {
        int variacao = (int)(Math.random() * 10) - 5;
        return ataque + variacao;
    }

    public void receberDano(int dano) {
        int danoReal = dano - defesa;
        if(danoReal < 1) danoReal = 1;

        vidaAtual -= danoReal;
        if(vidaAtual < 0) vidaAtual = 0;

        System.out.println(" 💔" + nome + " recebeu " + danoReal + " de dano! "
        + "[❤️ " + vidaAtual + "/" + vidaMaxima + "]");

    }

    public boolean usarPocao() {
        if (pocoes <= 0) {
            System.out.println(" ❌ Sem poções!");
            return false;
        }
        if (vidaAtual == vidaMaxima){
            System.out.println(" ⚠️ Vida já está cheia! Poção não foi usada.");
            return false;
        }

        int cura = 30;
        vidaAtual += cura;
        if ( vidaAtual > vidaMaxima) vidaAtual = vidaMaxima;

        pocoes--;
        System.out.println(" 🧪 " + nome + " usou poção! +30 💚 "
                + "[💚 " + vidaAtual + "/" + vidaMaxima + "] [Poções: " + pocoes + "]");
        return true;
    }

    public int usarItem(int i) {

    if (i < 0 || i >= inventario.size()) {
        System.out.println("❌ Item inválido! Turno perdido.");
        return 0;
    }

    Item item = inventario.get(i);
    inventario.remove(i);

    if (item.getTipo().equals("ataque")) {
        System.out.println("💥 " + nome + " usou " + item.getNome());
        return item.getValor();
    }

    if (item.getTipo().equals("cura")) {
        vidaAtual += item.getValor();
        if (vidaAtual > vidaMaxima)
            vidaAtual = vidaMaxima;

        System.out.println("💚 Curou " + item.getValor() + " de vida!");
        return 0;
    }

    return 0;
    }

    public void ganharXp(int quantidade) {
        xp += quantidade;
        System.out.println(" ⭐⬆️" + quantidade + " XP! [Total: " + xp + "]");
    }

    public boolean estaVivo() {
        return vidaAtual > 0;
    }

    public void exibirStatus() {
        System.out.println("\n🦸‍♂️ " + nome);
        System.out.println(" ❤️ Vida: " + vidaAtual + "/" + vidaMaxima);
        System.out.println(" ⚔️ Ataque: " + ataque);
        System.out.println(" 🛡️ Defesa: " + defesa);
        System.out.println(" 🧪 Poções: " + pocoes);
        System.out.println(" ⭐ XP: " + xp);

    }

    public void listarInventario() {
    for (int i = 0; i < inventario.size(); i++) {
        Item item = inventario.get(i);
        System.out.println("[" + i + "] " + item.getNome() + " (" + item.getTipo() + ")");
    }
    }

    public void addInv(Item item) {
        inventario.add(item);
    }

    public void removeInv(int i) {
        inventario.remove(i);
    }

}
