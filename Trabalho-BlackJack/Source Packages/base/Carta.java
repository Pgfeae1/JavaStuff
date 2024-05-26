/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;

/**
 *
 * @author pgfea
 */
public abstract class Carta {
    protected String naipe;
    protected String valor;
    protected int pontuacao;
    
    
    public abstract String getNaipe();
    public abstract String getValor();
    public abstract int getPontuacao();
    public abstract void setPontuacao(int pontuacao);
    public abstract void exibir();
    
    
}
