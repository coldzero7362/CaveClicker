package views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.MainApp;

public class ShopController extends MasterController {
	
	@FXML
	private Button backBtn;
	
	@FXML
	private Button ATkup;
	@FXML
	private Button tikup;
	@FXML
	private Button kGoldUp;
	
	@FXML
	private Label Gold;
	@FXML
	private Label Test;
	@FXML
	private Label say;
	@FXML
	private Label costATK;
	@FXML
	private Label costTik;
	@FXML
	private Label costKG;
	@FXML
	private Label upgradeLevelATK;
	@FXML
	private Label upgradeLevelTik;
	@FXML
	private Label upgradeLevelKill;
	
	
	private int cost1;
	private int cost2;
	private int cost3;
	private int costplus1;
	private int costplus2;
	private int costplus3;
	private int goldron;
	private int tikGold;
	private int Stage;
	private int killGold;
	private int goldCnt;
	
	private int shopAttack;

	
	private int upgradelevel1; 
	private int upgradelevel2; 
	private int upgradelevel3; 
	
	private int upgradeCnt;
	
	MainController mc; 
	
	@FXML
	public void initialize() {
		mc = (MainController)MainApp.app.getController("main");
		goldron = mc.getGoldSum();
		shopAttack = mc.getAttack();
		tikGold = mc.getGoldPlus();
		killGold = mc.getKillGold();
		Stage = mc.getStageNum();
		upgradeCnt = mc.getUpgradeCnt();
		goldCnt = mc.getGoldCnt();
		
		
		upgradelevel1 = 1;
		upgradelevel2 = 1;
		upgradelevel3 = 1;
		
		say.setText("안녕하세요");
		Gold.setText(Integer.toString(goldron));
		cost1 = 20;
		cost2 = 100;
		cost3 = 60;
		costplus1 = 0;
		costplus2 = 0;
		costplus3 = 0;
		
		costATK.setText("비용 : "+cost1);
		costTik.setText("비용 : "+cost2);
		costKG.setText("비용 : "+cost3);
	}
	@Override
	public void init() {
		goldron = ((MainController)MainApp.app.getController("main")).getGoldSum();
		Gold.setText("GOLD : " + goldron);
		costATK.setText("비용 : "+cost1);
		costTik.setText("비용 : "+cost2);
		costKG.setText("비용 : "+cost3);
		say.setText("어서오세요");
	}
	
	
	public void ATKUpCost() {
		cost1+= shopAttack * 3;
		costATK.setText("비용 : "+cost1);
	}
	public void tikGoldUpCost() {
		cost2+=  tikGold * 6;
		costTik.setText("비용 : "+cost2);
	}
	public void killGoldUpCost() {
		cost3+=  killGold * 2;
		costKG.setText("비용 : "+cost3);
	}
	
	public void ATKPlus() {
		System.out.println("실행1");
		shopAttack += 1;
		mc.setAttack(shopAttack);
		upgradeCnt++;
		mc.setUpgradeCnt(upgradeCnt);
	}
	
	public void tikPlus() {
		System.out.println("실행2");
		tikGold += 2;
		mc.setGoldPlus(tikGold);
		upgradeCnt++;
		mc.setUpgradeCnt(upgradeCnt);
		System.out.println(upgradeCnt);
	}
	
	public void killPlus() {
		System.out.println("실행3");
		killGold+= 10;
		mc.setKillGold(killGold);
		upgradeCnt++;
		mc.setUpgradeCnt(upgradeCnt);
	}
	
	public void ATKUp() {
		
		if(goldron >= cost1) {
			goldron = goldron - cost1;
			goldCnt = goldCnt - cost1;
			mc.setGoldSum(goldron);
			mc.setGoldCnt(goldCnt);
			
			ATKPlus();
			say.setText("구매해주셔서 감사합니다.");
			
			Gold.setText("GOLD : "+goldron);
			ATKUpCost();
			upgradelevel1++;
			upgradeLevelATK.setText("Lv."+upgradelevel1);
		}else if(goldron < cost1){
			say.setText("돈이 부족한 뎁쇼?");
		}
	}
	public void tikGoldUp() {
		
		if(goldron >= cost2) {
			goldron = goldron - cost2;
			goldCnt = goldCnt - cost2;
			mc.setGoldSum(goldron);
			mc.setGoldCnt(goldCnt);
			
			tikPlus();
			say.setText("구매해주셔서 감사합니다.");
			
			Gold.setText("GOLD : "+goldron);
			tikGoldUpCost();
			upgradelevel2++;
			upgradeLevelTik.setText("Lv."+upgradelevel2);
		}else if(goldron < cost2){
			say.setText("돈이 부족한 뎁쇼?");
		}
	}
	public void killGoldUp() {
		
		if(goldron >= cost3) {
			goldron = goldron - cost3;
			goldCnt = goldCnt - cost3;
			mc.setGoldSum(goldron);
			mc.setGoldCnt(goldCnt);
			
			killPlus();
			say.setText("구매해주셔서 감사합니다.");
			
			Gold.setText("GOLD : "+goldron);
			killGoldUpCost();
			upgradelevel3++;
			upgradeLevelKill.setText("Lv."+upgradelevel3);
		}else if(goldron < cost3){
			say.setText("돈이 부족한 뎁쇼?");
		}
	}
	
	
	public void back() {
		
		MainApp.app.slideOut(getRoot());
		
	}
	
	public void setLabel(int goldron) {
		Gold.setText(Integer.toString(goldron));
	}
}
