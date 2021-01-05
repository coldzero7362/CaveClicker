package views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.MainApp;

public class QuestController extends MasterController {
	@FXML
	private Label quest1;

	@FXML
	private Label quest2;

	@FXML
	private Label quest3;

	@FXML
	private Label quest4;
	
	@FXML
	private Label result1;
	@FXML
	private Label result2;
	@FXML
	private Label result3;
	@FXML
	private Label result4;
	
	@FXML
	private Button btn1;

	@FXML
	private Button btn2;

	@FXML
	private Button btn3;

	@FXML
	private Button btn4;

	//목표 저장변수
	private int goal1;
	private int goal2;
	private int goal3;
	private int goal4;
	private int coin;
	
	//카운트 저장 변수
	private int upCnt;
	private int stageCnt;
	private int atkCnt;
	private int gold;
	private int goldCnt;
	
	//목표 증가 변수
	private int goalPlus1;
	private int goalPlus2;
	private int goalPlus3;
	private int goalPlus4;
	
	//보상 변수
	private int goldUp1;
	private int goldUp2;
	private int goldUp3;
	private int goldUp4;
	
	private int ATK;
	
	int mode1 = 0;
	int mode2 = 0;
	int mode3 = 0;
	int mode4 = 0;
	
	MainController mc;

	@FXML
	public void initialize() {
		mc = (MainController) MainApp.app.getController("main");
		gold = mc.getGoldSum();
		upCnt = mc.getUpgradeCnt();
		atkCnt = mc.getAttckCnt();
		stageCnt = mc.getStageNum();
		ATK = mc.getAttack();
		goldCnt = mc.getGoldCnt();
		
		goal1 = 5;
		goal2 = 5;
		goal3 = 200;
		goal4 = 500;
		
		goldUp1 = 200;
		goldUp2 = 70;
		goldUp3 = 60;
		goldUp4 = 250;
		
		result1.setText(" ");
		result2.setText(" ");
		result3.setText(" ");
		result4.setText(" ");
		
		int mode1 = 0;
		int mode2 = 0;
		int mode3 = 0;
		int mode4 = 0;
		
		quest1.setText("스테이지 "+ goal1 +"에 도착하세요" + "[0/" + goal1+"]");
		quest2.setText("강화를 "+ goal2 + "번 하세요"+ "[0/" + goal2+"]");
		quest3.setText("공격을 " + goal3 + "번 하세요"+ "[0/" + goal3+"]");
		quest4.setText(goal4 + "코인을 모으세요"+ "[0/" + goal4+"]");
	}

	@Override
	public void init() {
		gold = mc.getGoldSum();
		upCnt = mc.getUpgradeCnt();
		atkCnt = mc.getAttckCnt();
		stageCnt = mc.getStageNum();
		goldCnt = mc.getGoldCnt();
		
		result1.setText(" ");
		result2.setText(" ");
		result3.setText(" ");
		result4.setText(" ");
		
		quest1.setText("스테이지 "+ goal1 +"에 도착하세요. "+"["+ stageCnt +"/"+ goal1+"]"+"\n보상 : "+goldUp1);
		quest2.setText("강화를 "+ goal2 + "번 하세요. "+"["+ upCnt +"/"+ goal2+"]"+"\n보상 : "+goldUp2);
		quest3.setText("공격을 " + goal3 + "번 하세요. "+"["+ atkCnt +"/"+ goal3+"]"+"\n보상 : "+goldUp3);
		quest4.setText(goal4 + "코인을 모으세요. "+"["+ goldCnt +"/"+ goal4+"]"+"\n보상 : "+goldUp4);
	}
	
	
	
	public void StageGoalPlus() {
		goalPlus1 = goal1 / 2;
		goal1 += goalPlus1; 
		quest1.setText("스테이지 "+ goal1 + "에 도착하세요. "+"["+ stageCnt +"/"+ goal1+"]"+"\n보상 : "+goldUp1);	
		
		goldUp1+=500;
	}
	public void upgradeGoalPlus() {
		goalPlus2 = goal2 / 2;
		goal2 += goalPlus2; 
		quest2.setText("강화를 "+ goal2 + "번하세요. "+"["+ upCnt +"/"+ goal2+"]"+"\n보상 : "+goldUp2);
		goldUp2+=250;
	}
	public void ATKGoalPlus() {
		goalPlus3 = goal3 / 2;
		goal3 += goalPlus3; 
		quest3.setText("공격을 "+ goal3 + "번 하세요. "+"["+ atkCnt +"/"+ goal3+"]"+"\n보상 : "+goldUp3);
		goldUp3+=goldUp3/2;
	}
	public void CoinGoalPlus() {
		goalPlus4 = goal4 * 2/3;
		goal4 += goalPlus4; 
		quest4.setText( goal4 + "코인을 모으세요. "+"["+ goldCnt +"/"+ goal4+"]"+"\n보상 : "+goldUp4);
		goldUp4+=250;
	}
	
	

	public void quest1() {
		
		if(stageCnt >= goal1) {
			gold += goldUp1;
			
			mc.setGoldSum(gold);
			result1.setText("퀘스트 수령!" );
			
			StageGoalPlus();
			
		}else if(stageCnt < goal1) {
			quest1.setText("조건이 만족되지 않았습니다.");
			
			
		}

	}
	

	public void quest2() {
		if(upCnt >= goal2) {
			gold += goldUp2;
			mc.setGoldSum(gold);
			result2.setText("퀘스트 수령!" );
			upgradeGoalPlus();
			System.out.println("퀘스트 수령!");
		}else if(upCnt < goal2) {
			quest2.setText("조건이 만족되지 않았습니다.");
			
		}
		
	}

	public void quest3() {
		if(atkCnt >= goal3) {
			gold += goldUp3;
			mc.setGoldSum(gold);
			result3.setText("퀘스트 수령!");
			ATKGoalPlus();
			System.out.println("퀘스트 수령!");
		}else if(atkCnt < goal3) {
			quest3.setText("조건이 만족되지 않았습니다.");
			
		}

	}

	public void quest4() {
		if(goldCnt >= goal4) {
			gold += goldUp4;
			mc.setGoldSum(gold);
			CoinGoalPlus();
			System.out.println("퀘스트 수령!");
			result4.setText("퀘스트 수령!");
		}else if(goldCnt < goal4) {
			quest4.setText("조건이 만족되지 않았습니다.");
			
		}

	}

	public void back() {
		MainApp.app.slideOut(getRoot());
		mc.setGoldSum(gold);
	}
}
