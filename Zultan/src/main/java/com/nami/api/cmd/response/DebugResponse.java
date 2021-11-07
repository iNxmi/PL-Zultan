package com.nami.api.cmd.response;

import com.nami.api.util.MessageType;

public class DebugResponse extends Response {

	public DebugResponse(String message) {
		super(message, MessageType.DEBUG);
	}

}
