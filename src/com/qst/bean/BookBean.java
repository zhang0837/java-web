package com.qst.bean;

public class BookBean {//ÊÇ·ñÐè¸Ä
	int id;
	String bookname;
	int unitprice;
	int booknumber;
	int register_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}

	public int getBooknumber() {
		return booknumber;
	}

	public void setBooknumber(int booknumber) {
		this.booknumber = booknumber;
	}

	public int getRegister_id() {
		return register_id;
	}

	public void setRegister_id(int register_id) {
		this.register_id = register_id;
	}

	@Override
	public String toString() {
		return "BookBean [ bookname=" + bookname + ", unitprice=" + unitprice + ", booknumber="
				+ booknumber + "]";
	}
}