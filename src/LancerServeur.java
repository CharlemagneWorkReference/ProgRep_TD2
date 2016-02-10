import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by cyprien on 05/02/16.
 */
public class LancerServeur {
    public static void main(String[] args){
        ServeurCalculAdd serveurCalcul = new ServeurCalculAdd();
        ServeurCalculSous serveurCalculSous = new ServeurCalculSous();
        ServeurCalculMult serveurCalculMult = new ServeurCalculMult();
        ServeurCalculDiv serveurCalculDiv = new ServeurCalculDiv();
        ServeurTrigo serveurTrigo = new ServeurTrigo();
        try{
            Registry reg = LocateRegistry.getRegistry();
            ServiceAddition serviceAddition = (ServiceAddition)UnicastRemoteObject.exportObject(serveurCalcul,0);
            ServiceSoustraction serviceSoustraction = (ServiceSoustraction)UnicastRemoteObject.exportObject(serveurCalculSous,0);
            ServiceMultiplication serviceMultiplication = (ServiceMultiplication)UnicastRemoteObject.exportObject(serveurCalculMult,0);
            ServiceDivision serviceDivision = (ServiceDivision)UnicastRemoteObject.exportObject(serveurCalculDiv,0);
            ServiceTrigo serviceTrigo = (ServiceTrigo)UnicastRemoteObject.exportObject(serveurTrigo,0);

            reg.rebind("Additionneur", serviceAddition);
            reg.rebind("Soustracteur", serviceSoustraction);
            reg.rebind("Multiplicateur", serviceMultiplication);
            reg.rebind("Diviseur", serviceDivision);
            reg.rebind("Trigo",serviceTrigo);
        }catch (RemoteException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
