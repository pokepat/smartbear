package com.smartbear.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BritishSpokenTimeUtil {

	
	public static String evaluateTimeInSpokenLanguage(String timeInput) throws DateTimeParseException {
		LocalTime time = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("H:mm")); // used for input validation
		
	}
	
}
