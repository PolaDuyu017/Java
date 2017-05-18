package controller;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public ModelAndView hello(){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("greeting", getGreeting());
		mav.addObject("today", getDate());
		
		return mav;
	}
	
	private String getGreeting(){
		
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hour>=6 && hour<=10){
			return "좋은 아침입니다.";
		}else if(hour>=12 && hour<=15){
			return "점심 식사는 하셨나요?";
		}else if(hour>=18 && hour<=22){
			return "좋은 밤 되세요.";
		}
		return "안녕하세요.";

	}
	
	private String getDate(){
		Date day = new Date();
		day.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd h:m");
		String cDate = df.format(day); 
		return cDate;
		
	}
}
