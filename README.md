# EXP-1 · RPC, gRPC y Java RMI

Equipo LMRT. Plantilla para cuatro proyectos en proceso de distribución.

## Enfoque acordado

La estructura usa el direccionamiento del docente comunicado por el equipo el 18 de noviembre de 2026. Cada integrante explica teoría, ejecuta una demo pequeña y plantea cómo aplicaría esa comunicación a su propio proyecto. Las decisiones y los fallos futuros se identifican como propuestas o hipótesis. Las afirmaciones sobre el estado actual llevan evidencia del proyecto.

## Reparto acordado

| Responsable y archivo de slides/secciones | Tema de partida | Demo sugerida |
|---|---|---|
| Belinda Toaquiza - 01-integrante-1.tex | RPC | Una operación mediante una implementación RPC |
| Allison Mera - 02-integrante-2.tex | gRPC | Llamada unaria |
| Eduardo Reinoso - 03-integrante-3.tex | Java RMI | Conversor Celsius–Fahrenheit |
| Byron Daniel Loor - 04-integrante-4.tex | Llamadas y fallos de red | Llamada RPC/gRPC/RMI con un fallo controlado |

Cada responsable completa el nombre de su proyecto en slides/equipo.tex y desarrolla su bloque. Los campos y las directrices pendientes se muestran en rojo.

## Qué completa cada integrante

1. Teoría breve y fuente verificable, publicada desde 2021.
2. Demo ejecutable con contrato, entrada y resultado observado.
3. Problema, usuarios y estado actual del proyecto. Las cifras del piloto se identifican como mediciones y las de capacidad futura como supuestos.
4. Arquitectura propuesta. Preparar un bosquejo propio a mano y el diagrama editable, distinguiendo componentes actuales y futuros.
5. Comunicación y motivación técnica. Explicar transparencias, CAP y PACELC desde una operación y una topología explícitas.
6. Fallo hipotético y análisis de causa raíz, con la detección y recuperación propuestas. Una prueba ejecutada se documenta como simulación.
7. Comparación con un sistema real, compromiso técnico y lección para implementar en el proyecto.

Cada bloque dispone de cinco diapositivas para sintetizar estos puntos. Las instrucciones rojas se ocultan con la opción de guías del tema al terminar de editar.

## Evidencias y entregables

- Cada integrante guarda su bosquejo y su diagrama en evidencias/integrante-N y diagrama/integrante-N. Las fotos del bosquejo se insertan en sus notas.
- Guardar las capturas de lectura con página, autor y referencia. El requisito escrito es de al menos tres capturas en el equipo. Cada integrante debe comprender las fuentes que usa.
- Bibliografía general IEEE con biblatex en evidencias/capturas-fuentes/referencias.bib. Se incluyen seis publicaciones recientes del trabajo anterior como punto de partida. Revisar cuáles respaldan cada proyecto y la indexación exigida para al menos tres artículos de revista.
- Notas en notas/main.tex, con un archivo por integrante, tabla de aportes y declaración de IA. La plantilla compila en cuatro páginas. Ajustar la extensión al completar los guiones y las fotos.
- Registrar trabajo real en BITACORA.md y commits significativos de cada integrante. El requisito escrito pide tres días de trabajo y tres commits por persona.
- Verificar FORM-MC-01 y FORM-AC-01, registro del sistema y las restricciones de TA-IND-01 según las indicaciones vigentes del docente.
- Incluir enlace del ensayo en este README. La rúbrica escrita establece 12 minutos y 3 de preguntas. El equipo informa que el docente flexibilizó la duración. Mantener el contenido breve y registrar el límite definitivo para el ensayo.
- Entregar en SGA un PDF de una página con identificación del equipo y URL completa del repositorio en una sola línea.

## Compilación

Desde slides, ejecutar en este orden:

```powershell
pdflatex -interaction=nonstopmode -halt-on-error main.tex
biber main
pdflatex -interaction=nonstopmode -halt-on-error main.tex
pdflatex -interaction=nonstopmode -halt-on-error main.tex
```

Desde notas, ejecutar pdflatex main.tex dos veces. Se necesitan Beamer, TikZ, Babel español, mathptmx, biblatex-ieee y Biber. El diagrama de ejemplo es editable en TikZ.

## Ensayo

[Agregar enlace del video.]

## Publicación

https://github.com/Danxxx777/GA-SUM-01-EXP-1-Grupo-LMRT
