/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CDP.Pecas;

import br.edu.ifes.poo1.CDP.PecaAbstrata;
import br.edu.ifes.poo1.util.Cor;
import br.edu.ifes.poo1.util.PecaNome;
import java.io.Serializable;

/**
 * @author 20121BSI0082
 */
public class Cavalo extends PecaAbstrata implements Serializable{ 

    
    public Cavalo(Cor cor) {
        super(cor, PecaNome.CAVALO);
    }
    //Verifica se pode andar a quantidade solicitada    
    @Override
    public boolean podeAndarQuanto(String posicaoAtual, String proximaPosicao) {
        return (Math.abs(posicaoAtual.charAt(1) - proximaPosicao.charAt(1)) == 1) &&
               (Math.abs(posicaoAtual.charAt(0) - proximaPosicao.charAt(0)) == 2) || 
               (Math.abs(posicaoAtual.charAt(1) - proximaPosicao.charAt(1)) == 2) &&
               (Math.abs(posicaoAtual.charAt(0) - proximaPosicao.charAt(0)) == 1);
    }
    @Override
    public boolean podeCapturar(String posicaoAtual, String proximaPosicao) {

        return podeAndarQuanto(posicaoAtual, proximaPosicao);
    }
    
}
