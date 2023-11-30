// Importation des classes nécessaires pour la manipulation du contexte de nommage et la recherche d'objet.
package corbaClient;

import javax.naming.Context;
import javax.naming.InitialContext;

// Classe principale du client pour la conversion.
public class ConversionClient {
    public static void main(String[] args) {
        try {
            // Initialisation du contexte JNDI pour la recherche d'objet.
            Context ctx = new InitialContext();

            // Recherche de l'objet distant en utilisant la clé "OD".
            Object ref = ctx.lookup("OD");

            // Création du stub en convertissant l'objet trouvé en un stub CORBA.
            corbaConversion.IConversionRemote stub = corbaConversion.IConversionRemoteHelper.narrow((org.omg.CORBA.Object) ref);

            // Appel de la méthode distante pour convertir un montant et affichage du résultat.
            System.out.println(600.2 + " Euro -> " + stub.conversionMontant(600.2) + " dt");
            System.out.println(5000 + " Euro -> " + stub.conversionMontant(5000) + " dt");
        } catch (Exception e) {
            // Gestion des exceptions en affichant la trace de la pile.
            e.printStackTrace();
        }
    }
}
