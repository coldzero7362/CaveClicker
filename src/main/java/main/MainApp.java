package main;
	
import java.util.HashMap;
import java.util.Map;

import domain.UserVO;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import views.BlacksmithController;
import views.LoginController;
import views.MainController;
import views.MasterController;
import views.QuestController;
import views.RankController;
import views.RegisterController;
import views.ShopController;


public class MainApp extends Application {
	public static MainApp app;
	public static int GOLD = 0;
	
	private StackPane mainPage;
	
	private Map<String, MasterController> controllerMap = new HashMap<>();
	@Override
	public void start(Stage primaryStage) {
		app = this; //싱글톤으로 작성
		try {
			FXMLLoader mainLoader = new FXMLLoader();
			mainLoader.setLocation(getClass().getResource("/views/MainLayout.fxml"));
			mainPage = mainLoader.load();
			
			//메인 컨트롤러를 가져와서 컨트롤러 맵에 넣어준다.
			MainController mc = mainLoader.getController();
			mc.setRoot(mainPage);
			controllerMap.put("main", mc);
			
			FXMLLoader loginLoader = new FXMLLoader();
			loginLoader.setLocation(getClass().getResource("/views/LoginLayout.fxml"));
			AnchorPane loginPage = loginLoader.load();
			
			//로그인 컨트롤러를 가져와서 컨트롤러 맵에 넣는다.
			LoginController lc = loginLoader.getController();
			lc.setRoot(loginPage);
			controllerMap.put("login", lc); 
			
			FXMLLoader registerLoader = new FXMLLoader();
			registerLoader.setLocation(getClass().getResource("/views/RegisterLayout.fxml"));
			AnchorPane registerPage = registerLoader.load();
			
			RegisterController rc = registerLoader.getController();
			rc.setRoot(registerPage);
			controllerMap.put("register", rc);
			
			FXMLLoader shopLoader = new FXMLLoader();
			shopLoader.setLocation(getClass().getResource("/views/ShopLayout.fxml"));
			AnchorPane shopPage  = shopLoader.load();
			
			ShopController sc = shopLoader.getController();
			sc.setRoot(shopPage);
			controllerMap.put("shop", sc);
			
			FXMLLoader RankingLoader = new FXMLLoader();
			RankingLoader.setLocation(getClass().getResource("/views/RankLayout.fxml"));
			AnchorPane RankingPage  = RankingLoader.load();
			
			RankController rkc = RankingLoader.getController();
			rkc.setRoot(RankingPage);
			controllerMap.put("Rank", rkc);
			
			FXMLLoader questLoader = new FXMLLoader();
			questLoader.setLocation(getClass().getResource("/views/QuestLayout.fxml"));
			AnchorPane questPage = questLoader.load();
			
			QuestController qc = questLoader.getController();
			qc.setRoot(questPage);
			controllerMap.put("quest", qc);
			
			FXMLLoader BlacksmithLoader = new FXMLLoader();
			BlacksmithLoader.setLocation(getClass().getResource("/views/BlacksmithLayout.fxml"));
			AnchorPane BlacksmithPage  = BlacksmithLoader.load();
			
			BlacksmithController bsc = BlacksmithLoader.getController();
			bsc.setRoot(BlacksmithPage);
			controllerMap.put("Maker", bsc);
			
			
			
			
			Scene scene = new Scene(mainPage);
			scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
			
			mainPage.getChildren().add(loginPage);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Cave Clicker");
			primaryStage.setResizable(false);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public MasterController getController(String name) {
		return controllerMap.get(name);
	}
	public void loadPane(String name) {
		MasterController c = controllerMap.get(name); //지정한 컨트롤러를 맵에서 꺼낸다.
		c.init();
		Pane pane = c.getRoot();
		System.out.println(pane);
		mainPage.getChildren().add(pane);
		
		pane.setTranslateX(-800); //왼쪽으로 보내고 투명화시킨 뒤 애니메이션 시작
		pane.setOpacity(0);
		
		Timeline timeline = new Timeline();
		KeyValue toRight = new KeyValue(pane.translateXProperty(), 0);
		KeyValue fadeOut = new KeyValue(pane.opacityProperty(), 1);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), toRight, fadeOut);
		
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}
	
	public void slideOut(Pane pane) {
		Timeline timeline = new Timeline();
		KeyValue toRight = new KeyValue(pane.translateXProperty(), 800);
		KeyValue fadeOut = new KeyValue(pane.opacityProperty(), 0);
		
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), (e) -> {
			mainPage.getChildren().remove(pane);
		}, toRight, fadeOut);
		
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}
	public void setLoginInfo(UserVO user) {
		MainController mc = (MainController)controllerMap.get("main");
		mc.setLoginInfo(user);
	}
}