package dao;

import java.util.List;

import beans.Doctor;

public interface IDoctorDao {

	//1.查询所有方法
	public List<Doctor> queryAll();
	//2.新增方法
	//public int add(String name,String sex,String birth,String hobby);
	public int add(Doctor d);
	//3.修改功能第一步方法（查出一个医生的信息）
	public Doctor queryOne(int id);
	//4.修改功能第二步方法
	public int update(Doctor d);
	//5.删除方法
	public int delete(String str);
}
