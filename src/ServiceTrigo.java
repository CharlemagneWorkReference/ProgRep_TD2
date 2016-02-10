import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by cyprien on 05/02/16.
 */
public interface ServiceTrigo extends Remote {
    double sin(double angle) throws RemoteException;
    double cos(double angle) throws RemoteException;
    double tan(double angle) throws RemoteException;
    double arcsin(double angle) throws RemoteException;
}
