import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Controller {

    public static void TipusBetoltes(main kaja, String kajanev) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        kaja = gson.fromJson(new FileReader("etelek.json"), main.class);

        for(int i = 0; i < kaja.eteltipusok.size(); i++)
        {

            if(kaja.eteltipusok.elementAt(i).toString().contains(kajanev))
            {
                main.Receptek.setText("");
                main.Receptek.setText(kaja.eteltipusok.elementAt(i).get("recept"));
            }
        }
    }

    public static void semmi()
    {}

}