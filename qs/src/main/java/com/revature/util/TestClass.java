package com.revature.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClass {
	public static void main(String[] args) {
		 Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		 try {
			Date date = dateFormat.parse("2017-04-26T20:55:00.000Z");
			System.out.println(date.compareTo(now));
			if(date.compareTo(now)<0) {
				System.out.print("good Java");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
