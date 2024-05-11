/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronatime;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author C_Garcia
 */
public class Controller {
    
   public Button search;
   public Button searchA;
   
   public TextField enteredC;
   public Text deathT;
   public Text recoveredT;
   public Text confirmedT;
   public Text countryT;
   public TableView<Cases> test;
   public TableColumn <Cases, String> countryC;
   public TableColumn <Cases, String> confirmedC;
   public TableColumn <Cases, String> recoveredC;
   public TableColumn <Cases, String> deathC;
   
   Stats s1 = new Stats();
   CoronaTime c1 = new CoronaTime();
   
  
   
    private Text input;
  
   public void initializ(){
      
        s1.getWorldStats();
        
        ObservableList<Cases> cases = FXCollections.observableArrayList();
        for(int i = 0; i < 5; i++){
        
            cases.add(new Cases(s1.countryA.get(i),s1.confirmedA.get(i),s1.recoveredA.get(i),s1.deathsA.get(i)));
      
        }
       
        countryC.setCellValueFactory(new PropertyValueFactory<>("country"));
        confirmedC.setCellValueFactory(new PropertyValueFactory<>("confirmed"));
        recoveredC.setCellValueFactory(new PropertyValueFactory<>("recovered"));
        deathC.setCellValueFactory(new PropertyValueFactory<>("death"));
        test.setItems(cases);
       
        
    }
   
  
    @FXML
    public void handleButtonCick(){
       
        
        s1.getWorldStats(enteredC.getText());
        
        System.out.print(s1.country);
        deathT.setText(s1.death);
        recoveredT.setText(s1.recovered);
        confirmedT.setText(s1.confirmed);
        countryT.setText(s1.country);
        enteredC.setText("");
    
    }
    
    
    @FXML
    public void handleAllButton(){
    
        s1.getAllStats();
        deathT.setText(s1.allDeaths);
        recoveredT.setText(s1.allRecovered);
        confirmedT.setText(s1.allConfirmed);
         countryT.setText("Worldwide");
    
    }
    
    public void searchButton(ActionEvent event) throws IOException{
      Parent searchParent = FXMLLoader.load(getClass().getResource("search.fxml"));
      Scene searchViewScene = new Scene(searchParent); 
        
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      
      window.setScene(searchViewScene);
      window.show();
      
    }

   @FXML
    public void allCasesButton(ActionEvent event) throws IOException{
      Parent casesParent = FXMLLoader.load(getClass().getResource("Test.fxml"));
      Scene casesViewScene = new Scene(casesParent); 
        
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      
      window.setScene(casesViewScene);
      window.show();
      
    }

    
    
    
}
