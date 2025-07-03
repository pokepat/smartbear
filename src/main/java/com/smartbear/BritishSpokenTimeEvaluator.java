package com.smartbear;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.smartbear.constants.ErrorConstants;
import com.smartbear.util.BritishSpokenTimeUtil;

public class BritishSpokenTimeEvaluator {

	public static void main(String[] args) {
		System.out.println(getBritishSpokenTime("11:45"));
	}
	
	/**
	 * Method to evaluate the spoken time from given time input
	 * 
	 * @param timeInput in Time format 
	 * @return String result in British English
	 */
	public static String getBritishSpokenTime(String timeInput) {
		String spokenTimeResult = "";
		
		try {
			return BritishSpokenTimeUtil.evaluateTimeInSpokenLanguage(timeInput);
		} catch (DateTimeParseException e) {
			spokenTimeResult = ErrorConstants.INVALID_TIME_FORMAT;
		} catch (Exception e) {
			spokenTimeResult = ErrorConstants.UNEXPECTED_ERROR_OCCURED;
		}
		
		return spokenTimeResult;
	}
}
