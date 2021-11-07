package com.nami.api.cmd.response;

import com.nami.api.util.MessageType;

public class ResponseWarning extends Response {

	public ResponseWarning(String message) {
		super(message, MessageType.WARNING);
	}

}
