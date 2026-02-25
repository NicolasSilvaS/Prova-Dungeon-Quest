package org.example.aula3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        exibirTitulo();

        System.out.println("🦸🏽‍♂ Digite o nome do seu heroí: ️");
        String nomeHeroi = scanner.next();

        Heroi heroi = new Heroi(nomeHeroi, 150,35,5, 1);
        System.out.println("\n✅ Herói criado com sucesso!");
        heroi.exibirStatus();

        Monstro[] monstros = {
            new Monstro("Gremlin", "😡", 30, 7, 7, 70, Item.runaExplosiva),           // leve upgrade
            new Monstro("Kobold", "🦎", 45,12,8, 100, Item.espadaAmaldicoada),        // fraco, mas XP maior
            new Monstro("Ghoul", "🧟", 80,15,12, 150, Item.pergaminhoSagrado),        // médio
            new Monstro("Vampiro Inferior", "🧛‍♀️", 90, 20, 15, 180, Item.elixir),   // forte
            new Monstro("Cavaleiro Esqueleto", "🤺", 110,25,20, 200, null)             // muito forte
        };

        int vitorias = 0;

        for(Monstro monstro: monstros) {
            System.out.println("\n\n🗺️ Você avança pela dungeon...");
            System.out.println("🚪 Um " + monstro.getNome() + " bloqueia o caminho!");
            System.out.println("\n [1] Lutar");
            System.out.println(" [2] Fugir (pula essa batalha)");
            System.out.println(" Escolha: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (Exception e ){
                opcao = 1;
                scanner.nextLine();
            }

            if (opcao == 2) {
                System.out.println(" 🏃🏽 Você fugiu para o proximo corredor...");
                continue;
            }

            Batalha batalha = new Batalha(heroi, monstro, scanner);
            boolean venceu = batalha.iniciar();

            if (venceu) {
                vitorias++;
                System.out.println("\n [Pressione ENTER para continuar]");
                scanner.nextLine();
                scanner.nextLine();
            } else {
                exibirGameOver(nomeHeroi, vitorias, heroi.getXp());
                scanner.close();
                return;
            }

        }

        exibirVitoria(heroi, vitorias);
        scanner.close();
    }

    private static void exibirTitulo() {
        System.out.println("-------------------------------------------");
        System.out.println("-         ⚔️ DUNGEON QUEST                -");
        System.out.println("-  Programação Orientação a Objeto        -");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    private static void exibirGameOver(String nome, int vitorias, int xp) {
        System.out.println("-------------------------------------------");
        System.out.println("-            ☠️ GAME OVER                 -");
        System.out.println("-------------------------------------------");
        System.out.println(" Fim da Jornada de " + nome);
        System.out.println(" Vitórias: "+ vitorias);
        System.out.println(" XP Total: " + xp);
        System.out.println();
    }

    private static void exibirVitoria(Heroi heroi, int vitorias) {
        System.out.println("-----------------------------------------------");
        System.out.println("-           👑 DUNGEON COMPLETA!              -");
        System.out.println("-----------------------------------------------");
        System.out.println(" Parabéns, " + heroi.getNome() + "!");
        System.out.println(" Vitórias: " + vitorias);
        System.out.println(" XP Total: " + heroi.getXp());
        heroi.exibirStatus();
    }
}