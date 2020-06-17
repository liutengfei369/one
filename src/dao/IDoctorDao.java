package dao;

import java.util.List;

import beans.Doctor;

public interface IDoctorDao {

	//1.��ѯ���з���
	public List<Doctor> queryAll();
	//2.��������
	//public int add(String name,String sex,String birth,String hobby);
	public int add(Doctor d);
	//3.�޸Ĺ��ܵ�һ�����������һ��ҽ������Ϣ��
	public Doctor queryOne(int id);
	//4.�޸Ĺ��ܵڶ�������
	public int update(Doctor d);
	//5.ɾ������
	public int delete(String str);
}
