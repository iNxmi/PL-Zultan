package com.nami.api.plugin.module.command.response;

import com.nami.api.util.MessageType;

public class DebugResponse extends Response {

	public DebugResponse(String message) {
		super(message, MessageType.DEBUG);
	}

}
