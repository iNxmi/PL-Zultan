package com.nami.api.plugin.module.command.response;

import com.nami.api.util.MessageType;

public class ErrorResponse extends Response {

	public ErrorResponse(String message) {
		super(message, MessageType.ERROR);
	}

}
