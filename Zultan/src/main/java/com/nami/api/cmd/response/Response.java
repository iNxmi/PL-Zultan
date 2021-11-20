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
	public static final Response NOT_LONG = new ErrorResponse("You have to enter a long!");
	public static final Response NOT_DOUBLE = new ErrorResponse("You have to enter a double!");

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
