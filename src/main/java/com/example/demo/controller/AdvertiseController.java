package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Advertise;
import com.example.demo.service.AdvertiseService;

import com051.crudoperation.Exception.InvalidEmpException;


@RestController
public class AdvertiseController {

	@Autowired 
	AdvertiseService advertiseService;
	
	@PostMapping(value="/advertise")
	public Advertise postAdd(@RequestBody Advertise advertise) {
		return advertiseService.postAdd(advertise);
	}
	
	@PutMapping(value="/advertise/{id}")
	public Advertise updateAdvertise(@PathVariable("id") int id,@RequestBody Advertise advertise) {
		return advertiseService.updateAdvertise(id,advertise);
	}
	
	@GetMapping(value="/advertise/{id}")
	public Advertise getAdvertisebyId(@PathVariable("id") int id) throws InvalidEmpException {
		return advertiseService.getAdvertisebyId(id);
	}
	
	@GetMapping(value="/advertise/search/{categoryName}")
	public List<Advertise> getSearchByName(@PathVariable("categoryName") String categoryName) {
		return advertiseService.getSearchByName(categoryName);
	}
	
	@DeleteMapping("user/advertise/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		advertiseService.deleteemp(id);
		return "Record " +id+ " deleted successfully";
	}
	
	@GetMapping(value="user/advertise/get")
	public List<Advertise> getAllAdvertise() throws InvalidEmpException {
		return advertiseService.getAllAdvertise();
	}
}
