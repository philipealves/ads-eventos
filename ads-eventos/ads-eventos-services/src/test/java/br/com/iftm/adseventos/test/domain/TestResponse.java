package br.com.iftm.adseventos.test.domain;

import javax.ws.rs.core.Response.Status;

public class TestResponse {

	private Status status;
	private String content;

	public Status getStatus() {
		return status;
	}

	public void setStatus(int code) {
		this.status = Status.fromStatusCode(code);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
