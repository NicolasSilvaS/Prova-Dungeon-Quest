package org.example.aula3;

public class Item {

    private String nome;
    private String tipo;
    private int valor;

    public Item(String nome, String tipo, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    //Items
    public static Item pergaminhoSagrado =
            new Item("Pergaminho Sagrado", "ataque", 50);

    public static Item elixir =
            new Item("Elixir", "cura", 100);

    public static Item espadaAmaldicoada =
            new Item("Espada Amaldiçoada", "ataque", 40);

    public static Item runaExplosiva =
            new Item("Runa Explosiva", "ataque", 70);


    public void usar(Heroi heroi) {
        if(tipo.equals("cura")) {
            heroi.usarPocao();
            System.out.println(" 🧪" + nome + " foi usado!");
        } else if (tipo.equals("ataque")) {
            System.out.println(" 🔥" + nome + " foi usado");
        }
    }

    public String getDescricao() {
        return nome + " [" + tipo + " +" + valor + "]";
    }

    public String getNome() {return nome; }
    public String getTipo() { return tipo; }
    public int getValor() { return valor; }
}
