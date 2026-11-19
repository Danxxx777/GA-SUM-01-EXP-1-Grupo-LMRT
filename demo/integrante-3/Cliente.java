package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/** Uso: java -cp build rmi.Cliente [host] [celsius] */
public class Cliente {

    public static void main(String[] args) throws Exception {
        String host = args.length > 0 ? args[0] : "localhost";
        double celsius = args.length > 1 ? Double.parseDouble(args[1]) : 25.0;

        Registry registro = LocateRegistry.getRegistry(host, Servidor.PUERTO_REGISTRO);
        ConversorRemoto conversor = (ConversorRemoto) registro.lookup(Servidor.NOMBRE);

        // El cliente no tiene el objeto real: tiene un stub (representante local).
        System.out.println("Cliente: tipo del objeto recibido = " + conversor.getClass().getName());
        double fahrenheit = conversor.aFahrenheit(celsius);
        System.out.println("Cliente: " + celsius + " C = " + fahrenheit + " F");
    }
}
