import java.util.Scanner;

public class Main {
    public static String encryption(String s) {
        String resultado = "";
        int numeroColunas = (int) Math.ceil(Math.sqrt(s.length()));
        int arredondadoBaixo = (int) Math.floor(Math.sqrt(s.length()));
        int numeroLinhas;
        //Verifica se o produtos dos inteiros nbs quais a raíz do tamanho do texto está entre é maior que o tamanho em si
        if (numeroColunas*arredondadoBaixo < s.length()){
            numeroLinhas = numeroColunas;
        }else {
            numeroLinhas = arredondadoBaixo;
        }
        String[] textoReescrito = new String[numeroLinhas];
        //Reescreve o texto original separado em uma matriz
        for(int i = 0; i < numeroLinhas; i++){
            String parteReescrita = "";
            for (int j = 0; j < numeroColunas; j++){
                if (i*numeroColunas+j < s.length()) {
                    parteReescrita += s.toCharArray()[i * numeroColunas + j];
                }
            }
            textoReescrito[i] = parteReescrita;
        }
        String[] partesEncriptada = new String[numeroColunas];
        //Retorna a matriz transposta do texto reescrito, isso é, as colunas viraram linhas e vice-versa
        for (int i = 0; i<numeroColunas;i++){
            String parteEncriptada = "";
            for (int j = 0; j < numeroLinhas; j++){
                if (i < textoReescrito[j].toCharArray().length)
                    parteEncriptada += textoReescrito[j].toCharArray()[i];
            }
            partesEncriptada[i] = parteEncriptada;
        }
        for (String parteEncriptada: partesEncriptada){
            //Adiciona as partes separadas por um espaço
            resultado += parteEncriptada+" ";
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String texto = scan.nextLine();
        System.out.println(encryption(texto));
    }
}
