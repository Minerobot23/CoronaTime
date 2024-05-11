package coronatime;



import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author C_Garcia
 */
public class CoronaTime extends Application {
    
    Scene scene1;
    Scene scene2;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("main.fxml"));
        
        
         scene1 = new Scene(root1);
        
        
        stage.setScene(scene1);
        stage.show();
        
       
        
    }
    
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}