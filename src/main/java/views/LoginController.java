package views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.UserVO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.MainApp;
import util.JDBCUtil;
import util.Util;

//import 구문 생략

public class LoginController extends MasterController {
	@FXML
	private TextField txtId;
	@FXML
	private PasswordField passField;

	@FXML
	private AnchorPane loginPage;

	private int gold;
	private int upCnt;
	private int atkCnt;
	private int stageCnt;
	private int goldCnt;

	MainController mc;

	public void registerPage() {
		MainApp.app.loadPane("register");
	}

	@FXML
	public void initialize() {
		mc = (MainController) MainApp.app.getController("main");
		gold = mc.getGoldSum();
		upCnt = mc.getUpgradeCnt();
		atkCnt = mc.getAttckCnt();
		stageCnt = mc.getStageNum();
		goldCnt = mc.getGoldCnt();

	}

	@Override
	public void init() {

	}

	public void loginProcess() {
		String id = txtId.getText();
		String pass = passField.getText();

		if (id.isEmpty() || pass.isEmpty()) {
			Util.showAlert("에러", "아이디나 비밀번호는 비어있을 수 없습니다", AlertType.ERROR);
			return;
		}

		UserVO user = checkLogin(id, pass);
		if (user != null) {
			MainApp.app.setLoginInfo(user);
			txtId.setText("");
			passField.setText("");
			MainApp.app.slideOut(loginPage);
		} else {
			Util.showAlert("에러", "존재하지 않는 아이디이거나 틀린 비밀번호입니다.", AlertType.ERROR);
			return;
		}
	}

	private UserVO checkLogin(String id, String pw) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM diary_users WHERE id = ? AND pass = PASSWORD(?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setInfo(rs.getString("info"));
				return user;
			}
			return null;
		} catch (Exception e) {
			Util.showAlert("에러", "데이터베이스 처리중 오류 발생, 인터넷 연결을 확인하세요", AlertType.ERROR);
			return null; // 에러 발생시 false
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(con);
		}
	}

	
}