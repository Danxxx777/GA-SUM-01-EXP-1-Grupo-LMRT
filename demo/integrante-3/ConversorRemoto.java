package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/** Contrato remoto: lo que el cliente puede pedir al servidor. */
public interface ConversorRemoto extends Remote {

    double aFahrenheit(double celsius) throws RemoteException;
}
