package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import util.JdbcUtil;
import beans.Doctor;

//该类的方法中，只写jdbc相关的代码
public class DoctorDaoImpl implements IDoctorDao{
	//技巧：对于有返回值的方法：
	//第一行用返回值类型声明一个变量
	//中间代码给这个变量重新赋值
	//最后一行return 这个变量
	public List<Doctor> queryAll() {
		List<Doctor> list = new ArrayList<Doctor>();
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql = "select id,name,sex,birth,hobby from t_doctor";
			PreparedStatement pstm = conn.prepareStatement(sql);
			//执行
			ResultSet rs = pstm.executeQuery();
			//遍历结果集
			while(rs.next()){
				//
				Doctor d = new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int add(Doctor d) {
		int i = 0;
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql = "insert into t_doctor values(0, ?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			//给问号赋值
			pstm.setString(1, d.getName());
			pstm.setString(2, d.getSex());
			pstm.setString(3, d.getBirth());
			pstm.setString(4, d.getHobby());
			//执行
			i = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public Doctor queryOne(int id) {
		Doctor d = null;
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql = "select id,name,sex,birth,hobby from t_doctor where id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			//执行
			ResultSet rs = pstm.executeQuery();
			//遍历结果集
			if(rs.next()){
				//
				d = new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return d;
	}
	public int update(Doctor d) {
		int i = 0;
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql = "update t_doctor set name=?,sex=?,birth=?,hobby=? where id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			//给问号赋值
			pstm.setString(1, d.getName());
			pstm.setString(2, d.getSex());
			pstm.setString(3, d.getBirth());
			pstm.setString(4, d.getHobby());
			pstm.setInt(5, d.getId());
			//执行
			i = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public int delete(String str) {
		int i = 0;
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql = "delete from t_doctor where id in (" + str + ")";
			PreparedStatement pstm = conn.prepareStatement(sql);
			//执行
			i = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
