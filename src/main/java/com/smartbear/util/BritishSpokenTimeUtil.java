package com.smartbear.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.smartbear.constants.TimeConstants;
import com.smartbear.enums.EnumHourUnits;
import com.smartbear.enums.EnumMinuteTens;
import com.smartbear.enums.EnumMinuteUnits;

public class BritishSpokenTimeUtil {

	public static String convertToSpokenLanguage(String timeInput) throws DateTimeParseException {
		
		LocalTime time = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern(TimeConstants.HOUR_MIN_PATTERN)); // used for input validation
		int hour = time.getHour();
		int minute = time.getMinute();
		
		// Midnight & noon cases
		if (hour == 0 && minute == 0) return TimeConstants.MIDNIGHT;
        if (hour == 12 && minute == 0) return TimeConstants.NOON;
		
        int twelveHourFormat = hour % 12 == 0 ? 12 : hour % 12;
        String spokenHour = EnumHourUnits.of(twelveHourFormat).word();
        
        
        // For minutes 15, 30 & 45
        if (minute == 0) {
            return spokenHour + TimeConstants.OCLOCK;
        } else if (minute == 15) {
            return TimeConstants.QUARTER + TimeConstants.PAST + spokenHour;
        } else if (minute == 30) {
            return TimeConstants.HALF + TimeConstants.PAST + spokenHour;
        } else if (minute == 45) {
            return TimeConstants.QUARTER + TimeConstants.TO + getNextHourWord(hour);
        }
        
        // For minutes divisible by 5 (according to testcases given in assignment)
        if (minute % 5 == 0) {
        	// use minutes past if they are less than 30
            if (minute < 30) {
                return minuteToWords(minute) + TimeConstants.PAST + spokenHour;
            } else {
            	// else use minutes to
                int remaining = 60 - minute;
                return minuteToWords(remaining) + TimeConstants.TO + getNextHourWord(hour);
            }
        }
        
        // By default - return actual minutes in words
        return spokenHour + " " + minuteToWords(minute);
		
	}

	private static String getNextHourWord(int hour) {
		int nextHour = (hour + 1) % 24;
		return EnumHourUnits.of(nextHour % 12 == 0 ? 12 : nextHour % 12).word();
	}
	
	private static String minuteToWords(int minute) {
        // Get from MinuteUnits upto 19
		if (minute < 20) {
            return EnumMinuteUnits.of(minute).word();
        }

        int tens = (minute / 10) * 10;
        int units = minute % 10;

        String tensWord = EnumMinuteTens.of(tens).word();
        return units == 0 ? tensWord
        		: tensWord + " " + EnumMinuteUnits.of(units).word();
    }
	
}
