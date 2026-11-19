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
