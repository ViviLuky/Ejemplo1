package Ejemplo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class ProcesoHijo {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        PrintWriter pw = new PrintWriter(new File("pruebatxt"));
        pw.println("ESTOY VIVO");
        pw.close();
        TimeUnit.SECONDS.sleep(30);
    }
}
