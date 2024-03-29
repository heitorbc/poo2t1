/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CGD;
import br.edu.ifes.poo1.CIH.Impressao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Henrique
 */
public class Dados <T extends Serializable> {

    private ArrayList<T> dados = new ArrayList<T>();

    public void savePartida(T partida) throws ClassNotFoundException {

        try {
            /*Tenta salvar os dados do usuario*/
            ArrayList<T> partidasCarregadas = loadPartida();
            partidasCarregadas.add(partida);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\partidas.dat"));
            out.writeObject(partidasCarregadas);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<T> loadPartida() throws ClassNotFoundException {

        try {

            File testeArquivo = new File("D:\\partidas.dat");
            if (testeArquivo.exists()) {
                /*Se o arquivo existir ele faz o load*/
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\partidas.dat"));
                ArrayList<T> partidaReturn = (ArrayList<T>) in.readObject();
                in.close();
                return partidaReturn;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<T>();
    }

}
