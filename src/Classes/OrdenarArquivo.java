/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.*;

/**
 *
 * @author igor_
 */
public class OrdenarArquivo {

    public static int contadorDeLinhas(String caminho) throws FileNotFoundException, IOException {

        LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(new FileInputStream(caminho)));
        String nextLine;
        int qtd = 0;

        while ((nextLine = lineCounter.readLine()) != null) {
            if (nextLine == null) {
                break;
            }
            qtd++;
        }
        return qtd;
    }

    public static void ordenarCrescente(String caminhoDesordenado, String caminhoOrdenado) throws IOException {
        BufferedReader lerArquivo = new BufferedReader(new FileReader(caminhoDesordenado));

        int qtd = contadorDeLinhas(caminhoDesordenado);
        int numeros[] = new int[qtd];
        int j, chave, i;
        String linha;
        String result;

        for (int k = 0; k < qtd; k++) {
            linha = lerArquivo.readLine().trim();
            numeros[k] = Integer.valueOf(linha);
        }
        lerArquivo.close();

        for (j = 1; j < qtd; j++) {
            chave = numeros[j];
            for (i = j - 1; (i >= 0) && (numeros[i] > chave); i--) {
                numeros[i + 1] = numeros[i];
            }
            numeros[i + 1] = chave;
        }

        File file = new File(caminhoOrdenado);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter escreverArquivo = new BufferedWriter(new FileWriter(file));
        for (int y = 0; y < qtd; y++) {
            result = String.valueOf(numeros[y]);
            escreverArquivo.write(result + "\n");
        }

        escreverArquivo.close();
        System.out.println("Arquivo ordenado com sucesso");
    }
}
