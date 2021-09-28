package agricultores;

import java.util.Scanner;
public class Agricultores {
    public static void main(String[] args) {
        // Scanner para introducir datos por teclado
        Scanner teclado = new Scanner(System.in);
        // Variable con el total de unidades de fruta que tienen los agricultores
        int totalUnidades = 0;
        // Variable que genera un número aleatorio de agricultores
        // En este caso lo he limitado a 10
        int cantidad;
        int agricultores = 0;
        // Bucle for para introducir las cantidades de cada agricultor y sumarlo al total
        do{
            System.out.println("Unidades agricultor ");
            cantidad = teclado.nextInt();
            totalUnidades = totalUnidades + cantidad;
            if (cantidad != 0){
                agricultores  +=1;
            }
        }while(cantidad != 0);
        // If para que si el resto de la división entre el total de unidades y el número de agricultores
        // es igual a 0, es posible repartir el total de unidades entre los agricultores.
        // En caso contrario muestra un mensaje que no se puede repartir
        if (totalUnidades%agricultores == 0){
            System.out.println("Se pueden repartir, son " + agricultores + " agricu" +
                    "ltores y a cada uno le corresponde: " + (totalUnidades/agricultores));
        }else{
            System.out.println("No se pueden repartir." + " Número de agricultores: " + agricultores
                    + ", total de Unidades: " + totalUnidades);
        }

    }
}
