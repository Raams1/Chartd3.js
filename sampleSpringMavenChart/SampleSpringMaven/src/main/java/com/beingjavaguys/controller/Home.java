package com.beingjavaguys.controller;

import java.text.ParseException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;





/*import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;*/
import com.cassandra.dao.*;


@Controller
public class Home {
	
	public static String getA() {
		return message1;
	}
	public static void setA(String message1) {
		Home.message1 = message1;
	}
	
	
	
	
	public static String message1;
	String message = "[{State:'AL',freq:{low:4786, mid:1319, high:249}},{State:'AZ',freq:{low:1101, mid:412, high:674}}]";
	//String message = this.message1;
	@RequestMapping("/hello")
	public ModelAndView showMessage() throws ParseException {
		System.out.println("from controller");
		//Java_Json_object a = new Java_Json_object();
		//String message1 = Java_Json_Object.jString();
		
		/*CassandraStoreVisitCounterDAO client1 = new CassandraStoreVisitCounterDAO(
				"test", "generic_counter");
		System.out.println("Cassandra Connection Established");
		System.out.println("Execution Started");

		System.out.println("--------------------------------------");

		// Sample Input : StoreId = macy001, Date (yyyymmdd) = 20150606 ,
		// stateid = 01, merchantid = macy , city-id = city001
		Map<String, Object> message1 = client1.queryStoreDayWiseVisits("H009", "20150717", "20150719", "ST01", "MERTICK20130722004850", "1");
*/		
		
		
		
		
		
		
		
		
		
		System.out.println(message1);
		return new ModelAndView("hello", "message", message1);
	}
	
	
	
	
	
	
	
	
	
	
	//String message = ;
	@RequestMapping("/hello4")
	public ModelAndView showMessage4() throws ParseException {
		System.out.println("from controller4");
		String message1 = Java_Json_Object.jString4();
		//CassandraStoreVisitCounterDAO client = new CassandraStoreVisitCounterDAO("test", "generic_counter");
		//Map<String, Object> message1 = client.queryStoreDayWiseVisits("H009", "20150717", "20150717", "ST01", "MERTICK20130722004850", "1");
		System.out.println(message1);
		String message2= message1.toString();
		return new ModelAndView("hello4", "message", message2);
		
	}
	
	
	
	
	
	@RequestMapping("/hello5")
	public ModelAndView showMessage1() {
		System.out.println("from controller5");
		String message = Java_Json_Object.jString();
		return new ModelAndView("/hello5", "message", message);
		
	}
	
	
	@RequestMapping("/hello6")
	public ModelAndView showMessage6() {
		System.out.println("from controller6");
		String message = Java_Json_Object.jString();
		return new ModelAndView("hello6", "message", message);
		
	}
	
	
	@RequestMapping("/hello7")
	public ModelAndView showMessage7() {
		System.out.println("from controller7");
		String message = Java_Json_Object.pieJString();
		System.out.println(message);
		return new ModelAndView("hello7", "message", message);
		
	}
	
	
	@RequestMapping("/linechart")
	public ModelAndView showMessage8() {
		System.out.println("from controller8");
		String message = Java_Json_Object.lineJString();
		System.out.println(message);
		return new ModelAndView("linechart", "message", message);
		
	}
	
	
	public static final String INSTALL_APP_EVENT_LOG = "/event";
	
	/*@RequestMapping(value = INSTALL_APP_EVENT_LOG, method = RequestMethod.POST)
		public @ResponseBody
		String createAppLog(@RequestBody String message1) {
		Home.message1 = message1;
		System.out.println(message1);
			return message1;
	}*/
	
	
}

