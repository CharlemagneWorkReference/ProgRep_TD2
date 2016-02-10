import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by cyprien on 05/02/16.
 */
public interface ServiceMultiplication extends Remote {
    double calcule(double a,double b) throws RemoteException;
}
