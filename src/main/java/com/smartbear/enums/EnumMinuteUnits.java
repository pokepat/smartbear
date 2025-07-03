package com.smartbear.enums;

public enum EnumMinuteUnits {

	ONE(1, "one"),
	TWO(2, "two"),
	THREE(3, "three"),
	FOUR(4, "four"),
	FIVE(5, "five"),
	SIX(6, "six"),
	SEVEN(7, "seven"),
	EIGHT(8, "eight"),
	NINE(9, "nine"),
	TEN(10, "ten"),
	ELEVEN(11, "eleven"),
	TWELVE(12, "twelve"),
	THIRTEEN(13, "thirteen"),
	FOURTEEN(14, "fourteen"),
	FIFTEEN(15, "fifteen"),
	SIXTEEN(16, "sixteen"),
	SEVENTEEN(17, "seventeen"),
	EIGHTEEN(18, "eighteen"),
	NINETEEN(19, "nineteen");
	
	private final int number;
	private final String word;
	
	EnumMinuteUnits(int number, String word) {
		this.number = number;
		this.word = word;
	}
	
	public String word() {
        return word;
    }

    public static EnumMinuteUnits of(int number) {
        for (EnumMinuteUnits mu : values()) {
            if (mu.number == number) return mu;
        }
        throw new IllegalArgumentException("Unsupported unit minute: " + number);
    }
}
