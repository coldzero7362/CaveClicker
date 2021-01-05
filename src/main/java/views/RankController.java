package views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.MainApp;

public class RankController extends MasterController{
  @FXML
  private Button backBtn;
  
  
  
 public void back() {
	 MainApp.app.slideOut(getRoot());
} 
 
}
