import java.rmi.RemoteException;

/**
 * Created by cyprien on 08/02/16.
 */
public class ServeurTrigo implements ServiceTrigo {
    @Override
    public double sin(double angle) throws RemoteException {
        return Math.sin(angle);
    }

    @Override
    public double cos(double angle) throws RemoteException {
        return Math.cos(angle);
    }

    @Override
    public double tan(double angle) throws RemoteException {
        return Math.tan(angle);
    }

    @Override
    public double arcsin(double angle) throws RemoteException {
        return Math.asin(angle);
    }
}
