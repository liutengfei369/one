package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import util.JdbcUtil;
import beans.Doctor;

//����ķ����У�ֻдjdbc��صĴ���
public class DoctorDaoImpl implements IDoctorDao{
	//���ɣ������з���ֵ�ķ�����
	//��һ���÷���ֵ��������һ������
	//�м���������������¸�ֵ
	//���һ��return �������
	public List<Doctor> queryAll() {
		List<Doctor> list = new ArrayList<Doctor>();
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql = "select id,name,sex,birth,hobby from t_doctor";
			PreparedStatement pstm = conn.prepareStatement(sql);
			//ִ��
			ResultSet rs = pstm.executeQuery();
			//���������
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
			//���ʺŸ�ֵ
			pstm.setString(1, d.getName());
			pstm.setString(2, d.getSex());
			pstm.setString(3, d.getBirth());
			pstm.setString(4, d.getHobby());
			//ִ��
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
			//ִ��
			ResultSet rs = pstm.executeQuery();
			//���������
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
			//���ʺŸ�ֵ
			pstm.setString(1, d.getName());
			pstm.setString(2, d.getSex());
			pstm.setString(3, d.getBirth());
			pstm.setString(4, d.getHobby());
			pstm.setInt(5, d.getId());
			//ִ��
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
			//ִ��
			i = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
