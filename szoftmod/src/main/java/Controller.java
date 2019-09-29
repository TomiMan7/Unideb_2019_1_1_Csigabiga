import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Controller {


    /**
     * Ez a fuggveny olvassa be a JSON-t es iratja ki a megfelelo receptet a TextFieldbe.
     *
     * @param kaja a main osztaly egy peldanya, ennek a tagvaltozojaban lesz elerheto az etel receptje
     * @param kajanev a lenyilo listaban kivalsztott etelnek a neve. Ezzel tudjuk meg melyik receptet kell kiolvani a JSONbol
     * @throws FileNotFoundException
     */
    public static void TipusBetoltes(main kaja, String kajanev) throws FileNotFoundException {

        /**
         * JSON parser
         * */
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        /**
         * JSON tartalmanak beolvasasa
         * */
        kaja = gson.fromJson(new FileReader("etelek.json"), main.class);

        for(int i = 0; i < kaja.eteltipusok.size(); i++)
        {

            /**
             * A megfelelo etelhez(kajanev) tartozo recept kiolvasasa a kaja.eteltipusok-bol
             */
            if(kaja.eteltipusok.elementAt(i).toString().contains(kajanev))
            {
                main.Receptek.setText("");
                main.Receptek.setText(kaja.eteltipusok.elementAt(i).get("recept"));
            }
        }
    }

    /**
     * Egy egyszeru fgv ami "lekezeli" a NullPointerExceptiont abban az esetben ha eteltipus valtas utan meg nincs etelnev kivalsztva
     */
    public static void semmi()
    {}

}