//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main{


    public static void main(String[] args) {
        ArrayList<Piloto> pilotos = new ArrayList<>();
        cargarDatos(pilotos);
        mostrarPilotos(pilotos);
        añadirPiotos(pilotos);
        mostrarPilotos(pilotos);
       // buscarPiloto(pilotos);
        escribirFichero(pilotos);
    }


        public static void cargarDatos(ArrayList < Piloto > pilotos) {
            try (BufferedReader reader = new BufferedReader(new FileReader("pilotos_f1.txt"))) {

                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] campos = linea.split(";");
                    Piloto piloto = new Piloto(campos[0], campos[1], Integer.parseInt(campos[2]));
                    pilotos.add(piloto);
                }
            } catch (IOException e) {
                System.out.println("Ocurrió un error al leer el archivo; " + e.getMessage());
            }
        }


    public static void mostrarPilotos(ArrayList<Piloto> pilotos) {
        for (Piloto e : pilotos) {
            System.out.println("Nombre " + e.getNombre());
            System.out.println("Escuderia " + e.getEscuderia());
            System.out.println("Puntos " + e.getPuntos());
            System.out.println(" ");
        }
    }

    public static void añadirPiotos(ArrayList<Piloto> pilotos) {
        String nombre = "Sainz";
        String escuderia = "Ferrari";
        int puntos = 203;
        boolean repetido = false;
        //comprobamos si existen los pilotos en el ArrayList
        if (existePiloto(pilotos, nombre)) {
            System.out.println("El piloto ya existe");
        }else {
            pilotos.add(new Piloto(nombre,escuderia,puntos));
        }

    }

    public static void buscarPiloto(ArrayList<Piloto> pilotos){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del piloto a buscar: ");
        String nombre = sc.nextLine();

        if (existePiloto(pilotos,nombre)){
            System.out.println("El piloto existe");

        }else {
            System.out.println("EL piloto no existe");
        }
    }

    public static boolean existePiloto (ArrayList<Piloto> pilotos, String nombre){
        boolean encontrado = false;
        for (Piloto p : pilotos ){
            if (p.getNombre().equals(nombre)){
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public static void escribirFichero(ArrayList<Piloto> pilotos) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("pilotos_f1.txt"))){
            for (Piloto p :pilotos){
                writer.write(p.getNombre()+";"+p.getEscuderia()+";"+p.getPuntos());
                writer.newLine();
            }
            System.out.println("Lineas escritas en el archivo");
        }catch (IOException e){
            System.out.println("Ocurrio un problema al modificar " + e.getMessage());
        }
    }
}
