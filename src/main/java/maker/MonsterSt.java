package maker;

import javafx.scene.image.Image;

public class MonsterSt {
	private String MonsterName;
	private String EngName;
	private Image MonsterFace;
	
	public MonsterSt(String monName,String Eng, Image MonFace) {
		this.MonsterFace = MonFace;
		this.MonsterName = monName;
		this.EngName = Eng;
	}
	
	public String getMonsterName() {
		return MonsterName;
	}

	public void setMonsterName(String monsterName) {
		MonsterName = monsterName;
	}

	public Image getMonsterFace() {
		return MonsterFace;
	}

	public void setMonsterFace(Image monsterFace) {
		MonsterFace = monsterFace;
	}

	public String getEngName() {
		return EngName;
	}

	public void setEngName(String engName) {
		EngName = engName;
	}

}
