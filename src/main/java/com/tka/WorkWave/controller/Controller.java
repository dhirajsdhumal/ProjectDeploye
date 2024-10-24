package com.tka.WorkWave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.WorkWave.entity.Country;
import com.tka.WorkWave.service.MainService;

@RestController
@RequestMapping("CountryAPI")
public class Controller {
	@Autowired
	MainService service;

	@PostMapping("addrecord")
	public ResponseEntity<String> addrecord(@RequestBody Country c) {
		String msg = service.addrecord(c);
		return ResponseEntity.ok(msg);

	}

	@PutMapping("updateCountry/{id}")
	public ResponseEntity<String> updateCountry(@RequestBody Country c, @PathVariable int id) {
		String msg = service.updateCountry(c, id);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("deleteCountry/{id}")
	public ResponseEntity<String> deleteCountry(@PathVariable int id) {
		String msg = service.deleteCountry(id);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("getallCountry")
	public List<Country> getallCountry() {
		List<Country> list = service.getallCountry();
		return list;
	}

	@GetMapping("getallParticularCountrybyID/{id}")
	public Country getallParticularCountrybyID(@PathVariable int id) {
		Country c = service.getallParticularCountrybyID(id);
		return c;
	}

	@GetMapping("getallParticularCountrybyName/{name}")
	public Country getallParticularCountrybyName(@PathVariable String name) {
		Country c = service.getallParticularCountrybyName(name);
		return c;
	}

}
