package com.qst.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.qst.bean.UserBean;
import com.qst.util.DBUtil;

public class UserDao {
	public int getIdByUsername(String username) {

		int id = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT id FROM register where username = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs.first()) {
				id = rs.getInt("id");
				// 这里一定不能提前return出去id
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				DBUtil.colse(rs, pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}

	public boolean login(String username, String password) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "SELECT * FROM register where username = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs.first()) {
				String passInDb = rs.getString("password");
				if (passInDb.equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtil.colse(rs, pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean regist(UserBean user) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO register(username,password,age,sex,tooltip,answer,chooseinfor) VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getAge());
			pstmt.setString(4, user.getSex());
			pstmt.setString(5, user.getTooltip());
			pstmt.setString(6, user.getAnswer());
			pstmt.setString(7, user.getChooseinfor());
			pstmt.execute();
			//数据库一定不能过早关闭
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtil.colse(rs, pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
