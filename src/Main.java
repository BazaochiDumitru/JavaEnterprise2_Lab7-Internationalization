import java.text.NumberFormat;
import java.util.*;
import java.nio.charset.Charset;
import java.text.DateFormat;

public class Main {
    public static void main(String[] args) {
        // Afiseaza codificare implicită
        System.out.println("Codificare implicită:"+System.getProperty("file.encoding"));

        Double number = 674.2;

        //Formatul numerelor
        Locale localizare= new Locale("ro","MD");

        NumberFormat formatare=NumberFormat.getNumberInstance(localizare); // Formatul numărului corespunzător localizării
        String rezultat= formatare.format(number); // Convertește un număr într-un șir în funcție de formatul numărului
        System.out.println(rezultat+" "+localizare.toString()); // Afișează rezultatul

        System.out.println("\nLocalizări disponibile:");
        // Lista localurilor disponibile
        Locale lista[]=Locale.getAvailableLocales(); // Obține toate localitățile disponibile
        for (int i=0;i<lista.length;i++){ //Buclă toate localitățile disponibile
            System.out.println(lista[i].toString());
        }

        System.out.println("\nFormatul datei");
        //Afiseaza data
        Date azi= new Date(); // Primește data de azi
        DateFormat dformatare= DateFormat.getDateInstance(DateFormat.DEFAULT,localizare); // Obține formatul de dată corespunzător localizării (franceză).
        String data = dformatare.format(azi); //Convertește o dată într-un șir în funcție de formatul de dată al acestei localități
        System.out.println(data+"\t"+localizare); // Afișează rezultatul

        System.out.println("\nSeturi de caractere disponibile: ");
        // Afișează toate codificările disponibile
        Iterator<String> $it=
                Charset.availableCharsets().keySet().iterator(); // Obținerea unui iterator să itereze prin toate codificările disponibile
        while($it.hasNext()){ // Afisarea tuturor codificărilor
            System.out.println($it.next());
        }

        // Localizare standard
        Locale loc = Locale.getDefault(); // Obține localitatea implicită (depinde de sistemul în care rulează programul)
        System.out.println("\nLocalizare implicită: "+loc); // Nume local (ru_RU)
        System.out.println(loc.getLanguage()); // Codul numelui limbii locale (ru)
        System.out.println(loc.getCountry()); // Cod de țară locală (RU)
        System.out.println(loc.getDisplayLanguage()); //Numele limbii locale: rusă
        System.out.println(loc.getDisplayCountry()); // Nume țara locală: Rusia
        System.out.println(loc.getDisplayLanguage(Locale.ENGLISH)); //Numele limbii locale într-o altă limbă locală (engleza): russe
        System.out.println(loc.getDisplayCountry(Locale.ENGLISH)); //Numele țării localității în limba altei locații (în engleza): Russie
    }
}