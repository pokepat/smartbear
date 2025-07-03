package com.smartbear.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.smartbear.constants.BritishSpokenTimeConstants;
import com.smartbear.enums.EnumHourUnits;
import com.smartbear.enums.EnumMinuteTens;
import com.smartbear.enums.EnumMinuteUnits;

public class BritishSpokenTimeUtil {

	public static String convertToSpokenLanguage(String timeInput) throws DateTimeParseException {
		LocalTime time = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern(BritishSpokenTimeConstants.HOUR_MIN_PATTERN)); // used for input validation
		int hour = time.getHour();
		int minute = time.getMinute();
		
		// Midnight & noon cases
		if (hour == 0 && minute == 0) return BritishSpokenTimeConstants.MIDNIGHT;
        if (hour == 12 && minute == 0) return BritishSpokenTimeConstants.NOON;
		
        int twelveHourFormat = hour % 12 == 0 ? 12 : hour % 12;
        String spokenHour = EnumHourUnits.of(twelveHourFormat).word();
        
        
        // For minutes 15, 30 & 45
        if (minute == 0) {
            return spokenHour + BritishSpokenTimeConstants.OCLOCK;
        } else if (minute == 15) {
            return BritishSpokenTimeConstants.QUARTER_PAST + spokenHour;
        } else if (minute == 30) {
            return BritishSpokenTimeConstants.HALF_PAST + spokenHour;
        } else if (minute == 45) {
            return "quarter to " + getNextHourWord(hour);
        }
        
        // For minutes divisible by 5 (according to testcases given in assignment)
        if (minute % 5 == 0) {
            if (minute < 30) {
                return minute + " minutes past " + spokenHour;
            } else {
                int remaining = 60 - minute;
                return remaining + " minutes to " + getNextHourWord(hour);
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
