package service;
import java.util.*;
import beans.Doctor;

public interface IDoctorService {

	//1.��ѯ���е�ҵ��
	public List<Doctor> queryAllServ();
	//2.������ҵ��
	public int addServ(Doctor d);
	//3.�޸ĵ�һ����ҵ��
	public Doctor queryOneServ(int id);
	//4.�޸ĵڶ�����ҵ��
	public int updateServ(Doctor d);
	//5.ɾ����ҵ��
	public int deleteServ(String str);
}
