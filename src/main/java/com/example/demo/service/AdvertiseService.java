package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AdvertiseRepository;
import com.example.demo.model.Advertise;

import com051.crudoperation.Exception.InvalidEmpException;


@Service
public class AdvertiseService {

	@Autowired
	AdvertiseRepository advertiseRepository;

	public Advertise postAdd(Advertise advertise) {
		String catName = advertiseRepository.findCustomerById(advertise.getCategory());
		String catStatus = advertiseRepository.findCustomerStatusById(advertise.getCategory());
		advertise.setCategoryName(catName);
		advertise.setStatus(catStatus);
		return advertiseRepository.save(advertise);
	}

	public Advertise updateAdvertise(int id, Advertise advertise) {
		Optional<Advertise> ad = advertiseRepository.findById(id);
		Advertise newEntity = ad.get();
		if(ad.isPresent()) {
			newEntity.setTitle(advertise.getTitle());
			newEntity.setCategory(advertise.getCategory());
			String catName = advertiseRepository.findCustomerById(newEntity.getCategory());
			String catStatus = advertiseRepository.findCustomerStatusById(newEntity.getCategory());
			newEntity.setStatus(catStatus);
			newEntity.setPrice(advertise.getPrice());
			newEntity.setCategoryName(catName);
			newEntity.setDescription(advertise.getDescription());
			newEntity.setUsername(advertise.getUsername());
			advertiseRepository.save(newEntity);	
		}
		return newEntity;
	}

	public Advertise getAdvertisebyId(int id) throws InvalidEmpException{
		Optional<Advertise> ads =  advertiseRepository.findById(id);
		if(ads.isPresent()) {
			return ads.get();
		}else {
			throw new InvalidEmpException("No employee record exist for given id");
		}
	}

	public List<Advertise> getSearchByName(String categoryName) {
		return advertiseRepository.getSearchByName(categoryName);
	}

	public void deleteemp(int id) {
		advertiseRepository.deleteById(id);	
	}

	public List<Advertise> getAllAdvertise() {
		return advertiseRepository.findAll();
	}

}
