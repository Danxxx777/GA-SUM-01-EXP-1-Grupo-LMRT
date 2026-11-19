# EXP-1 - Grupo LMRT

Armazón del integrante 4 para explicar llamadas bloqueantes y no bloqueantes, errores de comunicación y tiempos de espera. El ejemplo sencillo utiliza Java y HTTP. La aplicación al Proyecto Fin de Curso utiliza la consulta entre Reservas y Laboratorios de CLAB.

## Archivos de esta preparación

- `demo/opcion4/Cliente.java` envía una petición con `send()` o `sendAsync()`, muestra la respuesta y maneja errores.
- `demo/opcion4/Servidor.java` ofrece una respuesta inmediata y otra con un retardo controlado de cinco segundos.
- `docs/opcion4.md` organiza la explicación, el ensayo y la aplicación a CLAB.
- `BITACORA.md` registra el trabajo realizado y el uso de asistencia.

## Compilar

Se necesita JDK 17 o 21, con `java` y `javac` disponibles en la terminal. Desde la raíz del repositorio ejecuta

```powershell
javac --release 17 -encoding UTF-8 -d build demo/opcion4/Cliente.java demo/opcion4/Servidor.java
```

## Ejecutar el ejemplo sencillo

En una primera terminal inicia el servidor

```powershell
java -cp build opcion4.Servidor
```

Desde otra terminal compara los dos modos del cliente

```powershell
java -cp build opcion4.Cliente bloqueante
java -cp build opcion4.Cliente no-bloqueante
```

Para provocar un timeout consulta el endpoint lento

```powershell
java -cp build opcion4.Cliente bloqueante http://127.0.0.1:8083/lenta
java -cp build opcion4.Cliente no-bloqueante http://127.0.0.1:8083/lenta
```

El cliente configura dos segundos como límite de conexión y tres segundos como límite de petición. El endpoint lento retrasa cinco segundos el envío de las cabeceras. Los tiempos que imprime el programa se calculan en cada ejecución.

Para probar una conexión fallida detén el servidor con `Ctrl+C` y repite la petición del cliente. Reinicia el servidor y vuelve a consultar para observar la recuperación.

`sendAsync()` entrega un futuro y permite continuar el trabajo del hilo que llama. El programa usa `join()` al final para mantener la consola abierta hasta mostrar el resultado.

## Usar el cliente con CLAB

El esqueleto está en [clab-pfc-7a](https://github.com/Danxxx777/clab-pfc-7a). Compila e inicia los servicios siguiendo el README de ese repositorio. Luego ejecuta

```powershell
java -cp build opcion4.Cliente bloqueante http://127.0.0.1:8082/api/reservas/comunicacion
java -cp build opcion4.Cliente no-bloqueante http://127.0.0.1:8082/api/reservas/comunicacion
```

El cliente consulta a Reservas y ese servicio consulta a Laboratorios. Al detener Laboratorios, el código de Reservas transforma el fallo de su dependencia en una respuesta HTTP 503. Al detener Reservas, el cliente pierde la conexión directa con ese proceso. En ambos casos, vuelve a iniciar el proceso correspondiente y repite la consulta.

La variante no bloqueante corresponde a este cliente de demostración. La consulta interna de Reservas a Laboratorios usa `RestClient` bloqueante. Las operaciones de la demo son consultas de información del esqueleto de CLAB.

## Evidencias de ejecución

Antes de las pruebas personales muestra los datos de tu sesión en la terminal

```powershell
whoami
hostname
Get-Date -Format o
```

Conserva las capturas y los tiempos que obtengas al ejecutar los casos. El retardo configurado en el servidor y los límites del cliente describen las condiciones de la prueba.

## Asistencia de IA

OpenAI Codex ayudó a organizar esta preparación, escribir los dos programas Java y redactar las instrucciones. La ejecución personal de la demostración y sus evidencias corresponden al integrante que la presenta.
