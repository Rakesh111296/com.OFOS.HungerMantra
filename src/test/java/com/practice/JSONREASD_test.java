package com.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONREASD_test {

	public static void main(String[] args) throws Throwable {
		
		//Reading the Json File Path
		FileReader fi = new FileReader(".\\src\\test\\resources\\JSONDATA.json");
		//creating the Json Parser so it can concert Json to java readable formt
		JSONParser jobj = new JSONParser();
		//storing in file in Object formt
		Object obj = jobj.parse(fi);
		//reading the Json File
		JSONObject map =  (JSONObject) obj;
		
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		
	
		
	}
}
