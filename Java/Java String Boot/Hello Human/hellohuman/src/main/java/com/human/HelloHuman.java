package com.human;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class HelloHuman {
	
	@RequestMapping("/")
    public String human(@RequestParam(value="name", required = false) String searchQuery,@RequestParam(value="last_name", required = false) String last,@RequestParam(value="times", required = false) Integer time) {
		if(searchQuery == null & last == null & time == null) {
			return "Hello Human";
		}
		else if(last == null & time == null) {
			return "Hello " + searchQuery;
		}
		else if(last == null & time != null){
			String x ="";
			for(int i=0; i<time; i++) {
				x += " Hello " + searchQuery;
			}
			return x;
		}
		else {
			return "Hello " + searchQuery+" "+last;
		}
	}

}
