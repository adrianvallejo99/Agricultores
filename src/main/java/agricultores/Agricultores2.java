package agricultores;

import java.util.Arrays;

public class Agricultores2 {
    private String [][] matriz;

    public Agricultores2() {
    }

    public Agricultores2(String[][] matriz) {
        this.matriz = matriz;
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }

    public void imprimir() {
        for (String[] chars : matriz) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.printf(" %c ", chars[j]);
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Agricultores2{" +
                "matriz=" + Arrays.toString(matriz) +
                '}';
    }

    /*public static void main(String[] args) {
        Scanner teclado = new Scanner();
        ArrayList [][] agricultores;
        int cantidad;
        int totalUnidades;

        do{
            System.out.println("Unidades agricultor ");
            cantidad = teclado.nextInt();
            totalUnidades = totalUnidades + cantidad;
            if (cantidad != 0){
                agricultores  +=1;
            }
        }while(cantidad != 0);
    }*/
}
