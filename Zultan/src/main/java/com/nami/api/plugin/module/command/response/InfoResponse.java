package com.nami.api.plugin.module.command.response;

import com.nami.api.util.MessageType;

public class InfoResponse extends Response {

	public InfoResponse(String message) {
		super(message, MessageType.INFO);
	}

}
