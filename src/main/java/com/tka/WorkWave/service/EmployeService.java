package com.tka.WorkWave.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.WorkWave.doa.EmployeDoa;
import com.tka.WorkWave.entity.Country;
import com.tka.WorkWave.entity.Employe;

@Service
public class EmployeService {

	@Autowired
	EmployeDoa dao;

	public String addEmploye(Employe e) {
		String msg = dao.addEmploye(e);
		if (Objects.isNull(e)) {
			msg = "Employe is not added";
		}
		return msg;
	}

	public String updateEmploye(Employe emp, int id) {
		String msg = dao.updateEmploye(emp, id);
		if (Objects.isNull(emp)) {
			msg = "Employe is not updated";
		}
		return msg;
	}

	public String deleteEmploye(int id) {
		String msg = dao.deleteEmploye(id);
		if (Objects.isNull(id)) {
			msg = "Employe is not Deleted";
		}
		return msg;
	}

	public Employe getemployebyID(int id) {
		Employe emp = dao.getemployebyID(id);

		return emp;
	}

	public List<Employe> getallEmploye() {
		List<Employe> emp = dao.getallEmploye();
		return emp;
	}

	public Employe getemployebyName(String name) {
		Employe emp = dao.getemployebyName(name);

		return emp;
	}

	public Map Login(Employe e) {
		Employe emp= dao.Login(e);
		String msg =null;
		Map map = new HashMap();
		if(Objects.isNull(emp))
		{
			map.put("msg", "Invalid user");
			map.put("user", emp);
		}
		else {
			map.put("msg", "Valid user");
			map.put("user", emp);
		}

		return map;
	}

	public List<Employe> maxminiSalary(int max, int min) {
		List<Employe>list=dao.maxminiSalary(max,min);
		return list;
	}

	public List<Employe> EmployeStatus(String status) {
		List<Employe>list=dao.EmployeStatus(status);
		return list;
	}

	public String ChangeEmployeStatus(int id) {
		String msg = dao.ChangeEmployeStatus(id);
		return msg;
	}

	public  List<Employe> GetEmployesameCountry(int country) {
		 List<Employe> emp =dao.GetEmployesameCountry(country);
		 return emp;
	}

}
