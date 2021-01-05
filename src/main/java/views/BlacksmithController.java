package views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.MainApp;

public class BlacksmithController extends MasterController {
	@FXML
	private Label gold;

	private int goldCost;

	
	MainController mc;

	@FXML
	public void initialize() {
		mc = (MainController) MainApp.app.getController("main");
		goldCost = mc.getGoldSum();

	}

	@Override
	public void init() {
		goldCost = mc.getGoldSum();
		gold.setText(Integer.toString(goldCost));
	}

	public void back() {

		MainApp.app.slideOut(getRoot());
		
	}

}
