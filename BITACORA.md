# Bitácora de la exposición

## 2026-11-18 - Armazón de la opción 4

- Byron Daniel Loor Mendoza eligió preparar la opción 4 del reparto del equipo y proporcionó este repositorio para la exposición.
- OpenAI Codex asistió en la preparación del cliente Java con modos bloqueante y no bloqueante, el servidor con retardo controlado y las instrucciones de ensayo.
- Se reutilizó como aplicación al PFC la consulta HTTP entre Reservas y Laboratorios del esqueleto de CLAB. Los programas de ejemplo se guardan en `demo/opcion4/`.
- La preparación distingue el error de conexión del cliente, el timeout y la respuesta HTTP 503 emitida por Reservas cuando falla Laboratorios.
- Verificación técnica del asistente. Los dos programas compilaron con `javac --release 17`. También se comprobó el rechazo de un modo de cliente inválido y de un puerto fuera de rango. Los casos de comunicación se ensayarán con los servicios ejecutándose.
- Las capturas y los tiempos de la demostración se obtienen durante la ejecución personal del integrante.
