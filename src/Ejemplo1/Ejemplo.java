package Ejemplo1;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ejemplo {
    /**
     * App que abre el chrome con la pagina de preogresa caragada
     * @ param args
     */
    public static void main(String[] args){
        // comnandos- Array de string
        // Elementos 1 el programa
        // siguientes cada una de argumentos o arracar


        String[ ] comando={"open","-a","Google Chrome","http://www.chocovavalencia.com"};
        String[ ] comando2={"open","/System/Applications/Textedit.app"};
        String[ ] comandoWind={"notepad","nombredelfichero.txt"};
        String[ ] comandoChrome ={"C:\\Program Filas (x86)\\Chrome\\Application\\chrome.exe","www.youtube.com","www.cieep.com"};
        // crear el proceso con el procesador

        String [] hijo={"java","-cp","src/Ejemplo1.ProcesoHijo.java"};
        ProcessBuilder pb = new ProcessBuilder(hijo);


        //creamos el proceso hijo
        try{
            Process pSafari = pb.start();
            if (pSafari.isAlive())
            TimeUnit.SECONDS.sleep(10);
           pSafari.destroy();

            TimeUnit.SECONDS.sleep(10);
            pSafari.destroy();

        }catch (IIOException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
