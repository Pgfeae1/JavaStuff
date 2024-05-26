/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jogo21;

import base.Carta;
import java.util.ArrayList;

/**
 *
 * @author pgfea
 */
class PlayerBJ extends base.Jogador {
    private ArrayList<Carta> mao;

    public PlayerBJ() {
        mao = new ArrayList<>();
    }

    @Override
    public void comprarCarta(Carta carta) {
        mao.add(carta);
    }

    @Override
    public void comprarCartas(ArrayList<Carta> cartas) {
        mao.addAll(cartas);
    }

    @Override
    public void exibirMao() {
        for (Carta carta : mao) {
            carta.exibir();
        }
    }

    public int calcularPontuacao() {
        int pontuacao = 0;
        int ases = 0;

        for (Carta carta : mao) {
            pontuacao += carta.getPontuacao();
            if (carta.getValor().equals("A")) {
                ases++;
            }
        }

        while (pontuacao > 21 && ases > 0) {
            pontuacao -= 10;
            ases--;
        }

        return pontuacao;
    }
}
