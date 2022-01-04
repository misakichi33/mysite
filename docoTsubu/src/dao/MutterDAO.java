package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;


public class MutterDAO {
	//データベース接続に使用する情報

	private final String JDBC_URL="jdbc:mysql://localhost:3306/docoTsubu?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER= "root";
	private final String DB_PASS= "";


	public List<Mutter>findAll(){
		List<Mutter>mutterList= new ArrayList<>();

		//データベースへ接続
		try {
			Class.forName("com.mysql.jdbc.Driver");//←これを本来処理したい
		} catch (ClassNotFoundException e1) {//←このクラスが実行できなかったとき…
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();//それをコンソールに出力
		}


		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			//SELECT文を準備
			String sql= "SELECT ID, NAME, TEXT FROM MUTTER ORDER BY ID DESC";
			PreparedStatement pStmt= conn.prepareStatement(sql);

			//SELECTを実行
			ResultSet rs= pStmt.executeQuery();

			//SERECT文の結果をArrayListに格納
			while(rs.next()) {
				int id= rs.getInt("ID");
				String userName= rs.getString("NAME");
				String text= rs.getString("TEXT");

			//ArrayListインスタンスに追加
				Mutter mutter= new Mutter(id, userName, text);
				mutterList.add(mutter);

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}
	public boolean create(Mutter mutter) {
		//データベースへ接続
				try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

					//INSERT文を準備（idは自動連番のため指定不要）
					String sql= "INSERT INTO MUTTER(NAME, TEXT) VALUES(?, ?)";
					PreparedStatement pStmt= conn.prepareStatement(sql);

					//INSERT文中の？に使用する値を設定しSQLを完成
					pStmt.setString(1, mutter.getUserName());
					pStmt.setString(2, mutter.getText());

					//INSERT文実行（resultには追加された行数が代入される）
					int result = pStmt.executeUpdate();
					if(result!=1) {
						return false;
					}

				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
					return false;
				}
				return true;
			}
}
