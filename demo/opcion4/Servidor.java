package opcion4;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

public class Servidor {

    public static void main(String[] args) throws IOException {
        int puerto = 8083;
        try {
            if (args.length > 1) {
                throw new IllegalArgumentException("Se acepta como máximo un puerto.");
            }
            if (args.length == 1) {
                puerto = Integer.parseInt(args[0]);
            }
            if (puerto < 1 || puerto > 65535) {
                throw new IllegalArgumentException("El puerto debe estar entre 1 y 65535.");
            }
        } catch (IllegalArgumentException error) {
            System.err.println("Uso: java -cp build opcion4.Servidor [puerto]");
            System.err.println(error.getMessage());
            System.exit(2);
            return;
        }

        var servidor = HttpServer.create(new InetSocketAddress("127.0.0.1", puerto), 0);
        var ejecutor = Executors.newFixedThreadPool(4);
        servidor.setExecutor(ejecutor);
        servidor.createContext("/respuesta", intercambio -> responder(intercambio, 0));
        servidor.createContext("/lenta", intercambio -> responder(intercambio, 5000));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            servidor.stop(0);
            ejecutor.shutdownNow();
        }));

        servidor.start();
        System.out.println("Respuesta inmediata: http://127.0.0.1:" + puerto + "/respuesta");
        System.out.println("Respuesta con retardo de 5 s: http://127.0.0.1:" + puerto + "/lenta");
        System.out.println("Ctrl+C para detener el servidor y probar la desconexión.");
    }

    private static void responder(HttpExchange intercambio, long retardoMs) {
        try (intercambio) {
            if (!intercambio.getRequestMethod().equals("GET")) {
                intercambio.getResponseHeaders().set("Allow", "GET");
                intercambio.sendResponseHeaders(405, -1);
                return;
            }

            if (retardoMs > 0) {
                Thread.sleep(retardoMs);
            }

            byte[] cuerpo = "{\"servicio\":\"ejemplo-opcion4\",\"mensaje\":\"Respuesta disponible\"}"
                    .getBytes(StandardCharsets.UTF_8);
            intercambio.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
            intercambio.sendResponseHeaders(200, cuerpo.length);
            intercambio.getResponseBody().write(cuerpo);
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
        } catch (IOException error) {
            System.out.println("Error al entregar la respuesta: " + error.getClass().getSimpleName());
        }
    }
}
