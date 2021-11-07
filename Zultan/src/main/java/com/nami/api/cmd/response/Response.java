package com.nami.api.cmd.response;

import com.nami.api.util.MessageType;

public abstract class Response {

	public static final Response NONE = new ResponseNull();
	public static final Response SUCCESS = new ResponseNull();
	public static final Response SYNTAX_ERROR = new ResponseError("No command with this syntax!");
	public static final Response NOT_CONSOLE = new ResponseError("This command can only be executed as console!");
	public static final Response NOT_PLAYER = new ResponseError("This command can only be executed as a player!");
	public static final Response NO_PERM = new ResponseError(
			"U don't have enough permissions to execute this command!");
	public static final Response TARGET_NOT_EXIST = new ResponseError("This player does not exist!");
	public static final Response TARGET_NOT_ONLINE = new ResponseError("This player is not online!");
	public static final Response TARGET_NOT_PLAYER = new ResponseError("You cant target yourself!");
	public static final Response INTERNAL_ERROR = new ResponseError("An internal error occurred!");

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
