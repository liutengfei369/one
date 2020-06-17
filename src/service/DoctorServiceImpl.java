package service;

import java.util.List;

import dao.DoctorDaoImpl;
import dao.IDoctorDao;
import beans.Doctor;

public class DoctorServiceImpl implements IDoctorService{
	//
	IDoctorDao dao = new DoctorDaoImpl();
	
	public List<Doctor> queryAllServ() {
		return dao.queryAll();
	}

	public int addServ(Doctor d) {
		return dao.add(d);
	}

	@Override
	public Doctor queryOneServ(int id) {
		return dao.queryOne(id);
	}

	@Override
	public int updateServ(Doctor d) {
		return dao.update(d);
	}

	@Override
	public int deleteServ(String str) {
		return dao.delete(str);
	}

}
