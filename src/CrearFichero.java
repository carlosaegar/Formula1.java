import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CrearFichero {
    public static void main(String[] args) {
        ArrayList<Piloto> pilotos = new ArrayList<>();
        crearFichero(pilotos);

    }

    public static void crearFichero(ArrayList<Piloto> pilotos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pilotos_f1.txt"))) {
            Scanner sc = new Scanner(System.in);
            boolean seguir = true;
            System.out.println("Introduce FIN para salir");

            do {
                System.out.println("Introduce el Nombre: ");
                String nombre = sc.nextLine();
                if (nombre.equals("FIN")) {
                    seguir = false;
                }else{
                    System.out.println("Introduce la Escuderia: ");
                    String escuderia = sc.nextLine();
                    System.out.println("Introduce los Puntos: ");
                    int puntos = sc.nextInt();
                    sc.nextLine();

                    writer.write(nombre + ";" + escuderia + ";" + puntos + ";");
                    writer.newLine();
                }

            }while(seguir);{
                System.out.println("Lineas escritas en el archivo");
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un problema al modificar " + e.getMessage());

        }
    }
}








