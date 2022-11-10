package com.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.languages.models.Language;
import com.languages.repositories.LanguagesRepository;

@Service
public class LanguagesService {
	
	private final LanguagesRepository languagesRepository;

	public LanguagesService(LanguagesRepository languagesRepository) {
		this.languagesRepository = languagesRepository;
	}
	
	public Language creatLanguage(Language language) {
		return languagesRepository.save(language);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languagesRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
	}
	public List<Language> allLanguage(){
		return languagesRepository.findAll();
	}
	
	public Language updateLanguage(Language language) {
		Optional <Language>optionalLanguage=languagesRepository.findById(language.getId());
		if(optionalLanguage.isPresent()) {
			Language a=optionalLanguage.get();
			a=language;
			return languagesRepository.save(a);
			}
		else {
			return null;
		}
			
	}
	
	public void deleteLanguage(Long id) {
		Optional<Language> optionalLanguage = languagesRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			languagesRepository.deleteById(id);
		}
	}
	
	
}
