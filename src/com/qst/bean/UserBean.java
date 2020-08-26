package com.qst.bean;

public class UserBean {
	private int id;
	private String username;
	private String password;
	private String age;
	private String sex;
	private String tooltip;
	private String answer;
	private String[] infor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String[] getInfor() {
		return infor;
	}

	public void setInfor(String[] infor) {
		this.infor = infor;
	}

	public String getChooseinfor() {
		String chooseinfor = "";
		for (int i = 0; i < infor.length; i++) {
			chooseinfor += infor[i];
			if (i < infor.length - 1) {
				chooseinfor += ",";
			}
		}
		return chooseinfor;
	}
}