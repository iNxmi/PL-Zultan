package com.nami.api.cmd.response;

import com.nami.api.util.MessageType;

public class ResponseInfo extends Response {

	public ResponseInfo(String message) {
		super(message, MessageType.INFO);
	}

}
