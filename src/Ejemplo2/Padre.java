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
            InputStream isHijo= hijo.getInputStream();
            // cion esta lineas Creo un lector para la entrada
            InputStreamReader isrHijo= new InputStreamReader(isHijo, StandardCharsets.UTF_8);
            // Creare un buffer para leer linea a linea
            BufferedReader brHijo= new BufferedReader(isrHijo);

            //--------ESCRITURA-------------
            OutputStream outputStream= hijo.getOutputStream();
            PrintStream psHijo= new PrintStream(outputStream);

            psHijo.println(contador);
            psHijo.flush();

            String respuesta;
            while ((respuesta = brHijo.readLine())!=null){
                System.out.println(respuesta);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
