package szoftmod;


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
    
    public String asd = new String("ASD");
    public String qwe = new String("qwe");
    public String rtz = new String("receptesszovegescuccmony");
    
    public main()
    {}

    public void start(Stage primaryStage)
    {
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
        
        //Igy lehet majd beallitani a szoveget 
//        Receptek.setText(rtz);
        
        label.setLayoutY(120);
        label.setLayoutX(30);
        
        
        
        //Igy lehet majd feltolteni, csak ugye ehhez majd irni kell fuggvenyt :) 
       Kajatipus.getItems().addAll("Kérem válasszon étel tipust!",
            asd,
            qwe,
            asd
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
                    //Ide jon az input kezeles
                    //Igy lehet kiszedni h mit valasztott 
                if (event.getSource() == Kajatipus) {
                    System.out.println(Kajatipus.getValue());
                    
                }

    }
}
