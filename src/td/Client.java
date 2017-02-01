package td;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by cyprien on 05/02/16.
 */
public class Client {
    public static void main(String[] args){
      try{
            /* Utilisation : java ClientCalcul [hôte] [port] */
    /* Valeurs par défaut : hôte = "localhost", port = 1099 */

    /* adresse & port du serveur de calcul par défaut */
          String serveur="localhost";
          int port=1099;

    /* Si adresse fournie en ligne de commande */
          if( args.length > 0 )
              serveur=args[0];
          if( args.length > 1 )
              port=Integer.parseInt(args[1]);

    /* récupérer l'annuaire sur serveur et port */
          Registry annuaire = LocateRegistry.getRegistry(serveur, port);

    /* récupérer les références distantes */
          ServiceAddition sAdd = (ServiceAddition)       annuaire.lookup("Additionneur");
          ServiceSoustraction sSou = (ServiceSoustraction)   annuaire.lookup("Soustracteur");
          ServiceDivision sDiv = (ServiceDivision)       annuaire.lookup("Diviseur");
          ServiceMultiplication sMul = (ServiceMultiplication) annuaire.lookup("Multiplicateur");
          ServiceTrigo sTrig = (ServiceTrigo)annuaire.lookup("Trigo");

          //td.ServiceTrigo sTrig = (td.ServiceTrigo)annuaire.lookup("Trigo");

    /* faire un calcul ( ( a * ( b + c ) ) - ( d * ( e + f ) ) ) / g */
          double a=100000, b=2000000, c=3000000, d=4000000, e=50000000, f=6000000, g=70000000;
          double test = Math.random();
          double resultat = sDiv.calcule( sSou.calcule( sMul.calcule(a, sAdd.calcule(Math.random(),c)),
                  sMul.calcule(d, sAdd.calcule(e,Math.random()))), g + Math.random());

          System.out.println("Le résultat du calcul est : " + resultat);
          System.out.println("Vérification : " + ((a*(b+c))-(d*(e+f)))/g);

          System.out.println("Sinus : " + sTrig.sin(a));

          //System.out.println("Cosinus de e : " + sTrig.cosinus(e));
      }catch (RemoteException e){
          e.printStackTrace();
          System.exit(1);
      }catch (NotBoundException e){
          e.printStackTrace();
          System.exit(1);
      }
    }
}
