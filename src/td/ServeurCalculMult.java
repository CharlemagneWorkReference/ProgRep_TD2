package td;

import java.rmi.RemoteException;

/**
 * Created by cyprien on 05/02/16.
 */
public class ServeurCalculMult implements ServiceMultiplication {
    @Override
    public double calcule(double a, double b) throws RemoteException {
        return a*b;
    }
}
