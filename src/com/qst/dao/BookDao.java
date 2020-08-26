package com.qst.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.qst.bean.BookBean;
import com.qst.util.DBUtil;

public class BookDao {

	public ArrayList<BookBean> getAllBooksById(int register_id) {
		ArrayList<BookBean> allBook = new ArrayList<BookBean>();
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from bybook where register_id=?";
		try {
			c = DBUtil.getConnection();
			pst = c.prepareStatement(sql);
			pst.setInt(1, register_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				BookBean book = new BookBean();
				book.setId(rs.getInt("id"));
				book.setBookname(rs.getString("bookname"));
				book.setBooknumber(rs.getInt("booknumber"));
				book.setUnitprice(rs.getInt("unitprice"));
				book.setRegister_id(rs.getInt("register_id"));
				allBook.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.colse(null, pst, c);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allBook;
	}

	// 用户没有更改数据库中购买商品数量的权力，该权利应该为管理员拥有
	public boolean updateByBook(String bookname, int booknumber, int register_id) {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "update bybook set booknumber=? where bookname=? and register_id=?";
		try {
			c = DBUtil.getConnection();
			pst = c.prepareStatement(sql);
			pst.setInt(1, booknumber);
			pst.setString(2, bookname);
			pst.setInt(3, register_id);

			/*
			 * 查询数据使用pst.executeQuery(); 插入、修改数据使用pst.execute()
			 */
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.colse(null, pst, c);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean insertByBook(String bookname, int unitprice, int booknumber, int id) {
		PreparedStatement pst = null;
		Connection c = null;
		ResultSet rs = null;
		String sql = "INSERT INTO byBook(bookname,unitprice,booknumber,register_id) VALUES(?,?,?,?)";
		try {
			c = DBUtil.getConnection();
			pst = c.prepareStatement(sql);
			pst.setString(1, bookname);
			pst.setInt(2, unitprice);
			pst.setInt(3, booknumber);
			pst.setInt(4, id);
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.colse(null, pst, c);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteByBook(String bookname, int register_id) {
		PreparedStatement pst = null;
		Connection c = null;
		ResultSet rs = null;
		String sql = "delete from byBook where bookname = ? and register_id = ?";
		try {
			c = DBUtil.getConnection();
			pst = c.prepareStatement(sql);
			pst.setString(1, bookname);
			pst.setInt(2, register_id);
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.colse(null, pst, c);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
