package opcion4;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.CompletionException;

public class Cliente {

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2
                || !(args[0].equals("bloqueante") || args[0].equals("no-bloqueante"))) {
            System.err.println("Uso: java -cp build opcion4.Cliente bloqueante|no-bloqueante [URL]");
            System.exit(2);
            return;
        }

        try {
            String destino = "http://127.0.0.1:8083/respuesta";
            if (args.length == 2) {
                destino = args[1];
            }

            HttpClient cliente = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(2))
                    .build();
            HttpRequest peticion = HttpRequest.newBuilder(URI.create(destino))
                    .timeout(Duration.ofSeconds(3))
                    .GET()
                    .build();

            System.out.println("Modo: " + args[0]);
            System.out.println("Destino: " + destino);
            long inicio = System.nanoTime();
            int resultado = ejecutar(cliente, peticion, args[0], inicio);
            System.exit(resultado);
        } catch (IllegalArgumentException error) {
            System.err.println("Revisa la URL HTTP o HTTPS: " + error.getMessage());
            System.exit(2);
        }
    }

    private static int ejecutar(HttpClient cliente, HttpRequest peticion, String modo, long inicio) {
        try {
            if (modo.equals("bloqueante")) {
                System.out.println("El hilo principal espera dentro de send().");
                HttpResponse<String> respuesta = cliente.send(
                        peticion, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
                return mostrarRespuesta(respuesta, inicio);
            }

            var respuestaFutura = cliente.sendAsync(
                    peticion, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            System.out.println("sendAsync() devolvió un futuro. El hilo principal continúa.");
            System.out.println("El futuro ya terminó: " + respuestaFutura.isDone());

            // La espera final conserva la consola hasta terminar de mostrar el resultado.
            return respuestaFutura.handle((respuesta, error) -> {
                if (error != null) {
                    return mostrarError(error, inicio);
                }
                return mostrarRespuesta(respuesta, inicio);
            }).join();
        } catch (IOException error) {
            return mostrarError(error, inicio);
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
            return mostrarError(error, inicio);
        }
    }

    private static int mostrarRespuesta(HttpResponse<String> respuesta, long inicio) {
        System.out.println("Estado HTTP: " + respuesta.statusCode());
        System.out.println("Cuerpo: " + respuesta.body());
        mostrarTiempo(inicio);
        if (respuesta.statusCode() >= 200 && respuesta.statusCode() < 300) {
            return 0;
        }
        return 1;
    }

    private static int mostrarError(Throwable error, long inicio) {
        if (error instanceof CompletionException && error.getCause() != null) {
            error = error.getCause();
        }

        if (error instanceof HttpTimeoutException) {
            System.out.println("Se agotó un tiempo de espera: " + error.getClass().getSimpleName());
        } else if (error instanceof ConnectException) {
            System.out.println("Conexión fallida. Comprueba que el servicio esté iniciado y la URL sea correcta.");
        } else if (error instanceof InterruptedException) {
            System.out.println("La espera fue interrumpida.");
        } else {
            System.out.println("Error de comunicación: " + error.getClass().getSimpleName());
        }
        mostrarTiempo(inicio);
        return 1;
    }

    private static void mostrarTiempo(long inicio) {
        long transcurridoMs = Duration.ofNanos(System.nanoTime() - inicio).toMillis();
        System.out.println("Tiempo observado en esta ejecución: " + transcurridoMs + " ms");
    }
}
