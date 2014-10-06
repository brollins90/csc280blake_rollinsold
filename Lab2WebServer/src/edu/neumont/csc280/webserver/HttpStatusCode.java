package edu.neumont.csc280.webserver;

public enum HttpStatusCode {
	OK(200, "OK"), NotFound404(404, "File Not Found"), ERROR500(500, "Internal Server Error");

	private final int value;
	private final String string;

	HttpStatusCode(int value, String string) {
		this.value = value;
		this.string = string;
	}

	public int getValue() {
		return value;
	}

	public String getString() {
		return string;
	}

	public static HttpStatusCode GetByValue(int value) {
		for (HttpStatusCode c : values()) {
			if (c.value == value) {
				return c;
			}
		}
		return HttpStatusCode.ERROR500;
	}

}
