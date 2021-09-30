package agricultores;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class ServicioLectura {

    public static void crearDirectorio(String ruta) {

        Path directory = Paths.get(ruta);
        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }

    public static void listarDirectorio(String ruta) {
        File f = new File(ruta);
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los
            // devuelve en un array
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }

    public static void generarJSON(Agricultores lista, String directorio) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapeador.writeValue(new File("./backup/" + directorio + "/Agricultores.json"), lista);
    }

    public static ArrayList<Agricultores> leerJSON(String copiaEleccion) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        ArrayList<Agricultores> lista = new ArrayList<>();
        lista = mapeador.readValue(new File("./backup/" + copiaEleccion + "/Agricultores.json"),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Agricultores.class));
        return lista;
    }
}
