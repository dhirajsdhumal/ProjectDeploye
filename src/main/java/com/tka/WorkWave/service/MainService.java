package com.tka.WorkWave.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.WorkWave.doa.MainDao;
import com.tka.WorkWave.entity.Country;

@Service
public class MainService {
	@Autowired
	MainDao dao;

	public String addrecord(Country c) {
		String msg = dao.addrecord(c);
		if (Objects.isNull(c)) {
			msg = "Country is not added";
		}
		return msg;
	}

	public String updateCountry(Country c, int id) {
		String msg = dao.updateCountry(c, id);
		if (Objects.isNull(c)) {
			msg = "Country is not updated";
		}
		return msg;
	}

	public String deleteCountry(int id) {
		String msg = dao.deleteCountry(id);
		if (Objects.isNull(id)) {
			msg = "Country is not Deleted";
		}
		return msg;
	}

	public List<Country> getallCountry() {
		List<Country> list = dao.getallCountry();
		return list;
	}

	public Country getallParticularCountrybyID(int id) {
		Country c = dao.getallParticularCountrybyID(id);
		return c;
	}

	public Country getallParticularCountrybyName(String name) {
		Country c = dao.getallParticularCountrybyName(name);
		return c;
	}

}
