package Main;

import Classes.OrdenarArquivo;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        // Colocar o caminho do txt a ser ordenado       
        String pathDesordenado = "C:\\Users\\igor_\\OneDrive\\Documentos\\NetBeansProjects\\OrdenaçãoNumeros\\src\\Util\\numerosAleatorios.txt";
        
        //Caminho do local aonde sera criado o arquivo ordenado, final do caminho deve conter o nome a ser dado para o txt como por exemplo "numerosOrdenados.txt"
        String pathOrdenado = "C:\\Users\\igor_\\OneDrive\\Documentos\\NetBeansProjects\\OrdenaçãoNumeros\\src\\Util\\numerosOrdenados.txt";
        
        OrdenarArquivo.ordenarCrescente(pathDesordenado,pathOrdenado);
    }
    
}
