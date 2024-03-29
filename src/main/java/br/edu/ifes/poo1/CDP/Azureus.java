/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CDP;

import br.edu.ifes.poo1.CCI.ControleTotal;
import br.edu.ifes.poo1.CGT.Movimentacao;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Henrique
 */
//Azureus é o nosso jogador burro.
public class Azureus implements Serializable {

    
    
    private Random gerador = new Random();
    private String posAtual, posProx, posicao, jogada;
    private int numAux;
    private boolean jogadaValida;

    public String processaJogadaAzureus(Tabuleiro tabuleiro, ControleTotal control, Movimentacao move) {
        jogadaValida = false;
        while (!jogadaValida) {
            posAtual = geraPos();
            if (tabuleiro.retornaPeca(posAtual) != null) {//Verifica se a peça EXISTE
                if (!tabuleiro.retornaPeca(posAtual).getCor().toString().equals("BRANCO")) {//verifica se a peça é PRETA
                    for (int i = 0; i < 10; i++) {
                        posProx = geraPos();
                        if (tabuleiro.retornaPeca(posProx) == null) {//posição PROX = VAZIO
                            //testa movimento
                            if ((tabuleiro.retornaPeca(posAtual).podeAndarQuanto(posAtual, posProx))&&(move.caminhoLivre(posAtual, posProx, tabuleiro.retornaPeca("" + posAtual.charAt(0) + posAtual.charAt(1)).getNome().getApelidoPeca().toString(), tabuleiro.retornaPeca("" + posAtual.charAt(0) + posAtual.charAt(1)).getCor().toString(),tabuleiro))) {
                                return posAtual + posProx;
                                
                            }
                        }else if (tabuleiro.retornaPeca(posAtual).getCor().toString().equals("BRANCO")) {//posicao prox = BRANCO
                            //testa captura
                            if (tabuleiro.retornaPeca(posAtual).podeCapturar(posAtual, posProx)) {
                                return posAtual + "x" + posProx;
                            }

                        }
                    }

                }
            }

        }
        return "desistir";
    }

    //Gerando posiçãoAtual Aleatoria entre 1e8 com 2 caracteres
    private String geraPos() {
        posicao = "";
        while (posicao.length() < 2) {
            numAux = gerador.nextInt(9);
            if (numAux != 0) {
                posicao += Integer.toString(numAux);
            }
        }
        return posicao;
    }

}
