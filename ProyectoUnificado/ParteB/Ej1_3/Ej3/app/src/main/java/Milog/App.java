/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Milog;

import org.apache.logging.log4j.Level;
import com.sun.tools.javac.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


public class App {
    
    //Fragmento de codigo para consola y file 
    
//    public String getGreeting() {
//        return "Hello World!";
//    }
//    
////    Cree una aplicación que envíe mensajes de logging a:
////Consola
////Un fichero denominado log.txt.
////Investigue y aplique un ejemplo de logging sobre http.
//
// private static final Logger loger = LogManager.getLogger(Main.class);
//  
//
// 
//    public static void main(String[] args) {
//      //mensaje:
//        loger.info("Mensaje Mostrado");
//        
//    }
//}


    //Fragmento de codigo para llamado http
    
 public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/log", new MyHandler());
        server.setExecutor(null); 
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "Log received";

            // Leer el cuerpo de la solicitud
            InputStream requestBody = t.getRequestBody();
            byte[] data = requestBody.readAllBytes();
            String logData = new String(data);

            // Imprimir el cuerpo de la solicitud (datos de registro)
            System.out.println(logData);

            // Enviar una respuesta al cliente
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}