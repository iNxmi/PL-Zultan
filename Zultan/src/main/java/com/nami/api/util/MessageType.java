package com.nami.api.util;

public enum MessageType {

	NONE("%"), INFO("[INFO] §3%"), WARNING("[WARNING] §e%"), ERROR("[ERROR] §c%"), DEBUG("[DEBUG] §d%"),
	EASTEREGG("[EASTEREGG] §6%");

	private String format;

	MessageType(String format) {
		this.format = format;
	}

	public String getMessage(String message) {
		return format.replace("%", message);
	}

}
