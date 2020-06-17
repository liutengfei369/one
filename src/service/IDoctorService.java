package service;
import java.util.*;
import beans.Doctor;

public interface IDoctorService {

	//1.查询所有的业务
	public List<Doctor> queryAllServ();
	//2.新增的业务
	public int addServ(Doctor d);
	//3.修改第一步的业务
	public Doctor queryOneServ(int id);
	//4.修改第二步的业务
	public int updateServ(Doctor d);
	//5.删除的业务
	public int deleteServ(String str);
}
