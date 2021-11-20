package com.nami.api.cmd.check;

import com.nami.api.cmd.response.Response;

public class CheckResponse {

	private boolean shouldReturn;
	private Response response;

	public CheckResponse(boolean shouldReturn, Response response) {
		this.shouldReturn = shouldReturn;
		this.response = response;
	}

	public boolean shouldReturn() {
		return shouldReturn;
	}

	public Response getResponse() {
		return response;
	}

}
