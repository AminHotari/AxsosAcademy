package com.dojoninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojoninjas.models.Dojo;
import com.dojoninjas.models.Ninja;
import com.dojoninjas.repositories.DojoRepository;
import com.dojoninjas.repositories.NinjaRepository;

@Service
public class AllServices {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	
	public AllServices(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	
	public Dojo creatDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public Ninja creatNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public Dojo findDojo(Long id) {
		return this.dojoRepository.findById(id).orElse(null);
	}
	
	public Ninja findNinja(Long id) {
		return this.ninjaRepository.findById(id).orElse(null);
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}

}
