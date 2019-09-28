import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Vector;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class main extends Application implements EventHandler<ActionEvent> {

    static ComboBox Kajatipus = new ComboBox();
    static ComboBox Kajanev = new ComboBox();
    static TextField Receptek = new TextField();
    static Label label = new Label("Az Ön által választott étel receptje:");

    public Vector<Map<String, String>> eteltipusok = new Vector();

    public static main kaja = new main();

    public main()
    {}

    public void start(Stage primaryStage) throws FileNotFoundException {

        primaryStage.setTitle("Digitális receptválogatás");
        primaryStage.setResizable(false);

        Pane layout = new Pane();

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        Kajatipus.setPrefSize(300,20);
        Kajatipus.setPromptText("Étel tipusok:");
        Kajatipus.setLayoutX(30);
        Kajatipus.setLayoutY(10);

        Kajanev.setPrefSize(300,20);
        Kajanev.setPromptText("Kérem válasszon étel tipust előbb!");
        Kajanev.setLayoutX(360);
        Kajanev.setLayoutY(10);

        Receptek.setPrefSize(750,450);
        Receptek.setLayoutX(30);
        Receptek.setLayoutY(150);
        Receptek.setEditable(false);
        Receptek.setPromptText("Kérem válasszon ételt a recept megjelenítéséhez!");

        label.setLayoutY(120);
        label.setLayoutX(30);

        Kajatipus.getItems().addAll("Kérem válasszon étel tipust!",
                "magyaros",
                 "olasz"
        );

        layout.getChildren().add(Kajatipus);
        layout.getChildren().add(Kajanev);
        layout.getChildren().add(Receptek);
        layout.getChildren().add(label);

        Kajatipus.setOnAction(this);
        Kajanev.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == Kajatipus) {

            if(Kajatipus.getValue() == "magyaros")
            {
                Kajanev.getItems().clear();
                Kajanev.getItems().addAll(
                        "gulyas",
                        "porkolt"
                );
            }

            else if(Kajatipus.getValue() == "olasz")
            {
                Kajanev.getItems().clear();
                Kajanev.getItems().addAll(
                        "pizza",
                        "lassagne"
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
