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
public abstract class Jogador {
    
    protected ArrayList<Carta> maoJogador;
    protected int numCartas;
    
    /**
     * Adciona uma carta do baralho para a mão
     * @param carta carta comprada do baralho
     */
    public abstract void comprarCarta(Carta carta);
    public abstract void comprarCartas(ArrayList<Carta> carta);
    public abstract void exibirMao();
}
