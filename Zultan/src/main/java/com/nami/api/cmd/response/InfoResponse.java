package com.nami.api.cmd.response;

import com.nami.api.util.MessageType;

public class InfoResponse extends Response {

	public InfoResponse(String message) {
		super(message, MessageType.INFO);
	}

}
