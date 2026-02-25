package org.example.aula3;

import java.util.Scanner;

public class Batalha {

    private Heroi heroi;
    private Monstro monstro;
    private Scanner scanner;

    public Batalha(Heroi heroi, Monstro monstro, Scanner scanner) {
        this.heroi = heroi;
        this.monstro = monstro;
        this.scanner = scanner;
    }

    /**
     * Inicia e controla o loop de batalha
     * @return true se o heroi venceu, false se foi derrotado.
     */

    public boolean iniciar() {
        exibirCabecalhoBatalha();

        int turno = 1;

        while (heroi.estaVivo() && monstro.estaVivo()) {
            System.out.println("-------------- Turno " + turno + " -------------");
            exibirStatusBatalha();

            turnoHeroi(); // jogador escolhe a ação

            if (monstro.estaVivo()) {
                turnoMonstro();
            }
            turno++;
        }

        return resolverFinal();
    }

    //---------------- Metodos Privados ---------------------

    private void turnoHeroi() {
        System.out.println("\n O que " + heroi.getNome() + " faz?");
        System.out.println(" [1] Atacar");
        System.out.println(" [2] Usar Poção ( " +heroi.getPocoes() + " restantes)");
        System.out.println(" [3] Inventario ");
        System.out.println(" Escolha: ");

        int escolha = lerEscolha();

        switch (escolha) {
            case 1:
                int dano = heroi.atacar();
                System.out.println("\n ⚔️ " + heroi.getNome() + " atacou por " + dano + "!");
                monstro.receberDano(dano);
                break;
            case 2:
                heroi.usarPocao();
                break;
            case 3:
                if (heroi.inventario.isEmpty()) {
                    System.out.println("Não há items!");
                    System.out.println("Turno Perdido!!");
                } else {
                    heroi.listarInventario();
                    System.out.println("Escolha o item!");
                    int escolhaItem = lerEscolha();

                int danoItem = heroi.usarItem(escolhaItem);
                monstro.receberDano(danoItem);
                }
                break;
            default:
                System.out.println(" ❓ Opção inválida - turno perdido!!");
        }
    }

    private void turnoMonstro() {
        int dano = monstro.atacar();
        System.out.println("\n " + monstro.getNome() + " ataca por " + dano + "!");
        heroi.receberDano(dano);
    }

    private boolean resolverFinal() {
        System.out.println("\n------------------------------------");
        if (heroi.estaVivo()) {
            System.out.println(" 🎉 VITÓRIA!");
            System.out.println(" Você derrotou " + monstro.getNome() + "!");
            heroi.ganharXp(monstro.getXpRecompensa());
            heroi.inventario.add(monstro.getDrop());
            levelUp(heroi);
            return true;
        } else {
            System.out.println(" 💀 DERROTA!");
            System.out.println(" " + heroi.getNome() + " foi derrotado...");
            return false;
        }
    }

    private void exibirCabecalhoBatalha() {
        System.out.println("---------------------------------");
        System.out.println("     ⚔️ BATALHA INICIADA!        ");
        System.out.println("----------------------------------");
        System.out.println(" " + heroi.getNome() + " vs " + monstro.getNome());
    }

    private void exibirStatusBatalha() {
        heroi.exibirStatus();
        System.out.println();
        monstro.exibirStatus();
    }

    private int lerEscolha() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    public void levelUp(Heroi heroi) {
    int xp = heroi.getXp();
    int level = heroi.getLevel();

    switch (level) {
        case 1:
            if (xp >= 100) {
                heroi.setLevel(2);
                heroi.setAtaque(heroi.getAtaque() + 5);
                heroi.setDefesa(heroi.getDefesa() + 2);
                heroi.setvidaMax(heroi.getVidaMax() + 20);
                System.out.println("🎉✨ Parabéns " + heroi.getNome() + "! Você subiu para o nível 2!");
                System.out.println("⚔️ Ataque +5 | 🛡 Defesa +2 | ❤️ Vida +20");
            }
            break;

        case 2:
            if (xp >= 250) {
                heroi.setLevel(3);
                heroi.setAtaque(heroi.getAtaque() + 7);
                heroi.setDefesa(heroi.getDefesa() + 3);
                heroi.setvidaMax(heroi.getVidaMax() + 25);
                System.out.println("🎉✨ Parabéns " + heroi.getNome() + "! Você subiu para o nível 3!");
                System.out.println("⚔️ Ataque +7 | 🛡 Defesa +3 | ❤️ Vida +25");
            }
            break;

        case 3:
            if (xp >= 450) {
                heroi.setLevel(4);
                heroi.setAtaque(heroi.getAtaque() + 10);
                heroi.setDefesa(heroi.getDefesa() + 4);
                heroi.setvidaMax(heroi.getVidaMax() + 30);
                System.out.println("🎉✨ Parabéns " + heroi.getNome() + "! Você subiu para o nível 4!");
                System.out.println("⚔️ Ataque +10 | 🛡 Defesa +4 | ❤️ Vida +30");
            }
            break;

        case 4:
            if (xp >= 700) {
                heroi.setLevel(5);
                heroi.setAtaque(heroi.getAtaque() + 12);
                heroi.setDefesa(heroi.getDefesa() + 5);
                heroi.setvidaMax(heroi.getVidaMax() + 35);
                System.out.println("🎉✨ Parabéns " + heroi.getNome() + "! Você subiu para o nível 5!");
                System.out.println("⚔️ Ataque +12 | 🛡 Defesa +5 | ❤️ Vida +35");
            }
            break;

        default:
            break;
    }
}
}
