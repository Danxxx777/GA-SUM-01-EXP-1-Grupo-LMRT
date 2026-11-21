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

## 2026-11-20 - Bloque 1 (RPC): notas de la presentación y ajuste del documento grupal

- **Integrantes presentes.** Belinda Betzabeth Toaquiza Zambrano.
- **Modalidad.** Trabajo individual.
- **Lo realizado.** Se completaron las notas con teoría de RPC, explicación de la demo JSON-RPC, aplicación futura a SGRA, decisiones de distribución, fallo hipotético, comparación y conclusión. El archivo `01-integrante-1.tex` se renombró como `Belinda T.tex` dentro de la misma carpeta `notas/secciones/`, y se actualizó su inclusión en `notas/main.tex`. Se resumió el contenido para dejar espacio a los dos integrantes que aún deben completar sus notas. Se actualizó la tabla de aportes, se reunió la declaración de uso de IA en una sección general y se colocaron las referencias al final.
- **Problemas resueltos.** El documento compilado anterior tenía seis páginas, por encima del límite de dos a cuatro páginas totales. Se compactaron los espacios y los encabezados, se ajustaron los saltos de página y se redujo la extensión de las notas, conservando las distinciones entre estado actual, demo y propuesta futura. Se trasladó la declaración de IA de la sección de Eduardo a la declaración general y se ajustó la maquetación de su anexo. Los campos pendientes de los demás integrantes se conservaron en rojo y las rutas con espacios se configuraron para mostrarse correctamente.
- **Verificación realizada.** Se compiló el documento con `pdflatex` y `biber`, se revisaron visualmente sus páginas y se comprobó que la versión final tiene cuatro páginas, sin desbordamientos ni citas indefinidas en la compilación final. Se verificó la nueva ruta `notas/secciones/Belinda T.tex`, la identificación de los expositores, la tabla de aportes, la declaración general de IA y las referencias finales. El resumen de las notas no modificó la guía personal completa.
- **Pendiente.** Los dos integrantes con campos abiertos deben incorporar sus textos y usos efectivos de IA. Después habrá que recompilar y revisar nuevamente la extensión total.
- **Asistencia utilizada.** OpenAI Codex apoyó la redacción formal y el resumen de las notas a partir del contenido informalizado de manera suelta de mi autoria y las evidencias ya preparados, actualizó las rutas y reorganizó los elementos generales.
- **Registro en Git.** [cc84089](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/cc84089), «Completa notas de Belinda y ajusta documento grupal a cuatro páginas». Se publicaron únicamente los cambios de las notas y su PDF; no se incluyeron la bitácora ni los README personales.

### 2026-11-20 · Mera Jumbo Allison

- **Integrantes presentes** — Allison Mera.
- **Commit(s)** — [5aa1bee](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/5aa1bee) — «Completas las diapositivas de teoría gRPC y del ejemplo con la captura de la demo.»; [8e8ed20](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/8e8ed20) — «Agrega el esquema a mano de la arquitectura propuesta».
- **Qué se hizo** — Completé con asistencia de Claude mis dos primeras diapositivas en `slides/secciones/02-integrante-2.tex`: la teoría de gRPC, con un diagrama del contrato `.proto` que genera el cliente y el servidor, y el ejemplo de la consulta de turno por placa, con la entrada, la salida real y la captura de mi demo. Dibujé a mano el bosquejo de la arquitectura propuesta para mi proyecto, con el servicio de Inspecciones llamando por gRPC al de Turnos y Pagos, y lo subí a `evidencias/integrante-2/esquema-mano/`.
- **Problema encontrado** — Al compilar en TeXstudio se sobrescribía `slides/main.pdf` y aparecía el archivo temporal `main.synctex.gz`. Además, al subir el bosquejo, GitHub rechazó el push porque otra integrante había subido cambios al mismo tiempo.
- **Solución y comprobación** — Dejé fuera del commit `main.pdf` y `main.synctex.gz` para no generar conflictos con el PDF del equipo. Integré los cambios remotos con un merge desde IntelliJ y volví a empujar. Compilé `slides/main.tex` y comprobé que mis diapositivas 7 y 8 se vieran sin campos pendientes.
- **Tiempo dedicado** — 40 min.

### 2026-11-20 · Mera Jumbo Allison

- **Integrantes presentes** — Allison Mera.
- **Commit(s)** — [9e6f847](https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT/commit/9e6f847) — «Completa diapositivas de arquitectura, decisiones y fallo del RTV con diagrama, notas y referencias».
- **Qué se hizo** — Completé con asistencia de Claude mis tres últimas diapositivas a partir del informe de mi Proyecto Fin de Curso (RTV): la arquitectura propuesta con el diagrama TikZ `diagrama/integrante-2/rtv-autorizacion-grpc.tikz`, derivado de mi bosquejo a mano; las decisiones de comunicación, transparencias, CAP y PACELC; y el fallo hipotético de una respuesta perdida tras guardar la autorización. Escribí mi sección de notas con el bosquejo como anexo, agregué tres referencias (informe del PFC, guía de *deadlines* de gRPC y documentación de idempotencia de Stripe), puse el nombre del proyecto en `slides/equipo.tex` y actualicé mi fila de aportes y mi declaración de uso de IA en `notas/main.tex`.
- **Problema encontrado** — El prototipo del PFC usa REST, no gRPC, por lo que la propuesta debía presentarse como supuesto. Al hacer el push hubo un conflicto en `notas/main.tex`, porque otra integrante había modificado el mismo párrafo de uso de IA. Además, TeXstudio no compilaba al ejecutar directamente el archivo `.tikz`.
- **Solución y comprobación** — Marqué en el diagrama y en las notas que la llamada gRPC es un supuesto y que hoy es REST. Resolví el conflicto en IntelliJ conservando la versión de mi compañera y añadiendo mi declaración al final del párrafo. Compilé `slides/main.tex` y `notas/main.tex` en lugar de los archivos parciales, y comprobé que no hubiera errores y que las notas se mantuvieran en cuatro páginas.
- **Tiempo dedicado** — 40 min.

## 2026-11-20 - Desarrollo y ensayo personal del bloque 4

- **Integrantes presentes.** Byron Daniel Loor Mendoza.
- **Modalidad.** Trabajo individual con orientación mediante esta sesión de chat y asistencia de OpenAI Codex.
- **Lo realizado.** Byron compiló la demo Java y ejecutó sus modos bloqueante y no bloqueante. Probó respuesta normal, timeout con retardo controlado, conexión fallida después de detener el servidor y una nueva consulta tras reiniciarlo. Se incorporaron esos resultados al bloque de diapositivas y notas. Se revisó el código de CLAB y se formalizó su consulta entre dos servicios en un diagrama TikZ.
- **Problemas resueltos.** Inicialmente se pulsó Ctrl+C en la ventana del cliente y el servidor siguió atendiendo. Se identificó el proceso que escuchaba en 8083, se comprobó que era el servidor de la demo y Byron lo detuvo. Para probar la recuperación se abrieron ventanas separadas de servidor y cliente. Se distinguieron el timeout de petición, el fallo de conexión y la respuesta HTTP 503 que contempla el código de CLAB.
- **Resultados de la ejecución personal.** Las primeras peticiones normales devolvieron HTTP 200 en 149 ms y 77 ms. El endpoint lento produjo HttpTimeoutException en 3021 ms y 3027 ms. Con el servidor detenido, los dos modos reportaron conexión fallida en 52 ms y 61 ms. Tras el reinicio, una nueva consulta bloqueante devolvió HTTP 200 en 159 ms. Son ejecuciones individuales con fines demostrativos.
- **Registro conservado.** Los fragmentos de consola aportados por Byron en el chat se transcribieron en `evidencias/integrante-4/demo-http/transcripcion-2026-11-20.txt`.
- **Fuentes y alcance.** Se cotejaron las definiciones con la documentación de Java 17 y se revisaron fuentes sobre replicación, reservas de recursos y reintentos. El recorrido de CLAB se contrastó con el commit 68cf3db de su esqueleto. Byron compiló CLAB con Maven y ejecutó sus tres pruebas automatizadas. Con los dos servicios iniciados obtuvo la información de Laboratorios a través de Reservas. Después detuvo Laboratorios y el cliente recibió HTTP 503 en 178 ms. Tras reiniciarlo, la consulta correcta devolvió HTTP 200 en 312 ms. Un intento con la ruta mal copiada devolvió 404. Los fragmentos aportados se conservaron en evidencias/integrante-4/demo-http/clab-2026-11-20.txt.
- **Asistencia utilizada.** OpenAI Codex orientó los pasos, contrastó las fuentes, redactó un borrador del contenido y preparó el diagrama a partir del código. Byron ejecutó los programas y proporcionó las salidas. Las comprobaciones de compilación de LaTeX corresponden al asistente.
- **Separación documental.** A petición de Byron, el avance se conserva en integrante-4/ para integrarlo después. Los archivos generales se devolvieron al estado previo a los cambios de esta sesión. La demo permanece en demo/opcion4/.
- **Verificación de la separación.** Codex compiló y revisó visualmente los PDF individuales. La presentación contiene cinco diapositivas de contenido y dos de referencias. Las notas personales ocupan dos páginas. Se comprobó que los archivos generales no conservan modificaciones de esta sesión.

## 2026-11-21 - Precisión del análisis y caso documentado

- **Integrantes presentes.** Byron Daniel Loor Mendoza, mediante esta sesión de chat.
- **Lo realizado.** Con asistencia de Codex se precisaron causa, detección y recuperación de la prueba de CLAB. Se amplió la comparación con MRBS y se formularon preferencias de consistencia para futuras reservas, diferenciadas del código implementado. Se añadió como apoyo el incidente de GitHub del 14 de agosto de 2024 con su fuente oficial, sin adoptarlo como sistema del equipo.
- **Problemas resueltos.** Se distinguió manejar un error 503 de mantener disponible la operación. Se aclaró que el reinicio fue manual y que la demo no demuestra particiones de red, replicación ni superioridad de rendimiento de un modo de llamada. No se repitieron hoy las pruebas ni se atribuyeron nuevos tiempos a Byron.
- **Asistencia utilizada.** Codex contrastó las fuentes y el código, redactó las modificaciones y preparó la actualización de los PDF. La revisión y explicación personal de Byron, el acuerdo del sistema del equipo y el ensayo cronometrado siguen pendientes.
- **Comprobación documental.** Se regeneraron las notas en dos páginas y la presentación con cinco diapositivas principales, un caso de apoyo y referencias. Se revisaron visualmente los apartados modificados. Se añadieron los comandos de compilación al documento existente opcion4.md. También se recompilaron ambos documentos desde una exportación limpia de los archivos preparados para Git, usando la misma instalación LaTeX. Esa comprobación no equivale a probarlos en otro equipo. No se realizó un ensayo cronometrado.

## 2026-11-21 - Integración del bloque 4 en la entrega grupal

- **Integrantes presentes.** Byron Daniel Loor Mendoza, mediante esta sesión de chat.
- **Lo realizado.** A petición de Byron, se trasladó su contenido desde integrante-4/ a las secciones compartidas de diapositivas y notas, a referencias/referencias.bib, a diagrama/integrante-4/ y a evidencias/integrante-4/demo-http/. Los registros individuales se incorporaron a esta bitácora y el documento de apoyo volvió a docs/opcion4.md. Se retiraron los documentos individuales redundantes. El artículo de Ahmed ya existía en la bibliografía del equipo y se reutilizó su clave, sin duplicarlo.
- **Problemas resueltos.** La versión integrada de notas llegó a cinco páginas. Se resumió el bloque de Byron, se ajustó la bibliografía a nueve puntos y se redujo únicamente el tamaño de las fotografías de los bloques 2 y 3, conservando sus textos y los archivos originales. Las notas quedaron en cuatro páginas. Se completaron las tres conclusiones del equipo y se ocultaron las guías de edición.
- **Bosquejo y evidencias.** Se comprobó que la fotografía del bosquejo de Belinda sí existe. Codex preparó un modelo digital sencillo del flujo real de CLAB para que Byron realice su propio esquema manual. Aún no se recibió esa fotografía y no se presenta el modelo digital como dibujo manuscrito ni como primer bosquejo previo al código.
- **Verificación realizada.** Se compilaron la presentación grupal, las notas y el diagrama de referencia. Se revisaron visualmente las páginas. En una exportación temporal se probó una reserva en blanco del tamaño máximo de la futura foto de Byron y las notas se mantuvieron en cuatro páginas, sin usar una imagen ajena como suya.
- **Asistencia utilizada.** Codex realizó la migración, la síntesis del bloque de Byron, el cierre, los ajustes de maquetación y las compilaciones. Las salidas de ejecución siguen siendo las aportadas por Byron el 20 de noviembre. No se atribuyen nuevas pruebas de los sistemas ni lectura personal de fuentes a esta sesión.
- **Pendientes reales.** Foto manual de Byron, ensayo completo con rostro y voz de todos y su enlace abierto en el README, comprobación de las condiciones de entrega y confirmación del caso o alcance acordado por el equipo.
- **Ajuste posterior solicitado.** Se retiró el candidato de GitHub del documento de apoyo y de la bibliografía, porque Byron indicó que el equipo podría haber establecido otro caso. La presentación integrada mantiene la prueba controlada de Laboratorios y Reservas de CLAB. Se resumió la declaración de IA con redacción impersonal, conservando los tipos de asistencia efectivamente utilizados y la distinción de las ejecuciones personales.

## 2026-11-21 - Fotografía del esquema y preparación del ensayo

- **Integrantes presentes.** Byron Daniel Loor Mendoza, mediante esta sesión de chat.
- **Aporte recibido.** Byron entregó la fotografía de su dibujo de CLAB, con nombre y fecha 21-11-2026 visibles. Se guardó en evidencias/integrante-4/esquema-mano/clab-consulta-bosquejo.png y se comprobó que la copia coincide con el archivo original mediante SHA-256. La imagen no se retocó; su giro para lectura se aplica únicamente al incluirla en LaTeX.
- **Integración.** Se enlazó la foto como esquema manuscrito de revisión, realizado después del diagrama digital y de las pruebas. No se presenta como un primer borrador previo al desarrollo.
- **Preparación del video.** A petición de Byron, Codex preparó en el chat un guion orientativo de unos tres minutos sobre las cinco diapositivas del bloque. El guion distingue los resultados registrados el día 20, el estado actual y las propuestas futuras. Todavía no se recibió el video ni se comprobó su duración.
- **Comprobación documental.** Se recompilaron y revisaron visualmente las notas con la fotografía incluida. El documento conserva cuatro páginas, sin citas indefinidas ni desbordamientos en el registro de compilación.

## 2026-11-21 - Modelo supuesto y aplicación oral al PFC

- **Integrantes presentes.** Byron Daniel Loor Mendoza, mediante esta sesión de chat.
- **Solicitud.** Byron precisó que las diapositivas deben explicar un sistema distribuido supuesto y que la aplicación a su proyecto se realizará oralmente, dentro del guion de cada diapositiva.
- **Lo realizado.** Se mantuvieron cinco diapositivas sobre llamadas, demo sencilla, topología Cliente-A-B, decisiones y fallo de dependencia. Se añadió un TikZ del modelo genérico. CLAB, sus rutas y sus puertos quedaron en las notas orales y en el documento de apoyo, separados del modelo proyectado. El bosquejo manuscrito de CLAB se conserva como evidencia de la aplicación al PFC.
- **Alcance y asistencia.** Codex realizó la edición y preparó el guion explicativo. No ejecutó la demostración personal ni añadió mediciones. En el guion se diferencian el flujo de consulta probado, la recuperación manual y las propuestas futuras de reservas replicadas.
- **Verificación documental.** Se recompilaron ambos PDF y se revisó visualmente el bloque. Las cinco diapositivas mantienen los números 17 a 21 y no muestran nombres ni rutas de CLAB. Las notas conservan cuatro páginas, la aplicación oral al PFC y la fotografía original. Se comprobaron los bloques PowerShell mediante análisis de sintaxis, sin ejecutar el experimento del estudiante.

## 2026-11-21 - Corrección de la declaración individual

- **Integrante presente.** Byron Daniel Loor Mendoza, mediante esta sesión de chat.
- **Lo realizado.** Se contrastó la declaración con la sección 6.1 del encuadre. Con asistencia de Codex, se pasó el bloque individual a primera persona y se incorporaron el modelo GPT-6.1 Sol en modo alto y el uso de Overleaf, indicados por Byron. Se conservaron los usos reales en textos técnicos, código y diagramas y la distinción de sus ejecuciones personales desde PowerShell.
- **Verificación.** Codex recompiló las notas y revisó visualmente la página de la declaración. El PDF conserva cuatro páginas. No se ejecutaron nuevas pruebas personales ni se modificaron las declaraciones de los compañeros. El script opcional de grabación quedó fuera de esta corrección.
