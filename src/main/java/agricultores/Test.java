package agricultores;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import static agricultores.ServicioLectura.*;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        Agricultores lista = new Agricultores();
        int agricultores = 0;
        boolean salir = false;
        int opcionMenu = 0;
        boolean stop;

        do{
            System.out.println("--------------MEN�--------------");
            System.out.println("1. Agricultores");
            System.out.println("2. Crear Copia de Seguridad");
            System.out.println("3. Restaurar Copias de Seguridad");
            System.out.println("4. Salir");
            boolean exitMenu = false;
            do {
                String texto = teclado.next();
                try {
                    opcionMenu = Integer.parseInt(texto);
                } catch (NumberFormatException e) {
                    System.out.println("Tiene que ser un N�mero");
                }
                if (opcionMenu == 0) {
                    System.out.println("No existe esa opci�n");
                }
                if (opcionMenu >= 1 && opcionMenu <= 5) {
                    exitMenu = true;
                }
            } while (!exitMenu);

            exitMenu = false;
            switch (opcionMenu) {
                case 1:// AGRICULTORES
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

                    for (int i = 0; i < trabajadores.size(); i++) {
                        System.out.println("[" + trabajadores.get(i) + "," + lista.getLista().get(i) + "]");
                    }

                    if (suma%agricultores == 0){
                        System.out.println("Se pueden repartir y les toca a cada uno " + media);
                    }else{
                        System.out.println("No se pueden repartir");
                    }
                    break;

                case 2:// CREAR COPIA
                    LocalDateTime fechaHoraActual = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_hhmm");
                    String directorio = fechaHoraActual.format(formatter);
                    crearDirectorio("./backup/" + directorio);
                    generarJSON(lista, directorio);
                    break;

                case 3:// RESTARURAR COPIA
                    listarDirectorio("./backup");
                    System.out.println("Elige una copia de seguridad para restaurar");
                    teclado.nextLine();
                    String copiaEleccion = teclado.nextLine();
                    //lista = leerJSON(copiaEleccion);
                    System.out.println(leerJSON(copiaEleccion));
                    ArrayList<String> trabajadoresAuxiliar = new ArrayList<>();
                    /*for (int i = 0; i < lista.getLista().size(); i++) {
                        trabajadoresAuxiliar.add( "agr" +(i+1));
                    }*/
                    break;
                case 4:// SALIR
                    salir = true;
                    break;
            }
        } while (!salir);
        /*ArrayList<String> trabajadores = new ArrayList<>();

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

        for (int i = 0; i < trabajadores.size(); i++) {
            System.out.println("[" + trabajadores.get(i) + "," + lista.getLista().get(i) + "]");
        }

        if (suma%agricultores == 0){
            System.out.println("Se pueden repartir y les toca a cada uno " + media);
        }else{
            System.out.println("No se pueden repartir");
        }*/

        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_hhmm");
        String directorio = fechaHoraActual.format(formatter);
        crearDirectorio("./backup/" + directorio);
        generarJSON(lista, directorio);
    }

    private static int leerEntero() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la cantidad de fruta");
        String texto = teclado.next();
        return Integer.parseInt(texto);
    }

}
