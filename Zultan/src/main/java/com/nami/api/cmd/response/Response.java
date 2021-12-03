package com.nami.api.cmd.response;

import com.nami.api.util.MessageType;

public abstract class Response {

	public static final Response NONE = new NullResponse();
	public static final Response SUCCESS = new NullResponse();
	public static final Response SYNTAX_ERROR = new ErrorResponse("No command with this syntax!");
	public static final Response NOT_CONSOLE = new ErrorResponse("This command can only be executed as console!");
	public static final Response NOT_PLAYER = new ErrorResponse("This command can only be executed as a player!");
	public static final Response NO_PERM = new ErrorResponse(
			"You don't have enough permissions to execute this command!");
	public static final Response TARGET_NOT_EXIST = new ErrorResponse("This player does not exist!");
	public static final Response TARGET_NOT_ONLINE = new ErrorResponse("This player is not online!");
	public static final Response TARGET_NOT_PLAYER = new ErrorResponse("You cant target yourself!");
	public static final Response INTERNAL_ERROR = new ErrorResponse("An internal error occurred!");

	public static final Response NOT_BYTE = new ErrorResponse(
			"You have to enter a byte! (" + Byte.MIN_VALUE + " - " + Byte.MAX_VALUE + ")");
	public static final Response NOT_SHORT = new ErrorResponse(
			"You have to enter a short! (" + Short.MIN_VALUE + " - " + Short.MAX_VALUE + ")");
	public static final Response NOT_INTEGER = new ErrorResponse(
			"You have to enter a integer! (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
	public static final Response NOT_LONG = new ErrorResponse(
			"You have to enter a long! (" + Long.MIN_VALUE + " - " + Long.MAX_VALUE + ")");
	public static final Response NOT_FLOAT = new ErrorResponse(
			"You have to enter a float! (" + Float.MIN_VALUE + " - " + Float.MAX_VALUE + ")");
	public static final Response NOT_DOUBLE = new ErrorResponse(
			"You have to enter a double! (" + Double.MIN_VALUE + " - " + Double.MAX_VALUE + ")");

	public static final Response COMMING_SOON = new ErrorResponse(
			"This feautre has not been implemented yet! comming soon!");

	private String message;
	private MessageType type;

	public Response(String message, MessageType type) {
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public MessageType getMessageType() {
		return type;
	}

}
