package com.cassandra.dao;

public class Java_Json_Object {
public static String jString()
{
	String a = "[{State:'AL',freq:{low:4786, mid:1319, high:249}},{State:'AZ',freq:{low:1101, mid:412, high:674}}]";
	return a;
}
public static String jString4()
{
	String a = "[{'x': 1,'y': 5}, {'x': 20,'y': 20}, {'x': 40,'y': 10}, {'x': 60,'y': 40}, {'x': 80,'y': 5}, {'x': 100,'y': 60}]";
	return a;
}

public static String pieJString()
{
	//String a = "[{'age': '5', 'population': 20},{'age': '10', 'population': 20},{'age': '14', 'population': 30},{'age': '18', 'population': 10},{'age': '65', 'population': 10}]";
	String a= "[{'label':'5', 'value':20},{'label':'6', 'value':50}, {'label':'9', 'value':30},{'label':'10', 'value':30}]";
	
	return a;
}

public static String lineJString()
{
	
	String a= "[{'Client': 'ABC','sale': '202','year': '2000'}, {'Client': 'ABC','sale': '215','year': '2002'},{'Client': 'ABC','sale': '199','year': '2006'}, {'Client': 'ABC','sale': '134','year': '2008'}, {'Client': 'ABC','sale': '176','year': '2010'}]";
	return a;
}

}