# Bitácora del equipo LMRT

## 2026-11-18 · Nueva plantilla por integrante

- **Integrantes presentes.** Belinda Toaquiza.

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

- **Integrantes presentes.** Belinda Betzabeth Toaquiza Zambrano.
- **Modalidad.** Trabajo individual mediante esta sesión de chat, con asistencia de SciSpace y OpenAI Codex.
- **Lo realizado.** Se organizó la bibliografía general en `referencias/referencias.bib`, se incorporaron tres artículos de revista para el bloque RPC y se guardaron cuatro PDF de acceso abierto en `referencias/PDFs/`. Se actualizaron las citas de las diapositivas y se prepararon tres capturas con pasajes subrayados, página y DOI.
- **Problemas resueltos.** Se cotejaron las diferencias entre las fechas del preprint, la publicación online y el volumen final con Crossref, las editoriales y los manuscritos. Se actualizaron las rutas de compilación al mover el archivo bibliográfico.
- **Verificación realizada.** Se comprobaron los DOI y los datos bibliográficos de tres artículos de revista de 2023 y 2025, junto con un artículo de conferencia de apoyo. Se compilaron las diapositivas y las notas. Las capturas incluyen marcas preparadas con IA; la lectura personal, la revisión de los pasajes y las anotaciones propias del equipo siguen pendientes.
- **Asistencia utilizada.** SciSpace apoyó la búsqueda de fuentes. OpenAI Codex cotejó metadatos, descargó copias abiertas, organizó los archivos y preparó las capturas. No se encontraron integraciones disponibles de Consensus ni Elicit.
- **Registro en Git.** [91680fd](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/91680fd), «Agrega fuentes verificadas y evidencias del bloque RPC». El README de referencias se conservó únicamente en el equipo local, por indicación de Belinda.

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

## 2026-11-19 - Notas del bloque 3: teoría, ejemplo y estado actual

- **Integrantes presentes.** Eduardo Reinoso Vélez.
- **Modalidad.** Trabajo individual en una sesión de chat con Claude (Anthropic).
- **Lo realizado.** En `notas/secciones/03-integrante-3.tex` quedaron la teoría de RMI, la descripción del ejemplo del conversor con su entrada y su salida, y el estado actual del SSDC con referencias a archivos y líneas de `CodigoVerificacionService`, `VerificacionController` y `EmailService`. Los apartados de transparencias, CAP y PACELC, fallo supuesto y bosquejo a mano siguen pendientes.
- **Problemas resueltos.** El bosquejo a mano se pospone para el 20-nov.
- **Verificación realizada.** Una compilación de prueba de las notas, con un sustituto del paquete de español, mostró el texto dentro de los márgenes.
- **Asistencia utilizada.** Claude Sonnet 5.5 (Anthropic) redactó el borrador de esta sección a partir del código del SSDC y de mi ejecución de la demo.

### 2026-11-19 · Mera Jumbo Allison

- **Integrantes presentes** — Allison Mera.
- **Commit(s)** — [e84755b](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/e84755b) — «Agrega servidor y cliente gRPC del servicio de turnos con proyecto Maven»; [3c73c76](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/3c73c76) — «Agrega capturas de la demo gRPC con los tres casos y el fallo UNAVAILABLE».
- **Qué se hizo** — Implementé con asistencia de Claude la demo gRPC de mi bloque como proyecto Maven en `demo/integrante-2/`. Moví el contrato a `src/main/proto/turnos.proto`. `ServidorTurnos` representa al servicio de Turnos y Pagos de mi proyecto y `ClienteTurnos` al de Inspecciones, que consulta por placa si un vehículo tiene turno antes de la revisión. Ejecuté cuatro pruebas y guardé las capturas en `evidencias/integrante-2/demo-grpc/`.
- **Problema encontrado** — No tenía Maven instalado, y IntelliJ no permitía crear carpetas normales dentro de `demo/` porque las marcaba como carpetas de código. Además, la compilación genera la carpeta `target/`, que el `.gitignore` del equipo no excluía.
- **Solución y comprobación** — Usé el Maven incluido en IntelliJ y creé las carpetas escribiendo la ruta completa del archivo. Agregué `target/` al `.gitignore`. Comprobé la demo con el servidor encendido: `GSA-1234` respondió `CONFIRMADO`, `MBA-0567` respondió `PENDIENTE_PAGO` y `XYZ-999` respondió `SIN_TURNO`. Con el servidor apagado, el cliente recibió `UNAVAILABLE`. Las advertencias de `sun.misc.Unsafe` que aparecen en la consola se deben a Java 25 y no afectan la ejecución.
- **Tiempo dedicado** — 45 min.

## 2026-11-19 - Bloque 1 (RPC): teoría y propuesta de distribución de SGRA

- **Integrantes presentes.** Belinda Betzabeth Toaquiza Zambrano.
- **Modalidad.** Trabajo individual con asistencia de OpenAI Codex.
- **Lo realizado.** Se completó la diapositiva de fundamentos de RPC: contrato, stub, serialización y recorrido de petición y respuesta. Se revisaron los repositorios `KhrizGomez/front-SGRA` y `KhrizGomez/back-SGRA` y se eligió la consulta del docente asignado a una asignatura del estudiante como operación candidata. Se elaboró a mano el bosquejo preliminar y añadió su fotografía. A partir de ese bosquejo se preparó el diagrama formal en TikZ, con versiones PDF y PNG, y se incorporó a las diapositivas. La fotografía original se incluyó en las notas. Las carpetas personales de demo, diagrama y evidencias se renombraron como `Belinda T` y la imagen recibió un nombre descriptivo.
- **Problemas resueltos.** Se distinguió la llamada Java interna que existe actualmente de la propuesta futura de invocarla mediante JSON-RPC a un servicio académico en otro proceso. Se precisaron los límites de proceso, la identidad del usuario autenticado y el retorno de las respuestas a través del servicio y del backend. Se mantuvo la base PostgreSQL existente como supuesto inicial, sin asumir réplicas. Se corrigieron los desbordamientos y el espaciado del diagrama. Antes de publicar, se integraron los nuevos aportes del equipo y se recompiló el PDF de notas.
- **Verificación realizada.** Se siguió en el código la consulta desde el frontend hasta el controlador, el servicio y el repositorio, y se identificó su uso en `StudentRequestServiceImpl.create`. Se compilaron la presentación, el diagrama independiente y las notas; se revisaron visualmente la diapositiva del diagrama y la página con el bosquejo. La revisión de SGRA fue estática: no se ejecutó el sistema ni se consultó su base de datos. Se comprobó que la guía personal estuviera excluida de Git y que los cambios de la bitácora y el README de referencias no formaran parte del commit publicado.
- **Pendiente.** Implementar y ejecutar el ejemplo sencillo de JSON-RPC, registrar su salida real y completar el análisis de transparencias, CAP/PACELC, fallo hipotético, comparación y conclusiones. La separación del servicio académico sigue siendo una propuesta futura.
- **Asistencia utilizada.** OpenAI Codex apoyó la explicación de la teoría a partir de las fuentes acordadas, la revisión del código de SGRA y la formalización del bosquejo en TikZ. También ayudó a organizar archivos, ajustar el diseño y compilar los documentos.
- **Registro en Git.** [ad8f396](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/ad8f396), «Completa teoría RPC y diagrama propuesto de SGRA para Belinda».

## 2026-11-20 - Bosquejo, diagrama, diapositivas 3 a 5, notas y fuentes del bloque 3

- **Integrantes presentes.** Eduardo Reinoso Vélez.
- **Lo realizado.** En `slides/secciones/03-integrante-3.tex` quedaron la diapositiva de decisiones (comunicación, transparencias, CAP y PACELC, todo marcado como supuesto) y la del fallo hipotético con su causa raíz, la comparación y la lección. En `notas/secciones/03-integrante-3.tex` quedaron esos apartados resumidos para que mi parte ocupe una página, con mi declaración de uso de IA y la foto del bosquejo en un anexo. Agregué a `referencias/referencias.bib` dos fuentes: la documentación de Oracle sobre Java RMI (Java SE 21) y la documentación de Redis del comando `EXPIRE`. La diapositiva 1 ahora cita la de Oracle. Dibujé a mano el bosquejo del flujo de verificación del SSDC, con mi nombre y la fecha, y su foto está en `evidencias/integrante-3/esquema-mano/`. A partir de él se hicieron el diagrama en TikZ (`diagrama/integrante-3/ssdc-verificacion-rmi.tikz` y `.tex`) y la diapositiva 3, y la foto quedó enlazada en las notas.
- **Problemas resueltos.** Las dos diapositivas nuevas se desbordaban por abajo y tenían demasiado texto, así que se resumieron y el detalle quedó en las notas. El borrador del fallo suponía que el backend siempre se enteraba del reinicio por una `RemoteException`, pero si hace un nuevo `lookup` la llamada devuelve `false` sin error; lo corregí con los dos casos y cambié la respuesta propuesta (pedir un código nuevo, no reintentar). La diapositiva 5 se ajustó a eso. Las notas pasaron de unas dos páginas y media a una, sin contar el anexo de la foto.
- **Verificación realizada.** Claude compiló diapositivas, notas y diagrama con `biblatex`, `biber` y `babel` en español sobre una copia limpia del repositorio, en su entorno y no en mi equipo: compilaron sin errores y las diapositivas 12 a 16 quedan dentro de la página. Claude comprobó las líneas citadas de `VerificacionController`, `CodigoVerificacionService` y `EmailService` contra el commit `86a238b`, y que las dos URL del `.bib` abren. Al abrirlas, el título de la documentación de Oracle era distinto del que tenía en el `.bib` y lo corregí.
- **Asistencia utilizada.** Claude Sonnet 5.5 (Anthropic, claude.ai) redactó el borrador de las diapositivas 3 a 5 y de las notas, escribió el código del ejemplo del conversor, buscó las dos fuentes, comprobó las líneas citadas, pasó mi bosquejo a TikZ para el diagrama y la diapositiva 3, y resumió mis notas a una página. Yo dibujé el bosquejo a mano, ejecuté el ejemplo, tomé la captura y reescribí CAP, PACELC y el fallo supuesto a partir de su borrador.


## 2026-11-20 - Bloque 1 (RPC): demo JSON-RPC, capturas y diapositivas finales

- **Integrantes presentes.** Belinda Betzabeth Toaquiza Zambrano.
- **Modalidad.** Trabajo individual con asistencia de OpenAI Codex y consulta de fuentes mediante SciSpace.
- **Lo realizado.** Se implementó la demo de `consultarDocenteAsignado` con datos ficticios en memoria: `servidor.py`, `cliente.py` y el lanzador `ejecutar.ps1` en `demo/Belinda T/`. Belinda ejecutó los casos con docente y sin asignación, y tomó las capturas del cliente y del servidor. Se guardaron con nombres descriptivos en `evidencias/Belinda T/demo-json-rpc/`, junto con un registro de verificación automatizada. Se completó la diapositiva de la demo con los comandos para la exposición en vivo y un recorte de la respuesta real, conservando las imágenes originales. Se redactaron las diapositivas de decisiones de distribución y de fallo hipotético, recuperación, comparación con Moodle + Scheduler y conclusión para SGRA.
- **Problemas resueltos.** Se distinguió la ausencia de asignación de un fallo de comunicación. Para el análisis se fijó una topología propuesta con una sola base PostgreSQL, sin réplicas ni caché local del docente, y se evitó atribuir etiquetas CAP/PACELC sin garantías demostradas. El fallo se presentó como supuesto y se propuso repetir únicamente la consulta de lectura tras recuperar el servicio, sin reenviar automáticamente el alta completa. Se ajustaron texto, espacios y recorte de la captura para evitar desbordamientos.
- **Verificación realizada.** Se probó servidor y clientes en procesos separados: docente encontrado, ausencia de asignación, parámetros inválidos, método inexistente, petición inválida, JSON mal formado, notificaciones y lotes. También comprobó el modo Cliente del lanzador PowerShell y el mensaje ante un servidor detenido. Las capturas muestran las consultas 101/12 y 101/99 y su procesamiento por el servidor. Se cotejaron los metadatos de la revisión de Ahmed y colaboradores (2023), DOI 10.32620/reks.2023.2.14, con Crossref y el repositorio institucional, y se descargó su PDF abierto. La comparación se apoyó en documentación oficial de Moodle. Se compilaron la presentación y las notas integradas. La demo no se conectó al SGRA real ni a PostgreSQL; el reinicio del servicio durante una consulta no se probó en una integración distribuida.
- **Pendiente.** Completar las notas formales con los contenidos ya preparados, revisar personalmente las fuentes y ensayar la exposición. La autenticación entre servicios, la consulta de datos reales, las mediciones de latencia y la prueba integrada de corte y recuperación siguen siendo tareas futuras de la propuesta.
- **Asistencia utilizada.** OpenAI Codex escribió el código inicial de la demo, formalizó las decisiones y el escenario supuesto, y ajustó y compiló las diapositivas. SciSpace apoyó la búsqueda de la fuente sobre CAP/PACELC; Crossref, el repositorio institucional y la documentación oficial se utilizaron para contrastar los datos.
- **Registro en Git.** [00f6a3b](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/00f6a3b), «Completa demo JSON-RPC y análisis de distribución de Belinda». Este commit no incluyó la bitácora ni los README privados.
