package com.nami.api.util;

public enum MessageType {

	NONE("%"), INFO("[§3INFO§r] §3%"), WARNING("[§eWARNING§r] §e%"), ERROR("[§cERROR§r] §c%"), DEBUG("[§dDEBUG§r] §d%"),
	EASTEREGG("[§6EASTEREGG§r] §6%");

	private String format;

	MessageType(String format) {
		this.format = format;
	}

	public String getMessage(String message) {
		return format.replace("%", message);
	}

}
