package agricultores;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Agricultores lista = new Agricultores();
        int agricultores = 0;
        boolean stop;
        ArrayList<String> trabajadores = new ArrayList<>();

        do{
            lista.getLista().add(leerEntero());
            if (lista.getLista().get(lista.getLista().size() - 1) != 0){
                stop = true;
                agricultores++;
            }else{
                lista.getLista().remove(lista.getLista().size()-1);
                stop = false;
            }
        }while(stop);

        int suma = 0;
        for (int i = 0; i < lista.getLista().size(); i++) {
            suma += lista.getLista().get(i);
        }
        int media = suma/agricultores;

        for (int i = 0; i < lista.getLista().size(); i++) {
            trabajadores.add( "agr" +(i+1));
        }

        System.out.println("Lista: "+trabajadores);

        lista.mostrar();

        if (suma%agricultores == 0){
            System.out.println("Se pueden repartir y les toca a cada uno " + media);
        }else{
            System.out.println("No se pueden repartir");
        }
    }

    private static int leerEntero() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la cantidad de fruta");
        String texto = teclado.next();
        return Integer.parseInt(texto);
    }

}
