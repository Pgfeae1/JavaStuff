/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jogo21;

import base.Carta;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author pgfea
 */
class BaralhoBJ extends base.Baralho {
    private ArrayList<Carta> cartas;

    @Override
    public void gerarBaralho() {
        String[] naipes = {"Copas", "Ouros", "Espadas", "Paus"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        cartas = new ArrayList<>();

        for (String naipe : naipes) {
            for (String valor : valores) {
                int pontuacao;
                switch (valor) {
                    case "A":
                        pontuacao = 11;
                        break;
                    case "K":
                    case "Q":
                    case "J":
                        pontuacao = 10;
                        break;
                    default:
                        pontuacao = Integer.parseInt(valor);
                        break;
                }
                cartas.add(new CartaBJ(naipe, valor, pontuacao));
            }
        }
    }

    @Override
    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    @Override
    public Carta darCarta() {
        return cartas.remove(0);
    }

    @Override
    public ArrayList<Carta> darCartas() {
        ArrayList<Carta> mao = new ArrayList<>();
        mao.add(darCarta());
        mao.add(darCarta());
        return mao;
    }

    @Override
    protected void exibiBaralho() {
        for (Carta carta : cartas) {
            carta.exibir();
        }
    }

    @Override
    protected void verificarEPreencherBaralho() {
        if (cartas.size() < 15) {
            gerarBaralho();
            embaralhar();
        }
    }
}
