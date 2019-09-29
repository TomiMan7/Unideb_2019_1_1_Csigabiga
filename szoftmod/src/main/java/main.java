import java.io.FileNotFoundException;

import java.util.Map;
import java.util.Vector;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

public class main extends Application implements EventHandler<ActionEvent> {

    /**
     * A lenyilo listak deklaracioja
     * */
    static ComboBox Kajatipus = new ComboBox();
    static ComboBox Kajanev = new ComboBox();

    /**
     * A gomb deklaracioja
     */
    static Button gomb = new Button("Segítség");

    /**
     * Receptmezo deklaracioja
     */
    static TextField Receptek = new TextField();

    /**
     * Cimke deklaracioja
     */
    static Label label = new Label("Az Ön által választott étel receptje:");

    /**
     * A JSON beolvasasahoz hasznalt MAP deklaracioja
     */
    public Vector<Map<String, String>> eteltipusok = new Vector();

    /**
     * a main osztaly egy peldanyanak letrehozasa
     */
    public static main kaja = new main();

    /**
     * Ures konstruktor
     */
    public main()
    {}

    public void start(Stage primaryStage) throws FileNotFoundException {

        /**
         * Ablak nev megadasa
         */
        primaryStage.setTitle("Digitális receptválogatás");
        /**
         * Atmeretezhetoseg letiltas
         */
        primaryStage.setResizable(false);

        Pane layout = new Pane();

        /**
         * Ablakmeret megadas
         */
        Scene scene = new Scene(layout, 800, 600);
        /**
         * Panel hozzadasa a scenehez
         */
        primaryStage.setScene(scene);
        primaryStage.show();

        /**
         * A gomb meretenek beallitasa
         */
        gomb.setPrefSize(100,20);

        /**
         * A gomb helyének megadasa
         */
        gomb.setLayoutX(680);
        gomb.setLayoutY(10);

        /**
         * Lenyilo lista meretnek beallitasa
         */
        Kajatipus.setPrefSize(300,20);
        /**
         * Lenyilo lista kezdo szovegenek beallitasa
         */
        Kajatipus.setPromptText("Étel tipusok:");
        /**
         * Lenyilo lista helyenek megadasa
         */
        Kajatipus.setLayoutX(30);
        Kajatipus.setLayoutY(10);

        Kajanev.setPrefSize(300,20);
        Kajanev.setPromptText("Kérem válasszon étel tipust előbb!");
        Kajanev.setLayoutX(360);
        Kajanev.setLayoutY(10);

        /**
         * Recept szovegenek helye a Bal felso sarokba igazitasa
         */
        Receptek.setAlignment(Pos.TOP_LEFT);
        Receptek.setPrefWidth(10);
        Receptek.setPrefSize(750,450);
        Receptek.setLayoutX(30);
        Receptek.setLayoutY(150);
        /**
         * Szovegmezo valtoztathatosaganak letiltasa
         */
        Receptek.setEditable(false);
        Receptek.setPromptText("Kérem válasszon ételt a recept megjelenítéséhez!");

        label.setLayoutY(120);
        label.setLayoutX(30);

        /**
         * Lenyilo lista feltoltese a tipusokkal
         */
        Kajatipus.getItems().addAll("Kérem válasszon étel tipust!",
                "magyaros",
                 "olasz"
        );

        //gomb.setOnAction(e -> Controller.Segitseg());

        /**
         * GUI elemek hozzaadas az ablakhoz
         */
        layout.getChildren().add(gomb);
        layout.getChildren().add(Kajatipus);
        layout.getChildren().add(Kajanev);
        layout.getChildren().add(Receptek);
        layout.getChildren().add(label);

        /**
         * User input kezelesenek megadasa
         */
        gomb.setOnAction(this);
        Kajatipus.setOnAction(this);
        Kajanev.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {

        /**
         * Ha a gombon tortent esemeny, akkor hivja meg a segitseg fgv-t
         */
        if (event.getSource()==gomb){
            Controller.Segitseg();
        }

        /**
         * User input helyenek megszerzese
         */
        if (event.getSource() == Kajatipus) {

            if(Kajatipus.getValue() == "magyaros")
            {
                /**
                 * Osszes eddigi elem kitorlese a korabbi keresesek miatt
                 */
                Kajanev.getItems().clear();
                /**
                 * Uj elemekkel valo feltoltes
                 */
                Kajanev.getItems().addAll(
                        "Gulyasleves",
                        "Sertesporkolt",
                        "Toltott kaposzta",
                        "Finomfozelek",
                        "Turos csusza"
                );
            }

            else if(Kajatipus.getValue() == "olasz")
            {
                Kajanev.getItems().clear();
                Kajanev.getItems().addAll(
                        "Pizza",
                        "Lassagne",
                        "Ravioli",
                        "Bolognai spagetti",
                        "Carbonara"
                );
            }
        }


        try {
            if (event.getSource() == Kajanev) {
                try {
                    Controller.TipusBetoltes(main.kaja, Kajanev.getValue().toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }catch (NullPointerException e)
        {Controller.semmi();}

    }
}
