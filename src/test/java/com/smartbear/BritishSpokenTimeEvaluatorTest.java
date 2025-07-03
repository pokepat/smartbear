package com.smartbear;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.smartbear.constants.ErrorConstants;
import com.smartbear.util.BritishSpokenTimeUtil;

public class BritishSpokenTimeEvaluatorTest {

	@ParameterizedTest
	@MethodSource("provideTimeAndExpectedSpokenForms")
	void convertToSpokenLanguageTest(String input, String expectedOutput) {
		Assert.assertEquals(expectedOutput, BritishSpokenTimeEvaluator.getBritishSpokenTime(input));
	}
	
	static Stream<Arguments> provideTimeAndExpectedSpokenForms() {
        return Stream.of(
        	// Given test cases
            Arguments.of("1:00", "one o'clock"),
            Arguments.of("2:05", "five past two"),
            Arguments.of("3:10", "ten past three"),
            Arguments.of("4:15", "quarter past four"),
            Arguments.of("5:20", "twenty past five"),
            Arguments.of("6:25", "twenty five past six"),
            Arguments.of("6:32", "six thirty two"),
            Arguments.of("7:30", "half past seven"),
            Arguments.of("7:35", "twenty five to eight"),
            Arguments.of("8:40", "twenty to nine"),
            Arguments.of("9:45", "quarter to ten"),
            Arguments.of("10:50", "ten to eleven"),
            Arguments.of("11:55", "five to twelve"),
            Arguments.of("00:00", "midnight"),
            Arguments.of("12:00", "noon"),
            
            // Extra test cases
            Arguments.of("12:23", "twelve twenty three"),
            Arguments.of("0:50", "ten to one"),
            Arguments.of("00:44", "twelve forty four"),
            Arguments.of("23:00", "eleven o'clock"),
            Arguments.of("2:00", "two o'clock"),
            Arguments.of("23:40", "twenty to twelve"),
            Arguments.of("11:40", "twenty to twelve"),
            Arguments.of("23:30", "half past eleven"),
            Arguments.of("22:22", "ten twenty two"),
            Arguments.of("13:41", "one forty one"),
            Arguments.of("13:03", "one three"),
            
            // Error Cases
            Arguments.of("13 :03", ErrorConstants.INVALID_TIME_FORMAT),
            Arguments.of("13:0", ErrorConstants.INVALID_TIME_FORMAT),
            Arguments.of("233:03", ErrorConstants.INVALID_TIME_FORMAT),
            Arguments.of("13.55", ErrorConstants.INVALID_TIME_FORMAT),
            Arguments.of("abcd", ErrorConstants.INVALID_TIME_FORMAT)
            
        );
    }
	
}
