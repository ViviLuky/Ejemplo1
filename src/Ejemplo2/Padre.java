package Ejemplo2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Padre {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime cuantas lineas quiere mostrar");
        int contador=scanner.nextInt();

        ProcessBuilder pb = new ProcessBuilder("java","src/Ejemplo2/Hijo.java");
        pb.redirectErrorStream(true);

        try {
            Process hijo =pb.start();
            //---------LECTURA-----------------
            // Cojo la entrada estadar del hijo.
            InputStream isHijo= hijo.getInputStream(); // OJO Salida del hijo
            // Creo esta lineas Creo un lector para la entrada
            InputStreamReader isrHijo= new InputStreamReader(isHijo, StandardCharsets.UTF_8);
            // Creare un buffer para leer linea a linea
            BufferedReader brHijo= new BufferedReader(isrHijo);// LEE los SOUT del hijo.

            //--------ESCRITURA-------------
            OutputStream outputStream= hijo.getOutputStream();// CAPTURA LA ENTRADA DEL HIJO (SCANNER)
            PrintStream psHijo= new PrintStream(outputStream);

            psHijo.println(contador);
            psHijo.flush();// ES EL INTRO.

            String respuesta;
            while ((respuesta = brHijo.readLine())!=null){
                System.out.println(respuesta);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
