package cn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MySQL {
	public static void main(String[] args) {
		 MySQL mySQL = new MySQL();
		 	//新增
	       // mySQL.insertData();
	        
	        mySQL.selectData();
	}
	public void insertData() {
		try {
			String sql="insert into xcb values(?,?,?,?,?)";
			//第一步：加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//第二步：创建连接对象
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/yangpeng","root","123456");
			//第三步：执行SQL语句
			PreparedStatement ps=con.prepareStatement(sql);
			//第四步：绑定参数
			ps.setInt(1, 6);
			ps.setString(2, "攸县");
			ps.setObject(3, "邵阳");
			ps.setString(4, "2023-12-30");
			ps.setString(5, "2023-12-31");

			//执行sql语句
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "驱动加载失败！");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "连接或操作失败！");
			ex.printStackTrace();
		}
	}
	public void selectData() {
		String sql = "SELECT * FROM xcb WHERE cfTime >= DATE_SUB(NOW(), INTERVAL 1 MONTH)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yangpeng", "root", "123456");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Object[] data = new Object[5];
				data[0] = rs.getString("xcid");
				data[1] = rs.getString("cfd");
				data[2] = rs.getString("mdd");
				data[3] = rs.getString("cfTime");
				data[4] = rs.getString("ddTime");
				System.out.println("行程id"+data[0]);
				System.out.println("出发地"+data[1]);
				System.out.println("目的地"+data[2]);
				System.out.println("出发时间"+data[3]);
				System.out.println("到达时间"+data[4]);
			}
			
			rs.close();
			ps.close();
			con.close();
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "驱动加载失败！");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "连接或操作失败！");
			ex.printStackTrace();
		}
	}
}
