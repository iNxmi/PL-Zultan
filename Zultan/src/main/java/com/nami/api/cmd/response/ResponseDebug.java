package com.nami.api.cmd.response;

import com.nami.api.util.MessageType;

public class ResponseDebug extends Response {

	public ResponseDebug(String message) {
		super(message, MessageType.DEBUG);
	}

}
