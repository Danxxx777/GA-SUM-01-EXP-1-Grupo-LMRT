# EXP-1 · Equipo LMRT

**Actividad:** GA-SUM-02 / EXP-1, Aplicaciones Distribuidas.

**Tema:** RPC, gRPC, Java RMI y modelos de comunicación aplicados a propuestas de distribución de los proyectos del equipo.

Repositorio público: https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT

Los materiales distinguen el estado actual comprobado en código, las demos ejecutadas y las propuestas futuras. Los incidentes hipotéticos se identifican como tales. La propuesta de SGRA no se presenta como una integración ya desplegada.

## Integrantes y bloques

| Integrante | Bloque |
|---|---|
| Toaquiza Zambrano Belinda Betzabeth | RPC, demo JSON-RPC y propuesta para SGRA |
| Mera Jumbo Allison Michelle | gRPC y servicio de consulta de turnos |
| Reinoso Vélez Eduardo David | Java RMI y propuesta para SSDC |
| Loor Mendoza Byron Daniel | Llamadas bloqueantes/no bloqueantes y fallos de comunicación; CLAB |

## Video del ensayo

**PENDIENTE — pegar aquí el enlace al ensayo completo:**

**URL:** PENDIENTE

**Plataforma:** YouTube no listado o Google Drive con acceso abierto.

**Fecha y duración:** PENDIENTE.

El ensayo debe mostrar rostro y voz de todos los integrantes. Antes de entregar, comprobar el acceso desde una sesión sin iniciar y la duración exigida para la actividad.

## Archivos de la entrega

| Material | Ubicación |
|---|---|
| Diapositivas Beamer | [slides/main.tex](slides/main.tex) |
| PDF de diapositivas | [slides/main.pdf](slides/main.pdf) |
| Notas grupales | [notas/main.tex](notas/main.tex) |
| PDF de notas, 2 a 4 páginas totales | [notas/main.pdf](notas/main.pdf) |
| Bibliografía general IEEE | [referencias/referencias.bib](referencias/referencias.bib) |
| PDF abiertos de artículos | [referencias/PDFs](referencias/PDFs/) |
| Diagramas editables | [diagrama](diagrama/), archivos TikZ y sus documentos LaTeX |
| Fotografías de bosquejos y capturas de demos | [evidencias](evidencias/) |
| Capturas y anotaciones de artículos citados | [evidencias/capturas-fuentes](evidencias/capturas-fuentes/) |
| Código de las demos | [demo](demo/) |
| Registro de sesiones | [BITACORA.md](BITACORA.md) |

Cada integrante edita su sección en slides/secciones/ y notas/secciones/. El estilo de las diapositivas está en slides/tema.tex; los nombres y proyectos se definen en slides/equipo.tex.

El [modelo digital del esquema de CLAB](diagrama/integrante-4/clab-consulta-http.png) se conserva junto a la [fotografía original del esquema manuscrito de revisión de Byron](evidencias/integrante-4/esquema-mano/clab-consulta-bosquejo.png), fechada el 21-11-2026 e incluida en las notas.

La declaración **general** de uso de IA está al final de notas/main.tex, después de la tabla de aportes y antes de las referencias. Las contribuciones y comprobaciones se describen también en la bitácora.

## Compilación

### Requisitos

- Distribución LaTeX con **pdfLaTeX** y **Biber**: MiKTeX o TeX Live.
- Paquetes: beamer, pgf/TikZ, biblatex con estilo ieee, babel con español, fontenc/T1, mathptmx, graphicx, xcolor, booktabs, tabularx, geometry, url e hyperref.
- No mover la bibliografía ni las imágenes: las rutas son relativas a los archivos principales.
- Ejecutar desde una copia local del repositorio. Las rutas que contienen espacios deben ir entre comillas.

### Diapositivas

Desde la raíz del repositorio, en PowerShell:

    Set-Location slides
    pdflatex -interaction=nonstopmode -halt-on-error main.tex
    biber main
    pdflatex -interaction=nonstopmode -halt-on-error main.tex
    pdflatex -interaction=nonstopmode -halt-on-error main.tex
    Set-Location ..

Resultado: slides/main.pdf.

### Notas

Desde la raíz:

    Set-Location notas
    pdflatex -interaction=nonstopmode -halt-on-error main.tex
    biber main
    pdflatex -interaction=nonstopmode -halt-on-error main.tex
    pdflatex -interaction=nonstopmode -halt-on-error main.tex
    Set-Location ..

Resultado: notas/main.pdf. Volver a comprobar el límite de 2 a 4 páginas cuando se completen las secciones pendientes.

Las referencias se mantienen generales y al final. Ambos documentos cargan referencias/referencias.bib con biblatex y Biber.

## Evidencias y autoría

- Historial progresivo y aportes individuales: commits del repositorio; detalle en BITACORA.md.
- Bosquejos originales: evidencias de cada integrante y anexo de las notas.
- Demo JSON-RPC: capturas personales del cliente y servidor en evidencias/Belinda T/demo-json-rpc/. El registro automatizado se identifica por separado.
- Lecturas RPC: pasajes de Zhang, Arcuri y Ahmed, con páginas, DOI y síntesis, en evidencias/capturas-fuentes/. Belinda confirmó su lectura; la elaboración de subrayados y notas con asistencia de IA se declara en las evidencias.
- El uso de documentación técnica oficial complementa los artículos científicos; no reemplaza el mínimo de tres artículos de revistas indexadas con DOI.

## Pendientes antes de la entrega

- [ ] Añadir el enlace abierto al video del ensayo y comprobar rostro y voz de todos.
- [x] Integrar los cuatro bloques, completar el cierre y ocultar las guías de edición.
- [ ] Completar los usos de IA que aún no se hayan declarado.
- [x] Recompilar los PDF integrados y comprobar las notas en cuatro páginas.
- [x] Incorporar la fotografía auténtica del esquema manuscrito de revisión de Byron, con nombre y fecha real, y volver a revisar el PDF.
- [ ] Confirmar la entrega previa de FORM-MC-01 y FORM-AC-01 en el SGA.
- [ ] Confirmar el registro del tema y que no repita el sistema del TA-IND-01 de un integrante, conforme al encuadre acordado con el docente.
- [ ] Formular una pregunta crítica a otro equipo. **Pregunta propuesta:** si el cliente agota su tiempo de espera después de que el servidor guarda una operación, ¿cómo evitan duplicarla al reintentar y con qué prueba lo comprueban?
- [ ] Ensayar respuestas sobre las secciones de los demás integrantes.
- [ ] Verificar acceso público al repositorio y completar el material antes de la clase.
