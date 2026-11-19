package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/** Objeto remoto: la conversión se ejecuta en la JVM del servidor. */
public class Servidor implements ConversorRemoto {

    static final int PUERTO_REGISTRO = 1099;
    static final String NOMBRE = "Conversor";

    @Override
    public double aFahrenheit(double celsius) throws RemoteException {
        double resultado = celsius * 9.0 / 5.0 + 32.0;
        System.out.println("Servidor: recibi " + celsius + " C, respondo " + resultado + " F");
        return resultado;
    }

    public static void main(String[] args) throws Exception {
        Servidor objeto = new Servidor();
        // Exporta el objeto: genera el stub que recibirán los clientes.
        ConversorRemoto stub = (ConversorRemoto) UnicastRemoteObject.exportObject(objeto, 0);
        // Crea el registro (directorio de nombres) y publica el stub.
        Registry registro = LocateRegistry.createRegistry(PUERTO_REGISTRO);
        registro.rebind(NOMBRE, stub);
        System.out.println("Servidor: '" + NOMBRE + "' publicado en el puerto " + PUERTO_REGISTRO);
    }
}
