/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jogo21;

/**
 *
 * @author pgfea
 */
class CartaBJ extends base.Carta {
    private String naipe;
    private String valor;
    private int pontuacao;

    public CartaBJ(String naipe, String valor, int pontuacao) {
        this.naipe = naipe;
        this.valor = valor;
        this.pontuacao = pontuacao;
    }

    @Override
    public String getNaipe() {
        return naipe;
    }

    @Override
    public String getValor() {
        return valor;
    }

    @Override
    public int getPontuacao() {
        return pontuacao;
    }

    @Override
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public void exibir() {
        System.out.println(valor + " de " + naipe);
    }
}
