package com.tka.WorkWave.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.WorkWave.entity.Country;
import com.tka.WorkWave.entity.Employe;
import com.tka.WorkWave.service.EmployeService;

@RestController
@RequestMapping("EmployeAPI")
public class EmployeController {
	@Autowired
	EmployeService service;

	@PostMapping("addEmploye")
	public ResponseEntity<String> addEmploye(@RequestBody Employe e) {
		String msg = service.addEmploye(e);
		return ResponseEntity.ok(msg);

	}
	
	@PutMapping("updateEmploye/{id}")
	public ResponseEntity<String> updateEmploye(@RequestBody Employe emp, @PathVariable int id) {
		String msg = service.updateEmploye(emp, id);
		return ResponseEntity.ok(msg);
	}
	
	@DeleteMapping("deleteEmploye/{id}")
	public ResponseEntity<String> deleteEmploye(@PathVariable int id) {
		String msg = service.deleteEmploye(id);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("getemployebyID/{id}")
	public Employe getemployebyID(@PathVariable int id) {
		Employe emp = service.getemployebyID(id);
		return emp;
	}
	
	@GetMapping("getallEmploye")
	public List<Employe> getallEmploye() {
		List<Employe> list = service.getallEmploye();
		return list;
	}
	
	@GetMapping("getemployebyName/{name}")
	public Employe getemployebyName(@PathVariable String name) {
		Employe emp = service.getemployebyName(name);
		return emp;
	}
	
	@PostMapping("Login")
	public ResponseEntity<Map> Login(@RequestBody Employe e) {
		Map map = service.Login(e);
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("maxminiSalary/{max}/{min}")
	public List<Employe> Salary(@PathVariable int max, @PathVariable int min) {
		List<Employe> list = service.maxminiSalary(max,min);
		return list;
	}
	
	@GetMapping("EmployeStatus/{status}")
	public List<Employe> EmployeStatus(@PathVariable String status) {
		List<Employe> list = service.EmployeStatus(status);
		return list;
	}
	
	@GetMapping("ChangeEmployeStatus/{id}")
	public String ChangeEmployeStatus(@PathVariable int id) {
		String msg = service.ChangeEmployeStatus(id);
		return msg;
	}
	
	@GetMapping("GetEmployesameCountry/{cid}")
	public  List<Employe> GetEmployesameCountry(@PathVariable int cid) {
		 List<Employe> emp = service.GetEmployesameCountry(cid);
		return emp;
	}
	
	

}
