package Jogo21;

import java.util.Scanner;



/**
 *
 * @author pgfea
 */


public class TrabalhoBlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente = true;

        while (jogarNovamente) {
            BaralhoBJ baralho = new BaralhoBJ();
            baralho.gerarBaralho();
            baralho.embaralhar();

            DealerBJ dealer = new DealerBJ();
            PlayerBJ player = new PlayerBJ();

            player.comprarCartas(baralho.darCartas());
            dealer.comprarCartas(baralho.darCartas());

            // Exibir as mãos antes de verificar o Blackjack
            System.out.println("Mão do Jogador:");
            player.exibirMao();
            System.out.println("Pontuação do Jogador: " + player.calcularPontuacao());

            System.out.println("Mão do Dealer:");
            dealer.exibirMaoParcial();
            System.out.println("Pontuação do Dealer: " + dealer.calcularPontuacaoParcial());
            if (verificarBlackjack(player, dealer)) {
                jogarNovamente = perguntarJogarNovamente(scanner);
                continue;
            }

            boolean continuarJogando = true;
            while (continuarJogando && player.calcularPontuacao() < 21) {
                System.out.println("Deseja comprar mais uma carta? (s/n)");
                String resposta = scanner.nextLine();
                if (resposta.equalsIgnoreCase("s")) {
                    player.comprarCarta(baralho.darCarta());
                    System.out.println("Mão do Jogador:");
                    player.exibirMao();
                    System.out.println("Pontuação do Jogador: " + player.calcularPontuacao());
                } else {
                    continuarJogando = false;
                }
            }

            // Turno do dealer
            dealer.revelarCartaOculta();
            while (dealer.calcularPontuacao() < 17) {
                dealer.comprarCarta(baralho.darCarta());
            }

            // Exibir todas as cartas do dealer e sua pontuação final
            System.out.println("Mão do Dealer:");
            dealer.exibirMao();
            System.out.println("Pontuação Final do Dealer: " + dealer.calcularPontuacao());

            // Determinar o vencedor
            determinarVencedor(player, dealer);

            jogarNovamente = perguntarJogarNovamente(scanner);
        }

        scanner.close();
    }

    private static boolean verificarBlackjack(PlayerBJ player, DealerBJ dealer) {
        if (player.calcularPontuacao() == 21 && dealer.calcularPontuacao() == 21) {
            System.out.println("Empate com Blackjack! Ninguém vence.");
            return true;
        } else if (player.calcularPontuacao() == 21) {
            System.out.println("Jogador tem Blackjack! Jogador vence.");
            return true;
        } else if (dealer.calcularPontuacao() == 21) {
            System.out.println("Dealer tem Blackjack! Dealer vence.");
            return true;
        }
        return false;
    }

    private static void determinarVencedor(PlayerBJ player, DealerBJ dealer) {
        int pontuacaoPlayer = player.calcularPontuacao();
        int pontuacaoDealer = dealer.calcularPontuacao();

        if (pontuacaoPlayer > 21) {
            System.out.println("Jogador estourou! Dealer vence.");
        } else if (pontuacaoDealer > 21) {
            System.out.println("Dealer estourou! Jogador vence.");
        } else if (pontuacaoPlayer > pontuacaoDealer) {
            System.out.println("Jogador vence com " + pontuacaoPlayer + " pontos.");
        } else if (pontuacaoDealer > pontuacaoPlayer) {
            System.out.println("Dealer vence com " + pontuacaoDealer + " pontos.");
        } else {
            System.out.println("Empate!");
        }
    }

    private static boolean perguntarJogarNovamente(Scanner scanner) {
        System.out.println("Deseja jogar novamente? (s/n)");
        String resposta = scanner.nextLine();
        return resposta.equalsIgnoreCase("s");
    }
}

