# Integrante 4 - Comunicación, errores y tiempos de espera

## Teoría que se explicará

- Una llamada bloqueante mantiene esperando al hilo que la realiza hasta recibir una respuesta o un error. En el cliente Java se observa en `HttpClient.send()`.
- Una llamada no bloqueante permite que el hilo continúe después de iniciar la petición. `HttpClient.sendAsync()` devuelve un `CompletableFuture` y el resultado se procesa cuando llega.
- La conexión fallida ocurre cuando el cliente intenta comunicarse con un proceso al que no consigue conectarse. Un servicio detenido permite preparar ese escenario en la máquina local.
- El timeout limita la espera. El endpoint `/lenta` demora el envío de la respuesta para observar el límite configurado por el cliente.
- Un HTTP 503 es una respuesta recibida del servidor. En CLAB, Reservas puede contestar 503 cuando falla su consulta a Laboratorios.

## Recorrido del ejemplo sencillo

1. Iniciar `Servidor` y ejecutar el cliente en modo bloqueante contra `/respuesta`.
2. Ejecutar el modo no bloqueante y señalar el futuro y el mensaje de continuación del hilo principal.
3. Consultar `/lenta` para provocar el timeout.
4. Detener el servidor y repetir una petición para observar el error de conexión.
5. Reiniciar el servidor y realizar una nueva petición.

En la variante no bloqueante, `join()` espera al final para conservar la consola hasta que termine el manejo del resultado. El ejemplo demuestra que se puede trabajar entre el envío y esa espera final.

## Aplicación al PFC de CLAB

La petición sigue el recorrido cliente de demostración -> Reservas -> Laboratorios. Reservas expone `GET /api/reservas/comunicacion` y consulta `GET /api/laboratorios/info` mediante REST y JSON.

Con los dos procesos iniciados se observa la respuesta de Laboratorios dentro del resultado de Reservas. Al detener Laboratorios se comprueba el HTTP 503 generado por Reservas. Al detener Reservas se comprueba el fallo de conexión del cliente. La recuperación se observa iniciando otra vez el proceso detenido y haciendo una nueva consulta.

El cliente ofrece ambos modos de llamada. La comunicación interna actual de los servicios de CLAB es bloqueante. Para provocar el retardo controlado se utiliza el servidor sencillo de esta preparación.

## Registro del ensayo

El integrante ejecuta los casos y conserva las salidas originales. A partir del ensayo se ajustarán el tiempo de explicación, los comandos que se mostrarán y la selección de capturas para la presentación. El orden de los mensajes permite explicar cuándo continúa el hilo principal. El tiempo transcurrido mide la petición de esa ejecución.

## Fuentes técnicas

- [Java 17, HttpClient, send y sendAsync](https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpClient.html).
- [Java 17, HttpRequest.Builder, timeout](https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpRequest.Builder.html).
- [Código del servicio Reservas en CLAB](https://github.com/Danxxx777/clab-pfc-7a/tree/68cf3dbf1ddd5133ca8e1b430cfb113cfd10341d/src/servicio-reservas).
