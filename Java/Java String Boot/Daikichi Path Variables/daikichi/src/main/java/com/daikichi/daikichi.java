package com.daikichi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
@RequestMapping("/daikichi")
public class daikichi {
	@RequestMapping("/travel/{city}")
	public String city(@PathVariable("city") String nameCity) {
		return "Congratulations! You will soon travel to "+nameCity;
	}
	
	@RequestMapping("/lotto/{number}")
	public String number(@PathVariable("number") int number) {
		if(number%2 == 1) {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
		else {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		
	}
}
