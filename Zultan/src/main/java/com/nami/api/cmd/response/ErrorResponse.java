package com.nami.api.cmd.response;

import com.nami.api.util.MessageType;

public class ErrorResponse extends Response {

	public ErrorResponse(String message) {
		super(message, MessageType.ERROR);
	}

}
