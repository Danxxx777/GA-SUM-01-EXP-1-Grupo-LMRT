# Bitácora del equipo LMRT

## 2026-11-18 · Nueva plantilla por integrante

- **Integrantes presentes.** La entrada original no registra quiénes asistieron.

- **Qué hice** — Preparé con asistencia de Codex una plantilla modular para teoría, demo y aplicación futura a los cuatro proyectos.
- **Problema encontrado** — El material anterior estaba organizado alrededor de un solo sistema.
- **Cómo lo resolví** — Separé las diapositivas y las notas por integrante, conservé la paleta y la tipografía, y añadí campos para distinguir estado actual, propuesta y fallo hipotético.

- **Reparto confirmado** — Belinda Toaquiza (RPC), Allison Mera (gRPC), Eduardo Reinoso (Java RMI) y Byron Daniel Loor (llamadas y fallos de red).
- **Verificación** — Compilación de las diapositivas y las notas, revisión de campos en rojo y espacios de cada proyecto.

## 2026-11-18 - Armazón de la opción 4

- **Integrantes presentes.** Byron Daniel Loor Mendoza.
- **Modalidad.** Trabajo individual mediante esta sesión de chat, con asistencia de OpenAI Codex.
- **Lo realizado.** Se eligió la opción 4, sobre llamadas bloqueantes y no bloqueantes, errores y tiempos de espera. Se prepararon `Cliente.java` y `Servidor.java` en `demo/opcion4/`, junto con el recorrido de ensayo en `docs/opcion4.md`. La aplicación al PFC se planteó sobre la consulta entre Reservas y Laboratorios de CLAB.
- **Problemas resueltos.** El repositorio nuevo estaba vacío y faltaba una base para preparar el ejemplo. Se organizaron los archivos y se distinguieron tres situaciones que deben explicarse en la demostración: conexión fallida, timeout y respuesta HTTP 503. También se aclaró que el modo no bloqueante corresponde al cliente de ejemplo y que la consulta interna actual de CLAB es bloqueante.
- **Verificación realizada.** Codex compiló ambos programas con `javac --release 17` y comprobó el rechazo de un modo de cliente inválido y de un puerto fuera de rango. La prueba de los servicios en marcha y las capturas personales siguen por realizarse.
- **Asistencia utilizada.** OpenAI Codex preparó el código inicial y apoyó la redacción de las instrucciones y este registro. Byron eligió el mensaje del commit.
- **Registro en Git.** [a1edfbc](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/a1edfbceb2a61c8dd8bf73bf20004e7bc62304b4), «Organización principal para completar lo requerido para la exposición de la semana siguiente».

## 2026-11-18 - Ajuste del registro de trabajo

- **Integrantes presentes.** Byron Daniel Loor Mendoza.
- **Modalidad.** Revisión individual mediante esta sesión de chat, con asistencia de OpenAI Codex.
- **Lo realizado.** Se revisaron la actividad EXP-1, el encuadre y el sílabo de la asignatura. A petición de Byron, se retiró temporalmente el README y se reorganizó esta bitácora con los campos indicados en la actividad.
- **Problemas resueltos.** La primera entrada carecía de campos explícitos para identificar a los integrantes presentes, el trabajo realizado y los problemas resueltos. Se incorporaron esos campos conservando la información comprobada de la sesión.
- **Asistencia utilizada.** OpenAI Codex localizó las fuentes, cotejó las instrucciones y ayudó a reestructurar el registro.

## 2026-11-18 - Fuentes del bloque RPC

- **Integrantes presentes.** Belinda Toaquiza.
- **Lo realizado.** Se organizo la bibliografia en referencias/referencias.bib y se descargaron PDF de acceso abierto para el bloque RPC.
- **Problemas resueltos.** Se cotejaron las diferencias entre fecha de preprint, publicacion online y volumen final con Crossref, las editoriales y los manuscritos. Se actualizaron las rutas de compilacion.
- **Verificacion realizada.** Tres articulos de revista con DOI de 2023 y 2025, un articulo de conferencia de apoyo y tres capturas con pasajes marcados para revision del equipo. La lectura personal y las notas del equipo quedan pendientes.
- **Asistencia utilizada.** SciSpace para la busqueda y Codex para comprobar metadatos, descargar copias abiertas, organizar archivos y preparar las capturas. No se encontraron integraciones disponibles de Consensus ni Elicit.

## 2026-11-18 - Bloque 3 (Java RMI): demo y primeras diapositivas

- **Integrantes presentes.** Eduardo Reinoso Vélez.
- **Lo realizado.** Elegí el SSDC (repositorio aldairHub/CHRSweb) como proyecto de mi bloque. Su backend es Java 21 con Spring Boot 4.0.2 según `backend/pom.xml`. Como servicio candidato para exponer con RMI se identificó `CodigoVerificacionService` (`generarCodigo` y `validarCodigo`), cuyo estado vive en un `ConcurrentHashMap` dentro de una sola JVM. Agregué la demo del conversor Celsius a Fahrenheit en `demo/integrante-3/` (interfaz remota, servidor y cliente) y la ejecuté en mi equipo. La captura está en `evidencias/integrante-3/demo-rmi/01-demo-rmi.png`. En `slides/secciones/03-integrante-3.tex` quedaron la diapositiva de teoría de RMI y la del ejemplo, y en `slides/equipo.tex` fijé SSDC como mi proyecto.
- **Problemas resueltos.** La captura quedó primero dentro de `demo/integrante-3/` y la moví a `evidencias/`. Git marcaba como modificados archivos de otros integrantes por diferencias de fin de línea (CRLF), así que agregué solo mis archivos con `git add <ruta>`. En una prueba de compilación la diapositiva de teoría se desbordaba por abajo y la captura del ejemplo salía ilegible; se rediseñaron ambas.
- **Verificación realizada.** Compilé y ejecuté servidor y cliente en mi equipo. El cliente mostró `25.0 C = 77.0 F`, el servidor imprimió `recibi 25.0 C, respondo 77.0 F` y el objeto que recibió el cliente fue de tipo `jdk.proxy1.$Proxy0`. Las diapositivas solo se probaron con sustitutos de `biblatex` y de `babel` en español, de modo que la compilación completa (pdflatex, biber, pdflatex, pdflatex) sigue pendiente.
- **Pendiente.** Leer el artículo de Darbord (DOI 10.1109/MS.2023.3263019) y comprobar si trata RMI antes de citarlo: Crossref confirmó que el DOI existe y que título, autores, revista, volumen, páginas y año coinciden con el `.bib`, pero eso no dice nada de su contenido. Falta también el bosquejo a mano, el diagrama `.drawio`, las diapositivas 3 a 5, las notas y las capturas de lectura de mis fuentes.
- **Asistencia utilizada.** Claude Sonnet 5.5 (Anthropic, mediante claude.ai y Claude Code). Se usó para leer el repositorio del SSDC y proponer el servicio candidato, escribir el código de la demo, corregir redacción del borrador de las diapositivas 1 y 2, revisar el estado de mi copia local y consultar a Crossref los metadatos de Darbord.
- **Registro en Git.** [987c364](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/987c364), «agrego la demo RMI del conversor de temperatura y la captura de su ejecución». [680f469](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/680f469), «completo las diapositivas de teoría RMI y del ejemplo del conversor, y fijo SSDC como mi proyecto».


## 2026-11-18 - Bloque 2 (gRPC): contrato del servicio de turnos

- **Integrantes presentes.** Allison Mera Jumbo.
- **Lo realizado.** Elegí mi Proyecto Fin de Curso, el sistema del Centro de Revisión Técnica Vehicular de Valencia, como proyecto de mi bloque. Agregué en `demo/integrante-2/turnos.proto` el contrato del ejemplo gRPC: el servicio `TurnosService` con la llamada `ConsultarTurno`, que recibe la placa de un vehículo y responde si tiene turno asignado, su fecha y su estado.
- **Problemas resueltos.** La carpeta `demo/integrante-2/` estaba vacía y faltaba definir qué operación del proyecto serviría como ejemplo de una petición y una respuesta. Se eligió la consulta de turnos porque es una llamada simple entre dos componentes del sistema.
- **Verificación realizada.** Revisé que el contrato siga la sintaxis de `proto3`, con un servicio, un mensaje de petición y uno de respuesta. La generación de código, el servidor, el cliente y su ejecución siguen pendientes.
- **Pendiente.** Implementar el servidor y el cliente gRPC a partir del contrato, ejecutar la demo y capturar el resultado, preparar mis diapositivas y notas, y proponer la llamada entre componentes del proyecto.
- **Asistencia utilizada.** Claude (Anthropic, mediante claude.ai). Se usó para redactar el contrato `.proto` inicial.
- **Registro en Git.** [e7c4090](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/e7c4090), «Agrega contrato .proto del servicio de turnos para el ejemplo gRPC».
