/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;

import java.util.ArrayList;

/**
 *
 * @author pgfea
 */
public abstract class Baralho {
    
    protected String[] naipes;
    protected String[] valores;
    protected ArrayList<Carta> cartas;
    
    /**
     * Gerar lista de cartas
     */
    public abstract void gerarBaralho();
    /**
     * ysar metodo shuffle da classe Colections
     */
    public abstract void embaralhar();
    /**
    * entrega uma carta do baralho para a mão do jogador
    * @return um objeto do tipo carta
    */
    public abstract Carta darCarta();
    /**
    * entrega uma lista de cartas para a mão do jogador
    * @return ArrayList de cartas
    */
    public abstract ArrayList<Carta> darCartas();
    /**
     * exibir baralho. Para controle interno(testes)
     */
    protected abstract void exibiBaralho();
    /**
     * metodo interno. verifica se baralho esta vazio e gera novo
     */
    protected abstract void verificarEPreencherBaralho();
}
