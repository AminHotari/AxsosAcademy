package com.time;





import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class displayDate {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
		model.addAttribute("time",format.format(time));
		return "time.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("EEEE,'the' dd 'of' MMMM, yyyy");	
		model.addAttribute("date",format.format(date));
		return "date.jsp";
	}
	

}
