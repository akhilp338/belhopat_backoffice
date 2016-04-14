package com.belhopat.backoffice.util;

public class ResponseObject {

	private boolean success;

	private String data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ResponseObject(boolean success, String data) {
		this.success = success;
		this.data = data;
	}

	public ResponseObject() {
	}

}
