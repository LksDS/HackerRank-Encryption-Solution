import java.util.Scanner;

public class Main {
    public static String encryption(String s) {
        // Write your code here
        String resultado = "";
        int numeroColunas = (int) Math.ceil(Math.sqrt(s.length()));
        int arredondadoBaixo = (int) Math.floor(Math.sqrt(s.length()));
        int numeroLinhas;
        if (numeroColunas*arredondadoBaixo < s.length()){
            numeroLinhas = numeroColunas;
        }else {
            numeroLinhas = arredondadoBaixo;
        }
        String[] textoReescrito = new String[numeroLinhas];
        for(int linha = 0; linha < numeroLinhas; linha++){
            String parteReescrita = "";
            for (int coluna = 0; coluna < numeroColunas; coluna++){
                if (linha*numeroColunas+coluna < s.length()) {
                    parteReescrita += s.toCharArray()[linha * numeroColunas + coluna];
                }
            }
            textoReescrito[linha] = parteReescrita;
        }
        String[] partesEncriptada = new String[numeroColunas];
        for (int i = 0; i<numeroColunas;i++){
            String parteEncriptada = "";
            for (int e = 0; e < numeroLinhas; e++){
                if (i < textoReescrito[e].toCharArray().length)
                    parteEncriptada += textoReescrito[e].toCharArray()[i];
            }
            partesEncriptada[i] = parteEncriptada;
        }
        for (String parteEncriptada: partesEncriptada){
            resultado += parteEncriptada+" ";
        }
        // Write your code here
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String texto = scan.nextLine();
        System.out.println(encryption(texto));
    }
}
