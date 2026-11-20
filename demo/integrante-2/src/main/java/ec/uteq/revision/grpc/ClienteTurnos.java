package ec.uteq.revision.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

/**
 * Cliente gRPC que representa al servicio de Inspecciones.
 * Antes de iniciar una revisión, consulta a Turnos si el vehículo tiene turno.
 */
public class ClienteTurnos {

    public static void main(String[] args) throws Exception {
        String placa = args.length > 0 ? args[0] : "GSA-1234";

        // Canal hacia el servidor (sin TLS, solo para la demo local).
        ManagedChannel canal = ManagedChannelBuilder
                .forAddress("localhost", ServidorTurnos.PUERTO)
                .usePlaintext()
                .build();

        try {
            // Stub bloqueante generado a partir de turnos.proto.
            TurnosServiceGrpc.TurnosServiceBlockingStub stub = TurnosServiceGrpc
                    .newBlockingStub(canal)
                    .withDeadlineAfter(3, TimeUnit.SECONDS);

            ConsultaTurnoRequest peticion = ConsultaTurnoRequest.newBuilder()
                    .setPlaca(placa)
                    .build();

            System.out.println("Cliente: consulto el turno de " + placa);
            ConsultaTurnoResponse respuesta = stub.consultarTurno(peticion);

            if (respuesta.getTieneTurno()) {
                System.out.println("Cliente: tiene turno el " + respuesta.getFecha()
                        + " (estado " + respuesta.getEstado() + ")");
            } else {
                System.out.println("Cliente: no tiene turno (estado " + respuesta.getEstado() + ")");
            }
        } catch (StatusRuntimeException e) {
            // Por ejemplo UNAVAILABLE si el servidor está apagado
            // o DEADLINE_EXCEEDED si no responde a tiempo.
            System.out.println("Cliente: la llamada falló con " + e.getStatus().getCode());
        } finally {
            canal.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}