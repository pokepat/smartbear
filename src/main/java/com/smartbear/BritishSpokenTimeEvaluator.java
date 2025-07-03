package com.smartbear;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.smartbear.constants.ErrorConstants;
import com.smartbear.util.BritishSpokenTimeUtil;

public class BritishSpokenTimeEvaluator {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			while (true) {
				System.out.println("Please enter the time in hh:mm format (Eg. 2:45) : ");
				String input = in.nextLine();
				if (input.equalsIgnoreCase("EXIT")) {
					break;
				}
				String spokenTime = getBritishSpokenTime(input);
				if (spokenTime.contains(ErrorConstants.ERROR_PREFIX)) {
					System.err.println(getBritishSpokenTime(input) + "\n");
				} else {
					System.out.println("The time in British Spoken Form is : " + spokenTime + "\n");
				}
			}
		}
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
			return BritishSpokenTimeUtil.convertToSpokenLanguage(timeInput);
		} catch (DateTimeParseException e) {
			spokenTimeResult = ErrorConstants.INVALID_TIME_FORMAT;
		} catch (Exception e) {
			spokenTimeResult = ErrorConstants.UNEXPECTED_ERROR_OCCURED;
		}
		
		return spokenTimeResult;
	}
}
