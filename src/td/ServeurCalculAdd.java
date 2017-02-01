package td;

import java.rmi.RemoteException;

public class ServeurCalculAdd implements ServiceAddition {
    public ServeurCalculAdd(){}


    @Override
    public double calcule(double a, double b) throws RemoteException {
        return a+b;
    }

}
