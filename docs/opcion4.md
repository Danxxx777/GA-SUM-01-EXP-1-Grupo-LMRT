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

## Integración en el documento del equipo

Las diapositivas se editan en `slides/secciones/04-integrante-4.tex` y las notas en `notas/secciones/04-integrante-4.tex`. La bibliografía es `referencias/referencias.bib`. El diagrama editable está en `diagrama/integrante-4/` y las transcripciones de las pruebas en `evidencias/integrante-4/demo-http/`. La bitácora es la general del repositorio.

Los comandos y dependencias para compilar `slides/main.tex` y `notas/main.tex` están en el README general. La demo sigue en `demo/opcion4/` y requiere Java 17 o superior.

## Aplicación oral y demostración en CLAB

Las diapositivas presentan un sistema distribuido supuesto con Cliente, Servicio A y Servicio B. Durante la explicación, A se relaciona con Reservas y B con Laboratorios. Los comandos siguientes permiten mostrar esa aplicación al proyecto; no se proyectan como descripción de la arquitectura genérica.

Con los JAR compilados, ejecutar cada servicio en una terminal distinta desde la raíz de clab-pfc-7a:

```powershell
java -jar src/servicio-laboratorios/target/servicio-laboratorios-0.0.1-SNAPSHOT.jar
```

```powershell
java -jar src/servicio-reservas/target/servicio-reservas-0.0.1-SNAPSHOT.jar
```

Esperar el mensaje Started de ambas aplicaciones. En la terminal del cliente, desde el repositorio de la exposición:

```powershell
$urlClab = 'http://127.0.0.1:8082/api/reservas/comunicacion'
java -cp build opcion4.Cliente bloqueante $urlClab
java -cp build opcion4.Cliente no-bloqueante $urlClab
```

Con ambos servicios activos se espera HTTP 200. Al detener Laboratorios en su terminal se espera HTTP 503 desde Reservas. Después de reiniciar Laboratorios y esperar su arranque, repetir la consulta permite comprobar la recuperación. Detener Reservas produce un fallo de conexión del cliente. El retardo de cinco segundos del puerto 8083 se conserva como ejemplo complementario de timeout.
