package com.smartbear.enums;

public enum EnumHourUnits {

	ZERO(0, "zero"),
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
	TWELVE(12, "twelve");
	
	private final int number;
	private final String word;
	
	EnumHourUnits(int number, String word) {
		this.number = number;
		this.word = word;
	}
	
	
	public String word() {
        return word;
    }

    public static EnumHourUnits of(int number) {
        for (EnumHourUnits h : values()) {
            if (h.number == number) return h;
        }
        throw new IllegalArgumentException("Unsupported hour: " + number);
    }
	
}
