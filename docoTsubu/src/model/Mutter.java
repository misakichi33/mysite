package model;

import java.io.Serializable;

public class Mutter implements Serializable {

	private int id; //id
	private String userName;//ユーザー名
	private String text;//つぶやき


	public Mutter(String userName, String text) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.userName= userName;
		this.text= text;
	}
	public Mutter(int id, String userName, String text) {
		this.id= id;
		this.userName= userName;
		this.text= text;		// TODO 自動生成されたコンストラクター・スタブ
	}
	public int getId() {return id;}
	public String getUserName() {return userName;}
	public String getText() {return text;}

}
