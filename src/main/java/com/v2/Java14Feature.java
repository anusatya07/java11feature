package com.v2;

public class Java14Feature {
	private String id;

	public String getId() {
		return id;
	}

	public static void main(String[] args) {
		// 1. break and yield method
		String day = "";
		String result = switch (day) {
		case "M", "W", "F" -> "MWF";
		case "T", "TH", "S" -> "TTS";
		default -> {
			if (day.isEmpty())
				yield "Please insert a valid day.";
			else
				yield "Looks like a Sunday.";
		}

		};
		System.out.println(result);
		// 2. Pattern Matching for instanceof
		Object obj = null;
		if (obj instanceof Java14Feature jd) {
			System.out.println(jd.getId());
		}
	}
}