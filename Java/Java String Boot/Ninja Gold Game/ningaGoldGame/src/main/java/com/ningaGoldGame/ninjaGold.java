package com.ningaGoldGame;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ninjaGold {	
	@GetMapping("/Gold")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activites") == null) {
			session.setAttribute("activites", new ArrayList<Object>());
		}
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String process(HttpSession session, @RequestParam (value="find") String find1) {
		if(find1.equals("farm")) {
			Random random = new Random();
			Integer randomFarm = random.nextInt(10,21);
			session.setAttribute("randomFarm", randomFarm);
			Integer randomGold = (Integer) session.getAttribute("gold");
			
			Integer allGold = randomGold + randomFarm;
			session.setAttribute("gold", allGold);
			
			Date farmDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("'(' 'at' dd 'of' MMMM yyyy hh:mm:ss a ')' ");
			String time = dateFormat.format(farmDate);
			session.setAttribute("farmDate", time);
			String farmActive = "You entered a farm and earned "+randomFarm+ "gold " +(farmDate);
			
			ArrayList<Object> activites = (ArrayList<Object>)session.getAttribute("activites");
			activites.add(farmActive);
			session.setAttribute("activites", activites);
		}
		else if(find1.equals("cave")) {
			Random random = new Random();
			Integer randomCave = random.nextInt(10,21);
			session.setAttribute("randomCave", randomCave);
			Integer randomGold = (Integer) session.getAttribute("gold");
			
			Integer allGold = randomGold + randomCave;
			session.setAttribute("gold", allGold);
			
			Date caveDate = new Date();
			session.setAttribute("caveDate", caveDate);
			String caveActive = "You entered a farm and earned "+randomCave+ "gold " +(caveDate);
			
			ArrayList<Object> activites = (ArrayList<Object>)session.getAttribute("activites");
			activites.add(caveActive);
			session.setAttribute("activites", activites);
		}
		else if(find1.equals("house")) {
			Random random = new Random();
			Integer randomHouse = random.nextInt(10,21);
			session.setAttribute("randomHouse", randomHouse);
			Integer randomGold = (Integer) session.getAttribute("gold");
			
			Integer allGold = randomGold + randomHouse;
			session.setAttribute("gold", allGold);
			
			Date houseDate = new Date();
			session.setAttribute("houseDate", houseDate);
			String houseActive = "You entered a farm and earned "+randomHouse+ "gold " +(houseDate);
			
			ArrayList<Object> activites = (ArrayList<Object>)session.getAttribute("activites");
			activites.add(houseActive);
			session.setAttribute("activites", activites);
		}
		else if(find1.equals("quest")) {
			Random random = new Random();
			Integer randomQuest = random.nextInt(-50,51);
			session.setAttribute("randomQuest", randomQuest);
			if(randomQuest>0) {
				Integer randomGold = (Integer) session.getAttribute("gold");
				Integer allGold = randomGold + randomQuest;
				session.setAttribute("gold", allGold);
				
				Date questDate = new Date();
				session.setAttribute("questDate", questDate);
				String questActive = "You completed a quest and entered "+randomQuest+ "gold " +(questDate);
				
				
				ArrayList<Object> activites = (ArrayList<Object>)session.getAttribute("activites");
				activites.add(questActive);
				session.setAttribute("activites", activites);
				
			}
			else {
				Integer randomGold = (Integer) session.getAttribute("gold");
				Integer allGold = randomGold + randomQuest;
				session.setAttribute("gold", allGold);
				
				Date questDate = new Date();
				session.setAttribute("questDate", questDate);
				String questActive = "You faild a quest and lost "+randomQuest+ "gold " +(questDate);
				
				
				ArrayList<Object> activites = (ArrayList<Object>)session.getAttribute("activites");
				activites.add(questActive);
				session.setAttribute("activites", activites);
			}
			
		}
		
		
		return "redirect:/Gold";
	}
	
	
}


