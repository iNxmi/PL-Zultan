package com.nami.api.cmd.response;

import com.nami.api.util.MessageType;

public class WarningResponse extends Response {

	public WarningResponse(String message) {
		super(message, MessageType.WARNING);
	}

}
