# Guía de ejecución y comprobación — opción 4

Esta guía complementa [la explicación de la opción 4](opcion4.md). Los comandos están preparados para PowerShell con JDK 17 o posterior, desde la raíz del repositorio. No se requiere Maven para esta demostración.

## 1. Compilar el ejemplo

```powershell
java -version
New-Item -ItemType Directory -Force build | Out-Null
javac --release 17 -d build demo/opcion4/Servidor.java demo/opcion4/Cliente.java
```

La compilación genera las clases en `build/`. Si `javac` no se reconoce, comprueba la instalación del JDK y la variable `PATH`.

## 2. Iniciar el servidor

En una terminal, sin cerrarla durante las primeras pruebas:

```powershell
java -cp build opcion4.Servidor
```

El servidor escucha en `127.0.0.1:8083` y ofrece dos rutas:
- `/respuesta`: respuesta inmediata con HTTP 200.
- `/lenta`: espera aproximadamente cinco segundos antes de intentar responder.

## 3. Casos del cliente

Ejecuta cada comando desde otra terminal, ubicada en la raíz del repositorio:

| Caso | Comando | Resultado que se busca observar |
| --- | --- | --- |
| Bloqueante | `java -cp build opcion4.Cliente bloqueante` | La ejecución espera la respuesta de `send()` antes de continuar |
| No bloqueante | `java -cp build opcion4.Cliente no-bloqueante` | `sendAsync()` devuelve un futuro y el hilo principal imprime mensajes antes de `join()` |
| Timeout | `java -cp build opcion4.Cliente bloqueante http://127.0.0.1:8083/lenta` | El límite de tres segundos del cliente vence antes del retardo de cinco segundos |
| Conexión fallida | Detener primero el servidor con `Ctrl+C` y ejecutar el cliente bloqueante | El cliente informa de un fallo de comunicación, siempre que ningún otro proceso escuche en el puerto 8083 |
| Recuperación | Reiniciar el servidor y repetir la llamada bloqueante | La consulta vuelve a recibir una respuesta |

**Importante:** el modo asíncrono también utiliza `join()` al final para esperar el resultado antes de salir; el ejemplo no afirma que toda la ejecución sea libre de esperas. El timeout y el error de conexión son fallos de transporte, mientras que HTTP 503 es una respuesta del servidor.

Para consultar el código de salida del último comando desde PowerShell, ejecuta `$LASTEXITCODE`. El cliente devuelve `0` ante HTTP 2xx, `1` ante error de comunicación o respuesta HTTP fuera de 2xx y `2` ante argumentos inválidos.

## 4. Vincularlo con CLAB

Con Laboratorios y Reservas iniciados según el [README de CLAB](https://github.com/Danxxx777/clab-pfc-7a/blob/main/README.md), ejecuta:

```powershell
java -cp build opcion4.Cliente bloqueante http://127.0.0.1:8082/api/reservas/comunicacion
```

Detén Laboratorios y vuelve a consultar Reservas. En el esqueleto actual, Reservas puede responder HTTP 503 cuando no logra completar su consulta interna. Después reinicia Laboratorios y repite la petición. Si detienes Reservas, el cliente puede observar un fallo de conexión, que no debe confundirse con HTTP 503.

La consulta interna de CLAB es **bloqueante**: la demostración con `sendAsync()` pertenece al cliente de esta opción, no a una implementación asíncrona de Reservas.

## 5. Evidencias pendientes de ejecución personal

Al ejecutar la demostración, conserva capturas de la consola con el comando utilizado, la respuesta y el error correspondiente. Es recomendable registrar fecha, entorno y observaciones reales en la bitácora del equipo, sin reemplazarlas por resultados supuestos. Esta guía documenta el procedimiento; **no certifica que todos los casos se hayan ejecutado**.
