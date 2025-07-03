package com.smartbear.enums;

public enum EnumMinuteTens {
	// TEN is covered in EnumMinuteUnits
	TWENTY(20, "twenty"),
	THIRTY(30, "thirty"),
	FORTY(40, "forty"),
	FIFTY(50, "fifty");

	private final int number;
	private final String word;
	
	EnumMinuteTens(int number, String word) {
		this.number = number;
		this.word = word;
	}
	
	public String word() {
        return word;
    }

    public static EnumMinuteTens of(int number) {
        for (EnumMinuteTens mt : values()) {
            if (mt.number == number) return mt;
        }
        throw new IllegalArgumentException("Unsupported tens minute: " + number);
    }
	
	
	
	
}
