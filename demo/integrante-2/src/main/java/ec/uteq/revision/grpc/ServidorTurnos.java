package ec.uteq.revision.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Map;

/**
 * Servidor gRPC que representa al servicio de Turnos y Pagos.
 * Responde si un vehículo, identificado por su placa, tiene turno de revisión.
 */
public class ServidorTurnos {

    static final int PUERTO = 50051;

    /** Datos de prueba en memoria: placa -> {fecha, estado}. */
    private static final Map<String, String[]> TURNOS = Map.of(
            "GSA-1234", new String[]{"2026-11-25 09:00", "CONFIRMADO"},
            "MBA-0567", new String[]{"2026-11-26 14:30", "PENDIENTE_PAGO"}
    );

    /** Implementación de la operación definida en turnos.proto. */
    static class TurnosServiceImpl extends TurnosServiceGrpc.TurnosServiceImplBase {
        @Override
        public void consultarTurno(ConsultaTurnoRequest peticion,
                                   StreamObserver<ConsultaTurnoResponse> respuesta) {
            String placa = peticion.getPlaca().trim().toUpperCase();
            String[] turno = TURNOS.get(placa);

            ConsultaTurnoResponse.Builder salida = ConsultaTurnoResponse.newBuilder();
            if (turno != null) {
                salida.setTieneTurno(true).setFecha(turno[0]).setEstado(turno[1]);
            } else {
                salida.setTieneTurno(false).setEstado("SIN_TURNO");
            }

            ConsultaTurnoResponse resultado = salida.build();
            System.out.println("Servidor: consulta de " + placa + " -> " + resultado.getEstado());
            respuesta.onNext(resultado);   // envía la respuesta al cliente
            respuesta.onCompleted();       // cierra la llamada unaria
        }
    }

    public static void main(String[] args) throws Exception {
        Server servidor = ServerBuilder.forPort(PUERTO)
                .addService(new TurnosServiceImpl())
                .build()
                .start();
        System.out.println("Servidor: TurnosService escuchando en el puerto " + PUERTO);
        servidor.awaitTermination();
    }
}