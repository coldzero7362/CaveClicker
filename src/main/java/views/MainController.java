package views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import domain.UserVO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.MainApp;
import maker.MonsterSt;

public class MainController extends MasterController {

	@FXML
	private Button attackBtn;
	@FXML
	private Button Staus;
	@FXML
	private Button shop;
	@FXML
	private Button Ranking;
	@FXML
	private Button Maker;
	@FXML
	private Label HP;
	@FXML
	private Label mosterName;
	@FXML
	private Label stage;
	@FXML
	private Label gold;
	@FXML
	private ImageView monsterFace;
	@FXML
	private Label loginInfo;
	
	private ObservableList<MonsterSt> items;
	
	private int goldSum;
	private int goldCnt;
	private int goldPlus;
	private int goldPlus2;
	
	private int monsterHP = 0;
	private int kill = 0;
	private int attack = 0;
	private int plus;
	private int Plus2;
	private int stageNum;
	private int killGold;
	private int attckCnt;
	private int upgradeCnt;
	private String monName;
	
	private int random;

	private Map<String , Image> resourcesMap = new HashMap<>();
	HashSet<Integer> randomMonNum = new HashSet<>();

	
	
	private int plusMosterHP = 50;

	private int plusMonserHPplus = 100;

	

	private UserVO user;

	ArrayList<String> monster = new ArrayList<>();
	ArrayList<String> monsterPoto = new ArrayList<>();
	
	@FXML
	public void initialize() {
//		File file = new File(getClass().getResource("resources/Index.txt").getFile());
//      

		try {
//			FileInputStream fis = new FileInputStream(file);
			InputStream is =this.getClass().getResourceAsStream("/resources/Index.txt");
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				String cmdArr[] = line.split("#");
				if (cmdArr.length < 1) {
					System.out.println(line);//
				}				
//				Image img = new Image(getClass().getResource("/mob/" + cmdArr[0] + ".png").toString());
//				
				monsterPoto.add(cmdArr[0]);
				monster.add(cmdArr[1]);     
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 못받아옴");
		}    
		goldCnt = 0;
		goldSum = 0;
		goldPlus = 2;
		monsterHP = 10;
		plus = stageNum * Plus2;
		attack = 1;
		monName = "허공에 휘두르기";
		stageNum = 0;
		HP.setText("10");
		mosterName.setText(monName);
		stage.setText("STAGE - " + stageNum);
		upgradeCnt = 0;
		attckCnt = 0;
		goldPlus2 = goldPlus;
		
	}
	
	@Override
	public void init() {
		System.out.println("이게 안되나?");
	}
	
	public void Random() {
		random = (int)(Math.random()*44);
		System.out.println(random);
	}
	
	
	public void kill() {
		
		if( stageNum <= 0) {
			killGold = 0;
			stageNum++;
		}else if(stageNum > 0) {
			killGold += monsterHP / 2;
		goldSum += killGold;
		goldCnt = goldSum;
		stageNum++;
		kill++;
		}
		
	}

	public int i = 0;
	public int cnt;
	public void dieMonster() {
		Random();
		i = random;
		
		monsterHP += plusMosterHP;
		// 10, 40, 110, 220, 370
		plusMosterHP += plusMonserHPplus;
		kill();

		stage.setText("STAGE - " + stageNum);
		//
		
		mosterName.setText(monster.get(i));
		Image img = new Image(getClass().getResource("/mob/"+monsterPoto.get(i) + ".gif").toString());
		monsterFace.setImage(img);
		cnt++;
		
		if(cnt%44 == 0) {
			i = 1;
		}
	}

	public void shopPage() {  
		MainApp.app.loadPane("shop");
		System.out.println("야발");
	}

	public void questPage() {
		MainApp.app.loadPane("quest");
	}
	
	
	public void setLoginInfo(UserVO user) {
		this.user = user;
		loginInfo.setText(user.getName());
	}

	public void logout() {
		MainApp.app.loadPane("login");
		stageNum = 0;
		i=0;
		goldCnt = 0;
		goldSum = 0;
		goldPlus = 50;
		monsterHP = 9;
		plus = stageNum * Plus2;
		attack = 1;
		monName = "허공에 휘두르기";
		stageNum = 0;
		HP.setText("9");
		mosterName.setText(monName);
		stage.setText("STAGE - " + stageNum);
		upgradeCnt = 0;
		attckCnt = 0;
		
	}
	
	
	public void Attack() {
		System.out.println(monsterHP);
		if( stageNum <= 0) {
			HP.setText(Integer.toString(monsterHP));
			
			goldSum = goldSum + 0;
			attckCnt = 0;
			
		}else if(stageNum > 0) {
			System.out.println("ha");
		}
		if (monsterHP < 1) {
			dieMonster();
		}
		goldSum = goldSum + goldPlus;
		goldCnt = goldCnt + goldPlus;
		
//		System.out.println(goldsum);
		gold.setText("GOLD : "+goldSum);
//		System.exit(0);
		HP.setText(Integer.toString(monsterHP));
		monsterHP = monsterHP - attack;
		attckCnt++;

	}
	
		public void keyHandler(KeyEvent e) {
		if(e.getCode() == KeyCode.SPACE) {
			Attack();
		}
		Random();
	}
		
	public int getGoldSum() {
		return goldSum;
	}
	
	public void setGoldSum(int value) {
		this.goldSum = value;
	}
	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int value) {
		this.attack = value;
	}

	public int getGoldPlus() {
		return goldPlus;
	}

	public void setGoldPlus(int value) {
		this.goldPlus = value;
	}
	public int getKillGold() {
		return killGold;
	}

	public void setKillGold(int value) {
		this.killGold = value;
	}

	public int getStageNum() {
		return stageNum;
	}

	public void setStageNum(int value) {
		this.stageNum = value;
	}

	public int getAttckCnt() {
		return attckCnt;
	}

	public void setAttckCnt(int value) {
		this.attckCnt = value;
	}

	public int getUpgradeCnt() {
		return upgradeCnt;
	}

	public void setUpgradeCnt(int value) {
		this.upgradeCnt = value;
	}

	public int getGoldCnt() {
		return goldCnt;
	}

	public void setGoldCnt(int value) {
		this.goldCnt = value;
	}


}