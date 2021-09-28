package agricultores;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String [][] matrizAgricultores = new String[2][];
        int numeros;
        String cantidad;
        int agricultor = 1;
        int y = 1;
        do{
           System.out.println("Unidades agricultor ");
           numeros = teclado.nextInt();
           cantidad = String.valueOf(numeros);
           if (numeros != 0) {
                matrizAgricultores [0][y] = "agricultor" ;
                matrizAgricultores [1][y] = "Cantidad: " + cantidad;
                y++;
                agricultor++;
           }
        }while(numeros != 0);

        for (int i = 0; i < matrizAgricultores.length; i++){
            for (int j = 0; j < matrizAgricultores.length; j++) {
                System.out.print(matrizAgricultores[i][j] + "\t");
            }
        }
    }
}
