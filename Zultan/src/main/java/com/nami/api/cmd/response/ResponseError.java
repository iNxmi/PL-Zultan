package com.nami.api.cmd.response;

import com.nami.api.util.MessageType;

public class ResponseError extends Response {

	public ResponseError(String message) {
		super(message, MessageType.ERROR);
	}

}
