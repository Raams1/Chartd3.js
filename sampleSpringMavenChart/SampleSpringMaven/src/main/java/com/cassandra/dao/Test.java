package com.cassandra.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import com.amazonaws.util.json.JSONObject;

public class Test {
void test() throws ParseException, JsonGenerationException, JsonMappingException, IOException{
	CassandraStoreVisitCounterDAO client = new CassandraStoreVisitCounterDAO("test", "generic_counter");
	Map<String, Object> message1 = client.queryStoreDayWiseVisits("H009", "20150717", "20150717", "ST01", "MERTICK20130722004850", "1");
	System.out.println(message1);
	ObjectMapper objectMapper = new ObjectMapper();
	 JsonGenerator w = null;
	objectMapper.writeValue(w,message1);
	System.out.println(w);
	//String message2= message1.toString();
	//System.out.println(message2);
	/*JSONObject json = new JSONObject();
    ((Map<String, Object>) json).putAll( message1 );*/
    //System.out.printf( "JSON: %s", json.toString(2) );
	//JSONObject jsonObject = JSONObject.fromObject(message1);
	//System.out.println(json);
	
	
	/*Map<String, Object> data = new HashMap<String, Object>();
    data.put( "name", "Mars" );
    data.put( "age", 32 );
    data.put( "city", "NY" );
    System.out.println(data);
    JSONObject json = new JSONObject();
    json.putAll( data );
    System.out.printf( "JSON: %s", json.toString() );*/
	
}
public static void main(String[] args) throws ParseException, JsonGenerationException, JsonMappingException, IOException {
	Test a = new Test();
	a.test();
}
}
