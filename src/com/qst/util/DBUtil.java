package com.qst.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class DBUtil {
	// DBUtil类的无参构造方法
	private DBUtil() {
	}

	// 1.静态方法:需要在项目启动的时候就初始化,在不创建对象的情况下,这种代码是被动执行的(静态方法在类加载的时候就已经加载,可以用类名直接调用)
	// 使用类的静态方法时,注意:
	// a.在静态方法里只能直接调用同类中的其他静态成员(包括变量和方法),而不能直接访问类中的非静态成员(这是因为,对于非静态的方法和变量,需要先创建类的实例对象后才能使用,而静态方法在使用前不用创建任何对象)
	// b.静态方法不能以任何方式引用this和super关键字,应为静态方法在使用前不用创建任何实例对象,当静态方法调用时候,this所引用的对象根本没有产生
	// c.静态变量是属于整个类的变量,而不是属于某个对象的,注意不能把任何方法内的变量声明成静态
	// 2.静态代码块;加载类时优先加载,且只有首次调用时才会加载
	// 有些代码必须在项目启动时侯执行,这种代码是主动执行的(当类被载入时,静态代码块被执行,且只被执行一次,静态代码块常用过来执行类属性的初始化)
	// 3.区别:两者的区别就是:静态代码块是自动执行的,静态方法是被调用时候才被执行
	// URL指向要访问的数据库名test
	static String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	// MySQL配置时的用户名
	static String username = "root";
	// MySQL配置时的密码
	static String password = "1234";
	static {
		try {
			// 加载驱动程序
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			throw new RuntimeErrorException(null, e + "数据库链接失败");
		}
	}
	// 定义私有静态Connection常量con;
	private static Connection con;

	// 创建getConnect()方法;返回Connection类型的参数
	public static Connection getConnection() throws SQLException {
		// 调用getConnection()方法链接MYDQL数据库
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("数据库链接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	// 关闭数据库连接
	public static void colse(ResultSet rs, PreparedStatement pstmt, Connection conn) throws SQLException {
		if (con != null && !con.isClosed()) {
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pstmt != null && !pstmt.isClosed()) {
			try {
				pstmt.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null && !conn.isClosed()) {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
